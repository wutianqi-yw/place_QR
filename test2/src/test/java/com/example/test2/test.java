package com.example.test2;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {


    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(2022,0,1);

        Date time = calendar.getTime();
        System.out.println(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(time));

    }
    @Test
    public void test2(){

    }
}
