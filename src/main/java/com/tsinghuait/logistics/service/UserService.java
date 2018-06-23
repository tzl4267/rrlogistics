/**
 * 
 */
package com.tsinghuait.logistics.service;

import java.util.List;
import java.util.Set;

import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.pojo.UserRole;
import com.tsinghuait.logistics.pojo.User_Role;



public interface UserService {

	
	User find(String uname);//shiro根据用户名查询用户
	
	User findUser(String userId);//根据用户id查询用户
	
	Set<String> findRoles(String uname);//根据用户名查询角色
	
	String hash(User u);//加密方式
	
	String get();//获取用户编号
	
	String add(User u,User_Role ur) throws Exception;//添加用户
	
	List<UserRole> findAll();//根据网点编号查用户和角色信息
	
	void updateUser(User u);//修改用户信息
}
