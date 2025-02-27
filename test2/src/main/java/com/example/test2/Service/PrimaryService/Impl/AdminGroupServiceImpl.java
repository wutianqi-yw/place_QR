package com.example.test2.Service.PrimaryService.Impl;

import com.example.test2.Mapper.Primary.AdminGroupMapper;
import com.example.test2.Mapper.Primary.AdminMapper;
import com.example.test2.Mapper.Primary.AuthorityStoreTableMapper;
import com.example.test2.POJO.*;
import com.example.test2.Service.Exception.*;
import com.example.test2.Service.PrimaryService.AdminGroupService;
import com.example.test2.Util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "AdminGroupService")
public class AdminGroupServiceImpl implements AdminGroupService {

    private final AdminGroupMapper adminGroupMapper;

    private final AuthorityStoreTableMapper authorityStoreTableMapper;

    private final AdminMapper adminMapper;

    @Autowired
    public AdminGroupServiceImpl(AdminGroupMapper adminGroupMapper, AuthorityStoreTableMapper authorityStoreTableMapper, AdminMapper adminMapper) {
        this.adminGroupMapper = adminGroupMapper;
        this.authorityStoreTableMapper = authorityStoreTableMapper;
        this.adminMapper = adminMapper;
    }

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
        AdminGroupStore adminGroupStore=adminGroupMapper.selectAdminGroupById(id);
        if (adminGroupStore==null){
            throw new GroupNotFoundException("分组数据不存在");
        }
        Long count=adminMapper.selectAdminCountByGroupId(id);
        if(count>0){
            throw new GroupIsUsedException("分组正在使用中");
        }
        int rows=adminGroupMapper.deleteAdminGroupById(id);
        if(rows!=1){
            throw new DeleteException("删除数据时未知错误");
        }
    }

    public AdminGroup resultMenu(Long id){
        AdminGroupStore adminGroupStore=adminGroupMapper.selectAdminGroupById(id);
        if(adminGroupStore==null){
            throw new GroupNotFoundException("分组数据不存在");
        }
        Long[] temp=StringUtil.getArray(adminGroupStore.getAuthority_collection());
        AdminGroup adminGroup=adminGroupStorageConversion(adminGroupStore);
        Authority[] authority_collection=new Authority[temp.length];
        for(int i=0;i<temp.length;i++){
            authority_collection[i]=createMenu(temp[i]);
        }
        adminGroup.setAuthority_collection(authority_collection);
        return adminGroup;
    }

    private Authority createMenu(Long id){
        AuthorityStoreTable authorityStoreTable =authorityStoreTableMapper.selectAuthorityStoreTableById(id);
        if(authorityStoreTable ==null){
            throw new AuthorityNotFoundException("权限数据不存在");
        }
        Authority authority =authorityStorageConversion(authorityStoreTable);
        if(authorityStoreTable.getChildren()==null|| authorityStoreTable.getChildren().equals("")){
            authority.setChildren(null);
        }else{
            Long[] temp=StringUtil.getArray(authorityStoreTable.getChildren());
            Authority[] children=new Authority[temp.length];
            for(int i=0;i< temp.length;i++){
                children[i]=createMenu(temp[i]);
            }
            authority.setChildren(children);
        }
        return authority;
    }

    private Authority authorityStorageConversion(AuthorityStoreTable authorityStoreTable){
        Authority authority =new Authority();
        authority.setId(authorityStoreTable.getId());
        authority.setName(authorityStoreTable.getName());
        authority.setUrl(authorityStoreTable.getUrl());
        authority.setIcon(authorityStoreTable.getIcon());
        authority.setType(authorityStoreTable.getType());
        return authority;
    }

    private AdminGroup adminGroupStorageConversion(AdminGroupStore adminGroupStore){
        AdminGroup adminGroup=new AdminGroup();
        adminGroup.setGroup_name(adminGroupStore.getGroup_name());
        adminGroup.setComment(adminGroupStore.getComment());
        adminGroup.setId(adminGroupStore.getId());
        adminGroup.setAuthority_collection(null);
        return adminGroup;
    }

    @Override
    public void changeAdminGroupById(AdminGroupStore adminGroupStore) {
        Long[] temp=StringUtil.getArray(adminGroupStore.getAuthority_collection());
        for(Long id:temp){
            AuthorityStoreTable authorityStoreTable=authorityStoreTableMapper.selectAuthorityStoreTableById(id);
            if(authorityStoreTable==null){
                throw new AuthorityNotFoundException("权限数据不存在");
            }
        }
        int rows=adminGroupMapper.updateAdminGroupById(adminGroupStore);
        if(rows!=1){
            throw new UpdateException("更新数据时未知异常");
        }
    }
}
