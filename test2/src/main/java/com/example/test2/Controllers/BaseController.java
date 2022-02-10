package com.example.test2.Controllers;

import com.example.test2.Service.Exception.ServiceException;
import com.example.test2.Util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {

    public static int OK=200;

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult jsonResult=new JsonResult(e);
        return jsonResult;
    }

}
