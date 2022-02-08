package com.example.test2.POJO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Area {

    private Long id;
    private String name;
    private Integer risk_level;
    private Integer area_level;
    private Area[] children;
    private Long father_id;


    static public Long[] convertChildStringToIdArray(String s){
        if (s==null)return null;
        String[] split = s.split(",");
        Long[] res = new Long[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = (long) Integer.parseInt(split[i]);
        }
        return res;
    }
}
