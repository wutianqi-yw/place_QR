package com.example.test2.Mapper.Primary;

import com.example.test2.POJO.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    int insertAdmin(Admin admin);

    Admin selectAdminByUsername(@Param("username") String username);

    int updatePasswordById(@Param("id") Long id,@Param("password") String password);

    Admin selectAdminById(@Param("id") Long id);

    int deleteAdminById(@Param("id") Long id);
}
