package com.example.test2.Service.SecondaryService.Impl;


import com.example.test2.Mapper.secondary.QRRecordsMapper;
import com.example.test2.POJO.QRRecords;
import com.example.test2.Service.SecondaryService.QRRecordsService;
import com.example.test2.Util.Secondary.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("QRRecordsService")
public class QRRecordsServiceImpl implements QRRecordsService {


    private QRRecordsMapper qrRecordsMapper ;
    private TimeFormat timeFormat;

    private final String TablePostFix = "_qr_records";

    @Autowired
    public QRRecordsServiceImpl(QRRecordsMapper qrRecordsMapper, TimeFormat TimeFormat) {
        this.timeFormat = TimeFormat;
        this.qrRecordsMapper = qrRecordsMapper;
    }

    @Override
    public int createNewDateTable() {

        String todayDateFormat = timeFormat.getTodayDateFormat();
        return qrRecordsMapper.createTableByDate(todayDateFormat+TablePostFix);
    }

    @Override
    public int insertNewQrRecord(QRRecords record) {
        return qrRecordsMapper.insertNewQrRecord(timeFormat.getTodayDateFormat(),record);
    }


    @Override
    public boolean checkExistTable(Integer y, Integer m, Integer d) {
        return TimeFormat.checkExistTable(y,m,d);
    }


}
