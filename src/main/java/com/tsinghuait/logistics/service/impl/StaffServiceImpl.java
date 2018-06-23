package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.StaffDao;
import com.tsinghuait.logistics.pojo.Staff;
import com.tsinghuait.logistics.service.StaffService;
@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	@Resource
	private StaffDao sd;
	@Override
	public List<Staff> selectStaffs() {
		return sd.selectStaffs();
	}

}
