package com.tsinghuait.logistics.service;

import java.util.Set;

import com.tsinghuait.logistics.pojo.Permission;



public interface PermissionService {

    Set<Permission> findPermissions(String uname);
	
	Set<String> findPermissions(Set<Permission> pset);
	
}
