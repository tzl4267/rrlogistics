/**
 * 
 */
package com.tsinghuait.logistics.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.UserDao;
import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.pojo.UserRole;
import com.tsinghuait.logistics.pojo.User_Role;
import com.tsinghuait.logistics.service.RoleService;
import com.tsinghuait.logistics.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao ud;
	
	@Resource
	private RoleService rs;
	
	@Value("${rrlogistics.agencyId}")  
    private String agencyId;
	
	/* (non-Javadoc)
	 * @see com.shiro.service.UserService#find(java.lang.String)
	 */
	@Override
	public User find(String uname) {//shiro根据用户名查询用户
		User user = ud.find(uname);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.shiro.service.UserService#findRoles(java.lang.String)
	 */
	@Override
	public Set<String> findRoles(String uname) {//根据用户名查询角色
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
	public String get() {//获取用户编号
		String userId = ud.getUserId();
		if(userId==null){
			userId="101";
		}
		return userId;
	}



	@Override
	public String add(User u,User_Role ur) throws Exception {//添加用户
		u.setAgencyId(agencyId);
		ud.add(u);
		rs.addUser_Role(ur);
		return "ok";
	}

	@Override
	public List<UserRole> findAll() {//根据网点编号查用户和角色信息
		List<UserRole> ulist = ud.selectAll(agencyId);
		return ulist;
	}

	@Override
	public User findUser(String userId) {//根据用户id查询用户
		User user = ud.findUser(userId);
		return user;
	}

	@Override
	public void updateUser(User u) {//修改用户信息
		ud.updateUser(u);
	}

	
	
}
