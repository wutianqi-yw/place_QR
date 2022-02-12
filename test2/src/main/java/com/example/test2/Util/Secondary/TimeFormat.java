package com.example.test2.Util.Secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@DependsOn("dateFormat")
public class TimeFormat {

    private final SimpleDateFormat sdf;

    @Autowired
    public TimeFormat(@Qualifier("dateFormat") SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String getTodayDateFormat(){
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }

    public static String getTableNameFormat(Integer year,Integer month,Integer date){
        return year+"_"+month+"_"+date+"_qr_records";
    }

    public static Boolean checkExistTable(Integer year,Integer month,Integer date){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,date);
        return calendar.getTimeInMillis()<System.currentTimeMillis();
    }

}
