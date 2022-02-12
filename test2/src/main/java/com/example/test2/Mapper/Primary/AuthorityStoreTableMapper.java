package com.example.test2.Mapper.Primary;

import com.example.test2.POJO.AuthorityStoreTableStore;
import org.apache.ibatis.annotations.Param;

public interface AuthorityStoreTableMapper {

    int insertAuthorityStoreTable(AuthorityStoreTableStore authorityStoreTableStore);

    AuthorityStoreTableStore selectAuthorityStoreTableById(@Param("id") Long id);

}
