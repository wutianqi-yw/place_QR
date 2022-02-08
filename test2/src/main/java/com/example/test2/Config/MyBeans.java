package com.example.test2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class MyBeans {


    @Bean("dateFormat")
    public SimpleDateFormat getSDF(){
        return new SimpleDateFormat("yyyy_MM_dd");
    }

}
