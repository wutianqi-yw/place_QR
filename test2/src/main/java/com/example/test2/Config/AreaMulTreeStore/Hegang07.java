package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;

public class Hegang07 implements GetArea{
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
        // area7 - 鹤岗市 - rea_level = 2
        Area area7201 = Area.builder().id(7201L).name("向阳区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area7202 = Area.builder().id(7202L).name("工农区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area7203 = Area.builder().id(7203L).name("南山区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area7204 = Area.builder().id(7204L).name("兴安区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area7205 = Area.builder().id(7205L).name("东山区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area7206 = Area.builder().id(7206L).name("兴山区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area7207 = Area.builder().id(7207L).name("萝北县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area7208 = Area.builder().id(7208L).name("绥滨县").father(fatherArea).area_level(2).risk_level(1).children(null).build();

        // setter - area7 鹤岗市
        return new Area[]{area7201,area7202,area7203,area7204,area7205,area7206,area7207,area7208};
    }
}
