package com.example.test2.Mapper.Primary;

import com.example.test2.POJO.AdminGroupStore;
import org.apache.ibatis.annotations.Param;

public interface AdminGroupMapper {

    int insertAdminGroup(AdminGroupStore adminGroup);

    int deleteAdminGroupById(@Param("id") Long id);

    AdminGroupStore selectAdminGroupById(@Param("id") Long id);

}
