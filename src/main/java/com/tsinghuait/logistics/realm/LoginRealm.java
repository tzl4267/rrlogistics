/**
 * 
 */
package com.tsinghuait.logistics.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghuait.logistics.pojo.Permission;
import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.service.PermissionService;
import com.tsinghuait.logistics.service.UserService;



public class LoginRealm extends AuthorizingRealm{

	
	@Resource
	private UserService us;
	
	@Resource
	private PermissionService ps;
	
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection primcipal) {
		String uname = (String) primcipal.getPrimaryPrincipal();
		Set<String> rset = us.findRoles(uname);
		Set<String> set = ps.findPermissions(uname);
		SimpleAuthorizationInfo authorInfo = new SimpleAuthorizationInfo();
		authorInfo.setRoles(rset);
		authorInfo.setStringPermissions(set);
		return authorInfo;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	//身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			String uname = (String) token.getPrincipal();
			User user = us.find(uname);
			if(user!=null){
				ByteSource salt=ByteSource.Util.bytes(uname);//盐值生成方式
				SimpleAuthenticationInfo authenInfo = new SimpleAuthenticationInfo(uname, user.getPass(),salt, getName());
				return authenInfo;
			}
			
		return null;
	}

	public LoginRealm() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
