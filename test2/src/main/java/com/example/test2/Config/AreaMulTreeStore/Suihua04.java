package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;

public class Suihua04 implements GetArea {

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
        // area3 - 七台河市 - rea_level = 2
        Area area3201 = Area.builder().id(3101L).name("新兴区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area3202 = Area.builder().id(3202L).name("桃山区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area3203 = Area.builder().id(3203L).name("茄子河区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area3204 = Area.builder().id(3204L).name("勃利县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area3205 = Area.builder().id(3205L).name("经济开发区").father(fatherArea).area_level(2).risk_level(1).children(null).build();

        Area[] areas = new Area[]{area3201,area3202,area3203,area3204,area3205};

        return areas;
    }
}
