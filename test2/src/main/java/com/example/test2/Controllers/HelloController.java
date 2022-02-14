package com.example.test2.Controllers;

import com.example.test2.POJO.Area;
import com.example.test2.POJO.Result;
import com.example.test2.Service.PrimaryService.AreaStoreService;
import com.example.test2.Service.PrimaryService.PlaceForNormalService;
import com.example.test2.Service.SecondaryService.QRRecordsService;
import com.example.test2.Util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class HelloController {

    private QRRecordsService qrRecordsService;
    private PlaceForNormalService placeForNormalService;
    private AreaStoreService areaStoreService;

    @Resource(name = "myArea")
    private Area[] areas;

    @Autowired
    public HelloController(QRRecordsService qrRecordsService,PlaceForNormalService placeForNormalService,
                           AreaStoreService areaStoreService) {
        this.qrRecordsService = qrRecordsService;
        this.placeForNormalService = placeForNormalService;
        this.areaStoreService = areaStoreService;
    }

    @RequestMapping("/Secondary")
    public String hellSecondary(){
        int newDateTable = qrRecordsService.createNewDateTable();
        return newDateTable+"";
    }

    @RequestMapping("/Primary")
    public HashMap<Object, Object> helloPrimary(@RequestParam("id") Long place_id){
        return placeForNormalService.getPlaceById(place_id);
    }

    @RequestMapping("/doAreaTrees")
    public JsonResult<Integer> doInsert(){
        int i = 0;
        for (Area area : areas) {
            i = areaStoreService.AreaConvertToStore(area);
            i+=i;
        }

        HashMap<Object, Object> map = new HashMap<>();
        map.put("成功插入次数",i);
        return JsonResult.getInstance(200,"调用成功",i);
    }

}
