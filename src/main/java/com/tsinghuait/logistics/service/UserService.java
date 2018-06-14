/**
 * 
 */
package com.tsinghuait.logistics.service;

import java.util.Set;

import com.tsinghuait.logistics.pojo.User;



public interface UserService {

	
	User find(String uname);
	
	Set<String> findRoles(String uname);
	
	String hash(User u);
	
	String get();
	
	String add(User u);
}
