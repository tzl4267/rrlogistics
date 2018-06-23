package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Role;
import com.tsinghuait.logistics.pojo.User_Role;

public interface RoleService {

	List<Role> findAll();//查询所有角色
	
	List<Role> findByType();//通过网点类型选择角色
	
	String getUser_RoleId();//获取user_role id
	
	void addUser_Role(User_Role ur) throws Exception;//添加用户角色关联信息
}
