package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;

public class SenGong06 implements GetArea{

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
        // area6 - 森工 - rea_level = 2
        Area area6201 = Area.builder().id(6201L).name("绥阳林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6202 = Area.builder().id(6202L).name("林口林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6203 = Area.builder().id(6203L).name("穆棱林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6204 = Area.builder().id(6204L).name("柴河林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6205 = Area.builder().id(6205L).name("海林林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6206 = Area.builder().id(6206L).name("大海林林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6207 = Area.builder().id(6207L).name("京东城林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6208 = Area.builder().id(6208L).name("八面通林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6209 = Area.builder().id(6209L).name("沾河林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6210 = Area.builder().id(6210L).name("通北林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6211 = Area.builder().id(6211L).name("绥棱林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6212 = Area.builder().id(6212L).name("兴隆林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6213 = Area.builder().id(6213L).name("方正林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6214 = Area.builder().id(6214L).name("苇河林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6215 = Area.builder().id(6215L).name("亚布力林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6216 = Area.builder().id(6216L).name("山河屯林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6217 = Area.builder().id(6217L).name("鹤北林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6218 = Area.builder().id(6218L).name("鹤立林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6219 = Area.builder().id(6219L).name("桦南林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6220 = Area.builder().id(6220L).name("清河林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6221 = Area.builder().id(6221L).name("迎春林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6222 = Area.builder().id(6222L).name("双鸭山林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area6223 = Area.builder().id(6223L).name("东方红林业局").father(fatherArea).area_level(2).risk_level(1).children(null).build();

        Area[] areas = new Area[]{area6201,area6202,area6203,area6204,area6205,area6206,area6207,area6208,area6209,area6210,area6211,area6212,area6213,area6214,area6215,area6216,area6217,area6218,area6219,area6220,area6221,area6222,area6223};

        return areas;
    }
}
