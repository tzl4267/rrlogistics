/**
 * 
 */
package com.tsinghuait.logistics.mapper;

import java.util.Map;
import java.util.Set;

import com.tsinghuait.logistics.pojo.Permission;
import com.tsinghuait.logistics.pojo.User;



public interface UserDao {

	User find(String uname);
	
	Set<String> findRoles(String uname);
	
	void add(User u);
	
	String hash(User u);
	
	String get();
	
	String getUserId();
	
	Map<String, Permission> rp(String uname);
	
	
}
