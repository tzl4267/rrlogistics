package com.tsinghuait.logistics.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Staff;
import com.tsinghuait.logistics.service.AgencyService;
import com.tsinghuait.logistics.service.RoleService;
import com.tsinghuait.logistics.service.StaffService;

@Controller
@RequestMapping("staff")
public class StaffConf {

	
	@Resource
	private StaffService ss;
	
	@Resource
	private RoleService rs;
	
	@Resource
	private AgencyService as;
	
	
	
	@RequestMapping("into")//进入添加员工页面
	public String into(ModelMap mm){
		List<Agency> alist = as.findAll();
		mm.put("alist", alist);
		return "increasestaff";
	}
	
	@RequestMapping("increase")//添加员工
	public String increase(Staff s){
		s.setWorkingstarttime(new Date());
		String msg = ss.add(s);
		if(msg!=null&&msg.equals("ok")){
			
		}
		return "increasestaff";
	}
}
