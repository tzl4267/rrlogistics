package com.tsinghuait.logistics.service.impl;

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
	public Set<Permission> findPermissions(String uname) {
		Set<Permission> pset = pd.findPermissions(uname);
		return pset;
	}

	
	

	@Override
	public Set<String> findPermissions(Set<Permission> pset) {
		Set<String> set = pd.findPermissions(pset);
		return set;
	}
}
