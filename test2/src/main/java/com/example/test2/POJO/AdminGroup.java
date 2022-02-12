package com.example.test2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminGroup {

    private Long id;
    private String group_name;
    private Authority[] authority_collection;
    private String comment;
}
