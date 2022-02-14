package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;

public class Qiqihaer02 implements GetArea{

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
        // area2 - 齐齐哈尔市 - rea_level = 2
        Area area2201 = Area.builder().id(2201L).name("沙龙区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2202 = Area.builder().id(2202L).name("建华区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2203 = Area.builder().id(2203L).name("铁峰区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2204 = Area.builder().id(2204L).name("昂昂溪区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2205 = Area.builder().id(2205L).name("富拉尔基区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2206 = Area.builder().id(2206L).name("碾子山区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2207 = Area.builder().id(2207L).name("梅里斯达斡尔族区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2208 = Area.builder().id(2208L).name("龙江县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2209 = Area.builder().id(2209L).name("依安县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2210 = Area.builder().id(2210L).name("泰来县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2211 = Area.builder().id(2211L).name("甘南县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2212 = Area.builder().id(2212L).name("富裕县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2213 = Area.builder().id(2213L).name("克山县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2214 = Area.builder().id(2214L).name("克东县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2215 = Area.builder().id(2215L).name("拜泉市").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area2216 = Area.builder().id(2216L).name("讷河市").father(fatherArea).area_level(2).risk_level(1).children(null).build();

        Area[] areas = new Area[]{area2201,area2202,area2203,area2204,area2205,area2206,area2207,area2208,area2209,area2210,area2211,area2212,area2213,area2214,area2215,area2216};

        return areas;
    }
}
