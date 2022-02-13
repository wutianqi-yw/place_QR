package com.example.test2.Controllers;

import com.example.test2.Controllers.Exception.ControllerException;
import com.example.test2.POJO.AdminGroup;
import com.example.test2.Service.Exception.InsertException;
import com.example.test2.Service.Exception.ServiceException;
import com.example.test2.Util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.util.HashMap;


public class BaseController {

    public static int OK=200;

    //异常统一处理
    @ExceptionHandler({ServiceException.class, ControllerException.class})
    @ResponseBody
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult jsonResult=new JsonResult(e);
        if(e instanceof InsertException){
            jsonResult.setState(2000);
        }
        return jsonResult;
    }

    protected final AdminGroup getAdminGroupFromServletContext(Long id,ServletContext application){
        HashMap<Long,AdminGroup> hashMap= (HashMap<Long, AdminGroup>) application.getAttribute("AdminGroupMap");
        if(hashMap==null){
            application.setAttribute("AdminGroupMap",new HashMap<>());
            return null;
        }
        return hashMap.get(id);
    }

    protected final void putAdminGroupFromServletContext(AdminGroup adminGroup,ServletContext application){
        HashMap<Long,AdminGroup> hashMap= (HashMap<Long, AdminGroup>) application.getAttribute("AdminGroupMap");
        if(hashMap==null){
            hashMap=new HashMap<>();
            application.setAttribute("AdminGroupMap",hashMap);
        }
        hashMap.put(adminGroup.getId(),adminGroup);
    }

    protected final void removeAdminGroupFromServletContext(Long id,ServletContext application){
        HashMap<Long,AdminGroup> hashMap= (HashMap<Long, AdminGroup>) application.getAttribute("AdminGroupMap");
        if(hashMap==null){
            return;
        }
        hashMap.remove(id);
    }

}
