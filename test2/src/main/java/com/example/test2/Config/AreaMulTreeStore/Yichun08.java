package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;

public class Yichun08 implements GetArea {

    @Override
    public void setAreaStore(Area fatherArea){
        fatherArea.setChildren(getLevel02(fatherArea));
    }

    /**
     * 设置 ‘区级’ 子孩子
     * @param fatherArea
     * @return
     */
    private Area[] getLevel02(Area fatherArea) {
        // area8 - 伊春市 - rea_level = 2
        Area area8201 = Area.builder().id(8201L).name("伊美区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8202 = Area.builder().id(8202L).name("乌翠区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8203 = Area.builder().id(8203L).name("友好区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8204 = Area.builder().id(8204L).name("金林区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8205 = Area.builder().id(8205L).name("嘉荫县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8206 = Area.builder().id(8206L).name("汤旺县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8207 = Area.builder().id(8207L).name("丰林县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8208 = Area.builder().id(8208L).name("大箐山县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8209 = Area.builder().id(8209L).name("南岔县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area8210 = Area.builder().id(8210L).name("铁力县").father(fatherArea).area_level(2).risk_level(1).children(null).build();

        Area[] areas = new Area[]{area8201,area8202,area8203,area8204,area8205,area8206,area8207,area8208,area8209,area8210};

        return areas;
    }
}
