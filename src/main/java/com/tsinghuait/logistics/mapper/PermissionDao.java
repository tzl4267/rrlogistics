package com.tsinghuait.logistics.mapper;

import java.util.Set;

import com.tsinghuait.logistics.pojo.Permission;



public interface PermissionDao {

	
	Set<Permission> findPermissions(String uname);
	
	Set<String> findPermissions(Set<Permission> pset);
	
	
}
