package com.example.test2.Mapper;

import com.example.test2.Mapper.Primary.AuthorityStoreTableMapper;
import com.example.test2.POJO.AuthorityStoreTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorityMapperTests {

    @Autowired
    private AuthorityStoreTableMapper authorityStoreTableMapper;

    @Test
    public void insertAuthorityStoreTable(){
        AuthorityStoreTable authorityStoreTable =new AuthorityStoreTable();
        authorityStoreTable.setName("hh");
        authorityStoreTable.setUrl("123");
        authorityStoreTable.setIcon("1");
        authorityStoreTable.setChildren(null);
        System.out.println(authorityStoreTableMapper.insertAuthorityStoreTable(authorityStoreTable));
    }

    @Test
    public void selectAuthorityStoreTableById(){
        System.out.println(authorityStoreTableMapper.selectAuthorityStoreTableById(2L));
    }
}
