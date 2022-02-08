package com.example.test2.Service.SecondaryService.Impl;


import com.example.test2.Mapper.secondary.QRRecordsMapper;
import com.example.test2.POJO.QRRecords;
import com.example.test2.Service.SecondaryService.QRRecordsService;
import com.example.test2.Util.getTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("QRRecordsService")
public class QRRecordsServiceImpl implements QRRecordsService {


    private QRRecordsMapper qrRecordsMapper ;
    private getTime getTime;

    private final String TablePostFix = "_qr_records";

    @Autowired
    public QRRecordsServiceImpl(QRRecordsMapper qrRecordsMapper,getTime getTime) {
        this.getTime = getTime;
        this.qrRecordsMapper = qrRecordsMapper;
    }

    @Override
    public int createNewDateTable() {

        String todayDateFormat = getTime.getTodayDateFormat();
        return qrRecordsMapper.createTableByDate(todayDateFormat+TablePostFix);
    }

    @Override
    public int insertNewQrRecord(QRRecords record) {
        return qrRecordsMapper.insertNewQrRecord(getTime.getTodayDateFormat(),record);
    }



}
