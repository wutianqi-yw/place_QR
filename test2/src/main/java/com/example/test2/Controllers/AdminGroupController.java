package com.example.test2.Controllers;

import com.example.test2.POJO.AdminGroup;
import com.example.test2.POJO.AdminGroupStore;
import com.example.test2.Service.PrimaryService.AdminGroupService;
import com.example.test2.Service.PrimaryService.AdminService;
import com.example.test2.Util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/AdminGroup")
public class AdminGroupController extends BaseController{

    @Autowired
    private AdminGroupService adminGroupService;

    @PostMapping(value = "/addAdminGroup")
    public JsonResult<Void> addAdminGroup(AdminGroupStore adminGroupStore){
        adminGroupService.addAdminGroup(adminGroupStore);
        return new JsonResult<>(OK);
    }

    @GetMapping(value = "/resultMenu")
    public JsonResult<AdminGroup> resultMenu(HttpSession session){
        Long id= (Long) session.getAttribute("group_id");
        AdminGroup adminGroup=adminGroupService.resultMenu(id);
        return new JsonResult<>(OK,adminGroup);
    }
}
