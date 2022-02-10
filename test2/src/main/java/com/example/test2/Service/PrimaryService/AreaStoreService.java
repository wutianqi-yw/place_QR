package com.example.test2.Service.PrimaryService;

import com.example.test2.POJO.Area;
import com.example.test2.POJO.AreaStoreTable;

import java.util.List;

public interface AreaStoreService {

    public AreaStoreTable getAreaById(Long area_id);

    /**
     *
     * 将存储结构转化为内存结构
     *
     * @param area_id area的id
     * @return 内存结构Area
     */
    public Area convertToArea(Long area_id);

    public boolean isExistArea(Long area_id);

    /**
     * 将内存结构Area转化为存储结构
     * @param area 内存结构Area
     * @return 成功插入的节点数目
     */
    public int AreaConvertToStore(Area area);


    /**
     *
     * 遍历Area 用于排错.将多叉树的所有节点，都存入List中
     *
     * @param area 目标area
     * @return
     */
    public List<Area> travelArea(Area area);
}
