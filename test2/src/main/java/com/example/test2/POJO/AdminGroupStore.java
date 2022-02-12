package com.example.test2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminGroupStore {

    private Long id;
    private String group_name;
    private String authority_collection;
    private String comment;

}
