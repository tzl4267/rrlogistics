package com.tsinghuait.logistics.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.PermissionDao;
import com.tsinghuait.logistics.pojo.Permission;
import com.tsinghuait.logistics.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

	
	@Resource
	private PermissionDao pd;
	
	
	
	/* (non-Javadoc)
	 * @see com.shiro.service.UserService#findPermissions(java.lang.String)
	 */

	
	
	@Override
	public Set<String> findPermissions(String uname) {//根据用户名查询权限集合
		Set<Permission> pset = pd.findPermissions(uname);
		Set<String> set = new HashSet<>();
		Iterator<Permission> it = pset.iterator();  
		while (it.hasNext()) {  
			Permission p = it.next();  
		  set.add(p.getPname());
		} 
		return set;
	}
	
}
