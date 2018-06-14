package com.tsinghuait.logistics.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.service.UserService;

@Controller
@RequestMapping("user")
public class UserCont {

	@Resource
	private UserService us;
	
	
	@RequestMapping("register")
	public String register(User u){
		if(u!=null){
			if(u.getUserName()!=null&&!u.getUserName().equals("")&&u.getPass()!=null&&!u.getPass().equals("")){
				String pass = us.hash(u);
				u.setPass(pass);
				u.setUserId(us.get()+1);
				String str = us.add(u);
				if(str!=null&&str.equals("ok")){
					return "login";
				}
				
			}
		}
		return "register";
	}
	
	
	@RequestMapping("login")
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
					return "show";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "login";
	}
	
	@RequestMapping("enter")
	public String enter(){
		
		return "login";
	}
	
	@RequestMapping("into")
	public String register(){
		
		return "register";
	}
}
