package com.example.test2.Service.PrimaryService.Impl;
import com.example.test2.Mapper.Primary.AreaStoreTableMapper;
import com.example.test2.POJO.Area;
import com.example.test2.POJO.AreaStoreTable;
import com.example.test2.Service.PrimaryService.AreaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("AreaStoreService")
public class AreaStoreServiceImpl implements AreaStoreService {

    private AreaStoreTableMapper areaStoreTableMapper;

    @Autowired
    public AreaStoreServiceImpl(AreaStoreTableMapper areaStoreTableMapper) {
        this.areaStoreTableMapper = areaStoreTableMapper;
    }

    public AreaStoreTable getAreaById(Long area_id){
        return areaStoreTableMapper.getAreaById(area_id);
    }

    public boolean isExistArea(Long area_id){
        return areaStoreTableMapper.isExistArea(area_id)==1;
    }


    public Area convertToArea(Long area_id){
        return new ConvertToAreaHandler(area_id, areaStoreTableMapper).getRes();
    }



    /**
     * 内部工具类，将存储结构转换为Area
     */
    static class ConvertToAreaHandler{

        private Long area_id;
        private AreaStoreTableMapper areaStoreTableMapper;

        public ConvertToAreaHandler(Long area_id, AreaStoreTableMapper areaStoreTableMapper) {
            this.area_id = area_id;
            this.areaStoreTableMapper = areaStoreTableMapper;
        }

        public Area recursion(Long area_id, Area father){

            AreaStoreTable store = areaStoreTableMapper.getAreaById(area_id);

            Long id = store.getId();
            String name = store.getName();
            Integer area_level = store.getArea_level();
            Integer risk_level = store.getRisk_level();

            Area cur = new Area(id, name, risk_level, area_level, null, father);


            if (store.getChildren()!=null && store.getChildren().length()>0){
                Long[] childIds = Area.convertChildStringToIdArray(store.getChildren());
                Area[] ch = new Area[childIds.length];
                for (int i = 0; i <ch.length; i++) {
                    ch[i] = recursion(childIds[i],cur);
                }
                cur.setChildren(ch);
            }
            return cur;
        }


        public Area getRes(){
            return recursion(area_id,null);
        }




    }

    /**
     *
     * 内部工具类，
     */
    static class convertToAreaStoreHandler {
        private AreaStoreTableMapper storeTableMapper;
        private Area menu;
        private int successfulTimes = 0;

        public convertToAreaStoreHandler(AreaStoreTableMapper storeTableMapper, Area menu) {
            this.storeTableMapper = storeTableMapper;
            this.menu = menu;
        }

        //递归插入
        private Long recursion(Area area){

            AreaStoreTable store = new AreaStoreTable();
            store.setId(area.getId());
            store.setArea_level(area.getArea_level());
            store.setFather_id(area.getFather().getId());
            store.setName(area.getName());
            store.setRisk_level(area.getRisk_level());


            Area[] children = area.getChildren();
            if (children==null || children.length==0){
                store.setChildren(null);
                if (checkSafe(area.getId())){//数据库中不存在当前节点
                    int i = storeTableMapper.insertNewAreaStore(store); //叶子节点插入数据库
                    if (i==1)successfulTimes++;
                }
                return area.getId();
            }

            StringBuilder childStr = new StringBuilder();
            for (int i = 0; i < children.length; i++) {
                childStr.append(recursion(children[i]));
                childStr.append(",");
            }
            childStr.deleteCharAt(childStr.length()-1);
            store.setChildren(childStr.toString());
            if (checkSafe(area.getId())){ //数据库中不存在
                int i = storeTableMapper.insertNewAreaStore(store); //插入当前节点
                if (i == 1) successfulTimes++;
            }
            return area.getId();
        }

        public int getRes(){
            recursion(menu);
            return successfulTimes;
        }

        private boolean checkSafe(Long id){
            if (id==null)return true;
            if (storeTableMapper.isExistArea(id)==1) {
                return false;
            }
            return true;
        }
    }


    static class travelArea{
        List<Area> res;
        Area root;

        public travelArea(List<Area> res, Area root) {
            this.res = res;
            this.root = root;
            res = new LinkedList<>();
            recursion(root);
        }

        public String getStringTravel(){
            return res.toString();
        }

        public List<Area> getListTravel(){
            return res;
        }

        private void recursion(Area root){
            if (root==null)return;
            res.add(root);
            Area[] children = root.getChildren();
            if (children!=null){
                for (int i = 0; i < children.length; i++) {
                    recursion(children[i]);
                }
            }
        }
    }
}
