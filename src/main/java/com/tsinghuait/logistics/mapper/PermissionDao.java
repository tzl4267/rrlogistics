package com.tsinghuait.logistics.mapper;

import java.util.Set;

import com.tsinghuait.logistics.pojo.Permission;



public interface PermissionDao {

	
	
	Set<Permission> findPermissions(String uname);//根据用户名查询权限集合
	
	
}
