package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;

public class Daxinganling05 implements GetArea {

    @Override
    public void setAreaStore(Area fatherArea) {
        fatherArea.setChildren(getLevel02(fatherArea));
    }

    /**
     * 设置 ‘区级’ 子孩子
     *
     * @param fatherArea
     * @return
     */
    private Area[] getLevel02(Area fatherArea) {

        // area5 - 大兴安岭地区 - rea_level = 2
        Area area5201 = Area.builder().id(5201L).name("加格达奇区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area5202 = Area.builder().id(5202L).name("松岭区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area5203 = Area.builder().id(5203L).name("新林区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area5204 = Area.builder().id(5204L).name("呼中区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area5205 = Area.builder().id(5205L).name("漠河市").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area5206 = Area.builder().id(5206L).name("呼玛县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area5207 = Area.builder().id(5207L).name("塔河县").father(fatherArea).area_level(2).risk_level(1).children(null).build();

        // setter - area5 大兴安岭地区
        return new Area[]{area5201, area5202, area5203, area5204, area5205, area5206, area5207};
    }
}
