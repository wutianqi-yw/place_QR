package com.example.test2.Mapper.Primary;

import com.example.test2.POJO.RiskReportRecord;
import org.apache.ibatis.annotations.Param;

public interface RiskReportRecordMapper {

    int insertRiskReportRecord(RiskReportRecord riskReportRecord);

    int deleteRiskReportRecordById(@Param("id") Long id);

    int updateRiskReportRecordById(@Param("id") Long id);

    int selectRiskReportRecordById(@Param("id") Long id);

}
