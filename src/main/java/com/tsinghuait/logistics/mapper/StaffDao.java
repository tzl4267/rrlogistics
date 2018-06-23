package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Staff;

public interface StaffDao {
	//查询用户    订单模块需要揽件员
	List<Staff> selectStaffs();
}
