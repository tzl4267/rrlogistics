/**
 * 
 */
package com.tsinghuait.logistics.mapper;

import java.util.List;
import java.util.Set;

import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.pojo.UserRole;



public interface UserDao {

	User find(String userName);//shiro根据用户名查询用户
	
	User findUser(String userId);//根据用户id查询用户
	
	Set<String> findRoles(String uname);//根据用户名查询角色
	
	void add(User u);//添加用户
	
	String getUserId();//获取用户编号
	
	List<UserRole> selectAll(String agencyId);//根据网点编号查用户和角色信息
	
	void updateUser(User user);//修改用户信息
}
