package com.example.test2.Controllers;

import com.example.test2.Service.PrimaryService.PlaceForNormalService;
import com.example.test2.Service.SecondaryService.QRRecordsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HelloController {

    private QRRecordsService qrRecordsService;
    private PlaceForNormalService placeForNormalService;

    @Autowired
    public HelloController(QRRecordsService qrRecordsService,PlaceForNormalService placeForNormalService) {
        this.qrRecordsService = qrRecordsService;
        this.placeForNormalService = placeForNormalService;
    }

    @RequestMapping("/Secondary")
    public String hellSecondary(){
        int newDateTable = qrRecordsService.createNewDateTable();
        return newDateTable+"";
    }

    @RequestMapping("/Primary")
    public HashMap<Object, Object> helloPrimary(@Param("id") Long place_id){
        return placeForNormalService.getPlaceById(place_id);
    }
}
