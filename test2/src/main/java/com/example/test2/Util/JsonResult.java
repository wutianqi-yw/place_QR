package com.example.test2.Util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JsonResult<T> {

    private Integer state;
    private String message;
    private T data;

    public JsonResult(Throwable e){
        this.message=e.getMessage();
    }

    public JsonResult(Integer state,T data){
        this.state=state;
        this.data=data;
    }

    public JsonResult(Integer state){
        this.state=state;
    }
}
