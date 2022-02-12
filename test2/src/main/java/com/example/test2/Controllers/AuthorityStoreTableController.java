package com.example.test2.Controllers;

import com.example.test2.Controllers.Exception.ParameIsNullException;
import com.example.test2.POJO.AuthorityStoreTableStore;
import com.example.test2.Service.PrimaryService.AuthorityStoreTableService;
import com.example.test2.Util.JsonResult;
import com.example.test2.Util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/AuthorityStoreTable")
public class AuthorityStoreTableController extends BaseController{

    @Autowired
    private AuthorityStoreTableService authorityStoreTableService;

    @PostMapping(value = "/addAuthorityStoreTable")
    public JsonResult<Void> addAuthorityStoreTable(AuthorityStoreTableStore authorityStoreTableStore){
        if(authorityStoreTableStore.getChildren()==null||authorityStoreTableStore.getChildren().equals("")){
            authorityStoreTableStore.setChildren("-1");
        }
        if(!ParameterUtil.parameterCheck(authorityStoreTableStore)){
            throw new ParameIsNullException("指定参数不能为空");
        }
        if(authorityStoreTableStore.getChildren().equals("-1")){
            authorityStoreTableStore.setChildren(null);
        }
        authorityStoreTableService.addAuthorityStoreTable(authorityStoreTableStore);
        return new JsonResult<>(OK);
    }

}
