package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Staff;

public interface StaffDao {

	
	void insert(Staff s);//添加员工
	
	List<Staff> selectByInfo(String staffId);//根据员工id模糊查询
	
	List<Staff> selectAll(String agencyid);//根据网点id查询所有员工
	
	String getStaffId();//获取最后一个id
	//查询用户    订单模块需要揽件员
	List<Staff> selectStaffs();
}
