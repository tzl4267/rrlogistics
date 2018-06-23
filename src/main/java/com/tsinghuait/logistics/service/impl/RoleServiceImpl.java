package com.tsinghuait.logistics.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.RoleDao;
import com.tsinghuait.logistics.pojo.Role;
import com.tsinghuait.logistics.pojo.User_Role;
import com.tsinghuait.logistics.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	
	@Resource
	private RoleDao rd;
	
	@Value("${rrlogistics.type}")  
	private String type; 

	@Override
	public List<Role> findAll() {//查询所有角色
		List<Role> rlist = rd.findAll();
		return rlist;
	}


	@Override
	public List<Role> findByType() {//通过网点类型选择角色
		String str = null;
		List<Role> rlist = new ArrayList<>();
		switch(type){
		case "1": str = "营业厅";break;
		case "2": str = "中转中心";break;
		case "3": str = "";break;
		case "4": rlist=rd.findAll();return rlist;
		}
		System.out.println(str);
		rlist = rd.findByType(str);
		return rlist;
	}
	
	@Override
	public String getUser_RoleId() {//获取user_role id
		String urid = rd.getUser_RoleId();
		if(urid==null){
			urid="100";
		}else{
			String str = urid.substring(2);
			urid="ur"+String.valueOf(Integer.valueOf(str)+1);
		}
		return urid;
	}


	@Override
	public void addUser_Role(User_Role ur) throws Exception {//添加用户角色关联信息
		try {
			rd.insertUser_Role(ur);
		} catch (Exception e) {
			throw new Exception();
		}
		
		
	}
	
}
