package com.example.test2.Service;

import com.example.test2.POJO.AuthorityStoreTableStore;
import com.example.test2.Service.PrimaryService.AuthorityStoreTableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorityStoreTableServiceTests {

    @Autowired
    private AuthorityStoreTableService authorityStoreTableService;

    @Test
    public void addAuthorityStoreTable(){
        AuthorityStoreTableStore authorityStoreTableStore=new AuthorityStoreTableStore();
        authorityStoreTableStore.setChildren("8");
        authorityStoreTableStore.setUrl("11");
        authorityStoreTableStore.setIcon("11");
        authorityStoreTableStore.setType(null);
        authorityStoreTableStore.setName("1231");
        authorityStoreTableService.addAuthorityStoreTable(authorityStoreTableStore);
    }
}
