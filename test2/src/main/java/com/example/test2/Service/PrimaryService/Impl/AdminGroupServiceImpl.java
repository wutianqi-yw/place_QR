package com.example.test2.Service.PrimaryService.Impl;

import com.example.test2.Mapper.Primary.AdminGroupMapper;
import com.example.test2.Mapper.Primary.AuthorityStoreTableMapper;
import com.example.test2.POJO.AdminGroup;
import com.example.test2.POJO.AdminGroupStore;
import com.example.test2.POJO.AuthorityStoreTable;
import com.example.test2.POJO.AuthorityStoreTableStore;
import com.example.test2.Service.Exception.AuthorityNotFoundException;
import com.example.test2.Service.Exception.GroupDuplicatedException;
import com.example.test2.Service.Exception.InsertException;
import com.example.test2.Service.PrimaryService.AdminGroupService;
import com.example.test2.Util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "AdminGroupService")
public class AdminGroupServiceImpl implements AdminGroupService {

    @Autowired
    private AdminGroupMapper adminGroupMapper;

    @Autowired
    private AuthorityStoreTableMapper authorityStoreTableMapper;

    @Override
    public void addAdminGroup(AdminGroupStore adminGroup) {
        Long[] temp= StringUtil.getArray(adminGroup.getAuthority_collection());
        for (int i=0;i<temp.length;i++){
            if(authorityStoreTableMapper.selectAuthorityStoreTableById(temp[i])==null){
                throw new AuthorityNotFoundException("权限数据不存在");
            }
        }
        int rows=adminGroupMapper.insertAdminGroup(adminGroup);
        if(rows!=1){
            throw new InsertException("插入数据未知错误");
        }
    }

    @Override
    public void removeAdminGroupById(Long id) {

    }

    public AdminGroup resultMenu(Long id){
        AdminGroupStore adminGroupStore=adminGroupMapper.selectAdminGroupById(id);
        if(adminGroupStore==null){
            throw new GroupDuplicatedException("分组数据不存在");
        }
        Long[] temp=StringUtil.getArray(adminGroupStore.getAuthority_collection());
        AdminGroup adminGroup=adminGroupStorageConversion(adminGroupStore);
        AuthorityStoreTable[] authority_collection=new AuthorityStoreTable[temp.length];
        for(int i=0;i<temp.length;i++){
            authority_collection[i]=createMenu(temp[i]);
        }
        adminGroup.setAuthority_collection(authority_collection);
        return adminGroup;
    }

    private AuthorityStoreTable createMenu(Long id){
        AuthorityStoreTableStore authorityStoreTableStore=authorityStoreTableMapper.selectAuthorityStoreTableById(id);
        if(authorityStoreTableStore==null){
            throw new AuthorityNotFoundException("权限数据不存在");
        }
        AuthorityStoreTable authorityStoreTable=authorityStorageConversion(authorityStoreTableStore);
        if(authorityStoreTableStore.getChildren()==null||authorityStoreTableStore.getChildren().equals("")){
            authorityStoreTable.setChildren(null);
        }else{
            Long[] temp=StringUtil.getArray(authorityStoreTableStore.getChildren());
            AuthorityStoreTable[] children=new AuthorityStoreTable[temp.length];
            for(int i=0;i< temp.length;i++){
                children[i]=createMenu(temp[i]);
            }
            authorityStoreTable.setChildren(children);
        }
        return authorityStoreTable;
    }

    private AuthorityStoreTable authorityStorageConversion(AuthorityStoreTableStore authorityStoreTableStore){
        AuthorityStoreTable authorityStoreTable=new AuthorityStoreTable();
        authorityStoreTable.setId(authorityStoreTableStore.getId());
        authorityStoreTable.setName(authorityStoreTableStore.getName());
        authorityStoreTable.setUrl(authorityStoreTableStore.getUrl());
        authorityStoreTable.setIcon(authorityStoreTableStore.getIcon());
        authorityStoreTable.setType(authorityStoreTableStore.getType());
        return authorityStoreTable;
    }

    private AdminGroup adminGroupStorageConversion(AdminGroupStore adminGroupStore){
        AdminGroup adminGroup=new AdminGroup();
        adminGroup.setGroup_name(adminGroupStore.getGroup_name());
        adminGroup.setComment(adminGroupStore.getComment());
        adminGroup.setId(adminGroupStore.getId());
        adminGroup.setAuthority_collection(null);
        return adminGroup;
    }
}
