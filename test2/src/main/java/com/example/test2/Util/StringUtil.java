package com.example.test2.Util;

import java.util.ArrayList;

public class StringUtil {

    public static Long[] getArray(String s){
        if (s==null){
            return new Long[0];
        }
        String[] temp=s.split(",");
        int lenth= temp.length;
        Long[] res=new Long[lenth];
        for(int i=0;i<lenth;i++){
            res[i]= Long.valueOf(temp[i]);
        }
        return res;
    }

}
