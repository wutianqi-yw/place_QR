package com.example.test2.Service;

import com.example.test2.POJO.AuthorityStoreTable;
import com.example.test2.Service.PrimaryService.AuthorityStoreTableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorityServiceTests {

    @Autowired
    private AuthorityStoreTableService authorityStoreTableService;

    @Test
    public void addAuthorityStoreTable(){
        AuthorityStoreTable authorityStoreTable =new AuthorityStoreTable();
        authorityStoreTable.setChildren("8");
        authorityStoreTable.setUrl("11");
        authorityStoreTable.setIcon("11");
        authorityStoreTable.setType(null);
        authorityStoreTable.setName("1231");
        authorityStoreTableService.addAuthorityStoreTable(authorityStoreTable);
    }
}
