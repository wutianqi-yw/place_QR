package com.example.test2.Mapper;

import com.example.test2.Mapper.Primary.AuthorityStoreTableMapper;
import com.example.test2.POJO.AuthorityStoreTableStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorityStoreTableMapperTests {

    @Autowired
    private AuthorityStoreTableMapper authorityStoreTableMapper;

    @Test
    public void insertAuthorityStoreTable(){
        AuthorityStoreTableStore authorityStoreTableStore=new AuthorityStoreTableStore();
        authorityStoreTableStore.setName("hh");
        authorityStoreTableStore.setUrl("123");
        authorityStoreTableStore.setIcon("1");
        authorityStoreTableStore.setChildren(null);
        System.out.println(authorityStoreTableMapper.insertAuthorityStoreTable(authorityStoreTableStore));
    }

    @Test
    public void selectAuthorityStoreTableById(){
        System.out.println(authorityStoreTableMapper.selectAuthorityStoreTableById(2L));
    }
}
