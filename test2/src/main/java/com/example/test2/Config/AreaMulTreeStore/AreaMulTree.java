package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@DependsOn({"AreaStoreService"})
public class AreaMulTree {

    // 默认城市多叉树
    // 1-市、2-县(区)、3-镇(街道)、4-村(社区)、5-屯
    @Bean("defaultCityStoreTree")
    public Area[] getDefaultCityStoreTree() {

        // area_level = 1
        Area area1 = Area.builder().id(1L).name("哈尔滨市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area2 = Area.builder().id(2L).name("齐齐哈尔市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area3 = Area.builder().id(2L).name("七台河市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area4 = Area.builder().id(4L).name("绥化市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area5 = Area.builder().id(5L).name("大兴安岭地区").father(null).area_level(1).risk_level(1).children(null).build();
        Area area6 = Area.builder().id(6L).name("森工").father(null).area_level(1).risk_level(1).children(null).build();
        Area area7 = Area.builder().id(74L).name("鹤岗市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area8 = Area.builder().id(8L).name("伊春市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area9 = Area.builder().id(9L).name("牡丹江市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area10 = Area.builder().id(10L).name("黑河市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area11 = Area.builder().id(11L).name("双鸭山市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area12 = Area.builder().id(12L).name("大庆市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area13 = Area.builder().id(13L).name("佳木斯").father(null).area_level(1).risk_level(1).children(null).build();
        Area area14 = Area.builder().id(14L).name("鸡西市").father(null).area_level(1).risk_level(1).children(null).build();
        Area area15 = Area.builder().id(15L).name("卫健委").father(null).area_level(1).risk_level(1).children(null).build();

        // 设置森林对应每个树的根节点的孩子

        new Harbin01().setAreaStore(area1);
        new Qiqihaer02().setAreaStore(area2);
        new Qitaihe03().setAreaStore(area3);
        new Suihua04().setAreaStore(area4);
        new Daxinganling05().setAreaStore(area5);
        new SenGong06().setAreaStore(area6);
        new Hegang07().setAreaStore(area7);
        new Yichun08().setAreaStore(area8);

        //返回个森林
        return new Area[]{area1, area2, area3, area4, area5, area6, area7, area8, area9, area10, area11, area12, area13, area14, area15};
    }

}
