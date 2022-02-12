package com.example.test2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskReportRecord {

    private Long id;
    private String apply_type;
    private Long place_id;
    private Integer type;
    private Long report_time;
    private Long report_person_id;
    private Integer report_state;
    private String result;

}
