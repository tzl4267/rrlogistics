package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Staff;

public interface StaffService {

	
	String add(Staff s);//添加员工
	
	List<Staff> findByInfo(String staffId);//根据员工id模糊查询
	
	List<Staff> findAll(String agencyid);//根据网点id查询所有员工
	
	String getStaffId();//获取最后一个id
}
