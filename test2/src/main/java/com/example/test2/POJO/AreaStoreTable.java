package com.example.test2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AreaStoreTable {
    private Long id;
    private String name;
    private Integer risk_level;
    private Integer area_level;
    private String children;
    private Long father_id;
}
