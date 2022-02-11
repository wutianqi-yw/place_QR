package com.example.test2.Controllers;

import com.example.test2.POJO.Admin;
import com.example.test2.Service.PrimaryService.AdminService;
import com.example.test2.Util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/Admin")
public class AdminController extends BaseController{

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login")
    public JsonResult<Admin> login(String username, String password, HttpSession session){
        Admin res=adminService.login(username, password);
        session.setAttribute("id",res.getId());
        session.setAttribute("username",res.getUsername());
        session.setAttribute("group_id",res.getGroup_id());
        return new JsonResult<>(OK,res);
    }

    @RequestMapping(value = "/register")
    public JsonResult<Void> register(Admin admin){
        adminService.register(admin);
        return new JsonResult<>(OK);
    }

    @RequestMapping(value = "/changePassword")
    public JsonResult<Void> changePassword(String newPassword,String oldPassword,HttpSession session){
        Long id= (Long) session.getAttribute("id");
        adminService.changePassword(id, newPassword, oldPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping(value = "/removeAdminById")
    public JsonResult<Void> removeAdminById(HttpSession session){
        Long id= (Long) session.getAttribute("id");
        adminService.removeAdminById(id);
        return new JsonResult<>(OK);
    }
}
