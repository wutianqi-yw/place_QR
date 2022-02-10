package com.example.test2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityStoreTable {

    private Long id;
    private String name;
    private String url;
    private String icon;
    private String children;
    private Integer type;

}
