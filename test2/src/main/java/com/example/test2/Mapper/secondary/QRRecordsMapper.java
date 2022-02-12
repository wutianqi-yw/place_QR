package com.example.test2.Mapper.secondary;

import com.example.test2.POJO.QRRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


public interface QRRecordsMapper {

    public int createTableByDate(String dateFormat);

    public int insertNewQrRecord(@Param("dateFormat") String dateFormat, @Param("record") QRRecords record);

    /**
     *
     * 根据用户id,和日期format
     * 查找这个用户当天的行程路径。（由先到后）
     *
     * 返回 place_id place_type timeMillis 时间戳
     *
     * @param dataFormat
     * @param user_id
     * @return
     */
    public List<HashMap> selectPlaceIdTypeByUserid(@Param("dataFormat")String dataFormat,@Param("userId") Long user_id);
}
