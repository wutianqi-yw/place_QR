package com.example.test2.Controllers;

import com.example.test2.Controllers.Exception.ParameIsNullException;
import com.example.test2.POJO.AdminGroup;
import com.example.test2.POJO.AdminGroupStore;
import com.example.test2.Service.PrimaryService.AdminGroupService;
import com.example.test2.Service.PrimaryService.AdminService;
import com.example.test2.Util.JsonResult;
import com.example.test2.Util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/adminGroup")
public class AdminGroupController extends BaseController{

    private final AdminGroupService adminGroupService;

    @Autowired
    public AdminGroupController(AdminGroupService adminGroupService) {
        this.adminGroupService = adminGroupService;
    }

    @PostMapping(value = "/addAdminGroup")
    public JsonResult<Void> addAdminGroup(AdminGroupStore adminGroupStore){
        adminGroupStore.setId(-1L);
        if(!ParameterUtil.parameterCheck(adminGroupStore)){
            throw new ParameIsNullException("指定参数不能为空");
        }
        adminGroupService.addAdminGroup(adminGroupStore);
        return new JsonResult<>(OK);
    }

    @GetMapping(value = "/resultMenu")
    public JsonResult<HashMap<String,AdminGroup>> resultMenu(HttpSession session, HttpServletRequest request){
        Long id= (Long) session.getAttribute("group_id");
        AdminGroup adminGroup=getAdminGroupFromServletContext(id,request.getServletContext());
        if(adminGroup==null){
            adminGroup=adminGroupService.resultMenu(id);
            putAdminGroupFromServletContext(adminGroup,request.getServletContext());
        }
        HashMap<String,AdminGroup> hashMap=new HashMap<>();
        hashMap.put("adminGroup",adminGroup);
        return new JsonResult<>(OK,hashMap);
    }

    @PostMapping(value = "/changeAdminGroupById")
    public JsonResult<Void> changeAdminGroupById(AdminGroupStore adminGroupStore,HttpServletRequest request){
        if(!ParameterUtil.parameterCheck(adminGroupStore)){
            throw new ParameIsNullException("指定参数不能为空");
        }
        adminGroupService.changeAdminGroupById(adminGroupStore);
        AdminGroup adminGroup=adminGroupService.resultMenu(adminGroupStore.getId());
        putAdminGroupFromServletContext(adminGroup,request.getServletContext());
        return new JsonResult<>(OK);
    }

    @PostMapping(value = "/removeAdminGroupById")
    public JsonResult<Void> removeAdminGroupById(Long id, HttpServletRequest request){
        adminGroupService.removeAdminGroupById(id);
        removeAdminGroupFromServletContext(id,request.getServletContext());
        return new JsonResult<>(OK);
    }
}
