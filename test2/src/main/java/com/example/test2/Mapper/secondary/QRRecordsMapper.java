package com.example.test2.Mapper.secondary;

import com.example.test2.POJO.QRRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface QRRecordsMapper {

    public int createTableByDate(String dateFormat);

    public int insertNewQrRecord(@Param("dateFormat") String dateFormat, @Param("record") QRRecords record);
}
