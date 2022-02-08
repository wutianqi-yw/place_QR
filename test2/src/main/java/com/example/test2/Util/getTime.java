package com.example.test2.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@DependsOn("dateFormat")
public class getTime {

    private final SimpleDateFormat sdf;

    @Autowired
    public getTime(@Qualifier("dateFormat") SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String getTodayDateFormat(){
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }
}
