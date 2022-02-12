package com.example.test2.Service.SecondaryService;

import com.example.test2.POJO.QRRecords;


public interface QRRecordsService {

    public int createNewDateTable();

    public int insertNewQrRecord(QRRecords record);


    /**
     *
     * 查询是否存在table。使用了当前系统时间。
     *
     * @param y 年
     * @param m 月
     * @param d 日
     * @return
     */
    public boolean checkExistTable(Integer y,Integer m,Integer d);
}
