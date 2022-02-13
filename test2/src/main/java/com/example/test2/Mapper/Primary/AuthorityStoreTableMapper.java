package com.example.test2.Mapper.Primary;

import com.example.test2.POJO.AuthorityStoreTable;
import org.apache.ibatis.annotations.Param;

public interface AuthorityStoreTableMapper {

    int insertAuthorityStoreTable(AuthorityStoreTable authorityStoreTable);

    AuthorityStoreTable selectAuthorityStoreTableById(@Param("id") Long id);

    int deleteAuthorityStoreTableById(@Param("id") Long id);


}
