package com.example.test2.POJO;

import lombok.*;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Area {

    private Long id;
    private String name;
    private Integer risk_level;
    private Integer area_level;
    private Area[] children;
    private Area father;


    static public Long[] convertChildStringToIdArray(String s){
        if (s==null)return null;
        String[] split = s.split(",");
        Long[] res = new Long[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = (long) Integer.parseInt(split[i]);
        }
        return res;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", risk_level=" + risk_level +
                ", area_level=" + area_level +
                ", children=" + Arrays.toString(children) +
                ", father=" + father +
                '}';
    }
}
