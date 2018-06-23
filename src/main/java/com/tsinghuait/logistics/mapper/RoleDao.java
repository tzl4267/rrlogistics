package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Role;
import com.tsinghuait.logistics.pojo.User_Role;

public interface RoleDao {
	List<Role> findAll();//查询所有角色
	
	//管理人员给用户赋予角色时根据网点类型显示可使用角色 如网点负责人给网点工作人员赋予营业厅业务员角色，此时中转中心相关角色不应显示
	List<Role> findByType(String str);//通过网点类型选择角色
	
	String getUser_RoleId();//获取user_role id
	
	void insertUser_Role(User_Role ur);//添加用户角色关联信息
	
}
