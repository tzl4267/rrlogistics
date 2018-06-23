package com.tsinghuait.logistics.service;

import java.util.Set;




public interface PermissionService {

	
	Set<String> findPermissions(String uname);//根据用户名查询权限集合
	
}
