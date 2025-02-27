package com.example.test2.Service;

import com.example.test2.POJO.AdminGroup;
import com.example.test2.POJO.AdminGroupStore;
import com.example.test2.POJO.Authority;
import com.example.test2.Service.PrimaryService.AdminGroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminGroupServiceTests {

    @Autowired
    private AdminGroupService adminGroupService;

    @Test
    public void addAdminGroup(){
        AdminGroupStore adminGroupStore=new AdminGroupStore();
        adminGroupStore.setGroup_name("2333");
        adminGroupStore.setComment("123");
        adminGroupStore.setAuthority_collection("1,2,3");
        adminGroupService.addAdminGroup(adminGroupStore);
    }

    @Test
    public void resultMenu(){
        AdminGroup adminGroup=adminGroupService.resultMenu(2L);
        Authority[] authority =adminGroup.getAuthority_collection();
        for(int i = 0; i< authority.length; i++){
            dfs(authority[i]);
        }
    }

    private void dfs(Authority authority){
        if(authority ==null){
            return;
        }
        System.out.println(authority.getId());
        Authority[] children= authority.getChildren();
        if(children==null){
            return;
        }
        for(int i=0;i<children.length;i++){
            dfs(children[i]);
        }
    }

    @Test
    public void changeAdminGroupById(){
        AdminGroupStore adminGroupStore=new AdminGroupStore();
        adminGroupStore.setId(1L);
        adminGroupStore.setGroup_name("aaa");
        adminGroupStore.setAuthority_collection("1,2,3,4,5,6");
        adminGroupStore.setComment("啊哈哈哈");
        adminGroupService.changeAdminGroupById(adminGroupStore);
    }

    @Test
    public void removeAdminGroupById(){
        adminGroupService.removeAdminGroupById(2L);
    }
}
