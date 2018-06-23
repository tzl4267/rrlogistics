package com.tsinghuait.logistics.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Role;
import com.tsinghuait.logistics.pojo.Staff;
import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.pojo.UserRole;
import com.tsinghuait.logistics.pojo.User_Role;
import com.tsinghuait.logistics.service.AgencyService;
import com.tsinghuait.logistics.service.RoleService;
import com.tsinghuait.logistics.service.StaffService;
import com.tsinghuait.logistics.service.UserService;

@Controller
@RequestMapping("user")
public class UserCont {

	@Resource
	private UserService us;
	
	@Resource
	private RoleService rs;
	
	@Resource
	private AgencyService as;
	
	@Value("${rrlogistics.agencyId}")  
    private String agencyId; //从配置文件中获取网点编号 
	
	@Resource
	private StaffService ss;
	
	@RequestMapping("register")//注册 （添加系统用户）
	public String register(User u){
		if(u!=null){
			if(u.getUserName()!=null&&!u.getUserName().equals("")&&u.getPass()!=null&&!u.getPass().equals("")){
				String pass = us.hash(u);
				u.setPass(pass);
				String uid=String.valueOf(Integer.valueOf(us.get())+1);
				u.setUserId(uid);
				User_Role urole = new User_Role();
				urole.setRid(u.getIdtype());
				urole.setUserId(uid);
				urole.setUrid(rs.getUser_RoleId());
				try {
					String str = us.add(u,urole);
				} catch (Exception e) {
					return "login";
				}
			}
		}
		return "register";
	}
	
	
	@RequestMapping("login")//用户登录
	public String login(User u,HttpServletRequest request){
		if(u!=null){
			if(u.getUserName()!=null&&!u.getUserName().equals("")&&u.getPass()!=null&&!u.getPass().equals("")){
				Subject subject = SecurityUtils.getSubject();
				//String pass = us.hash(u);
				UsernamePasswordToken token = new UsernamePasswordToken(u.getUserName(),u.getPass());
				try {
					subject.login(token);
					HttpSession session = request.getSession();
					session.setAttribute("user", u);
					return "index";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "login";
	}
	
	@RequestMapping("enter")//跳转登录页面
	public String enter(){
		return "login";
	}
	
	@RequestMapping("into") //添加用户
	public String register(ModelMap mm){
		List<Role> rlist = rs.findAll();
		List<Staff> slist = ss.findAll(agencyId);
		mm.put("rlist", rlist);
		mm.put("slist", slist);
		return "register";
	}
	@ResponseBody
	@RequestMapping("getInfo") //页面ajax请求角色，员工信息
	public HashMap<String, Object> getInfo(String  userId){
		HashMap<String, Object> map = new HashMap<>();
		List<Role> rlist = rs.findByType();
		List<Staff> slist = ss.findAll(agencyId);
		if(userId!=null&&!userId.equals("")){
			User user = us.findUser(userId);
			map.put("user", user);
		}
		map.put("rlist", rlist);
		map.put("slist", slist);
		return map;
	}
	@RequestMapping("index")//跳转index页面
	public String show(){
		
		return "index";
	}
	@RequestMapping("NewFile")
	public String NewFile(){
		
		return "NewFile";
	}
	@RequestMapping("enterupdateuser")//跳转修改用户页面
	public String enterupdateuser(String userId,ModelMap map){
		map.put("userId", userId);
		return "updateUser";
	}
	
	@RequestMapping("updateuser")//修改用户信息
	public String updateuser(User user){
		us.updateUser(user);
		return "redirect:enterupdateuser?userId="+user.getUserId();
	}
	
	@RequestMapping("urole")//跳转用户信息页面
	public String urole(){
		return "UserRole";
	}
	@RequestMapping("searchURole")//页面ajax查询用户信息
	@ResponseBody
	public List<UserRole>  searchURole(){
		List<UserRole> ulist = us.findAll();
		return ulist;
	}
}
