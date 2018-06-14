/**
 * 
 */
package com.tsinghuait.logistics.service.impl;

import java.util.Set;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.UserDao;
import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao ud;
	
	/* (non-Javadoc)
	 * @see com.shiro.service.UserService#find(java.lang.String)
	 */
	@Override
	public User find(String uname) {
		User user = ud.find(uname);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.shiro.service.UserService#findRoles(java.lang.String)
	 */
	@Override
	public Set<String> findRoles(String uname) {
		Set<String> rset = ud.findRoles(uname);
		return rset;
	}

	
	

	/* (non-Javadoc)
	 * @see com.shiro.service.UserService#hash(com.shiro.pojo.User)
	 */
	@Override
	public String hash(User u) {
		String hashAlgorithName="MD5";//加密方式
		Object salt=ByteSource.Util.bytes(u.getUserName());//盐值生成方式
		int count=1024;//加密次数
		Object result=new SimpleHash(hashAlgorithName, u.getPass(),salt,count);
		return result.toString();
	}


	@Override
	public String get() {
		String userId = ud.getUserId();
		return userId;
	}



	@Override
	public String add(User u) {
		ud.add(u);
		return "ok";
	}

}
