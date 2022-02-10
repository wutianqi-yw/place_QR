package com.example.test2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private int code;
    private String msg;
    private Object data;

    private Result(int code) {
        this.code = code;
    }

    public static Result getInstance(int code,String msg,Object data){
        return new Result(code,msg,data);
    }
}
