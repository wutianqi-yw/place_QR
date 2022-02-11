package com.example.test2.Service.PrimaryService;

import com.example.test2.POJO.AdminGroup;
import com.example.test2.POJO.AdminGroupStore;

public interface AdminGroupService {

    void addAdminGroup(AdminGroupStore adminGroup);

    void removeAdminGroupById(Long id);

    AdminGroup resultMenu(Long id);
}
