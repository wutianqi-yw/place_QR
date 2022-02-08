package com.example.test2.POJO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QRRecords {
    private Long id;
    private Long user_id;
    private Long place_id;
    private Long timeMillis;
}
