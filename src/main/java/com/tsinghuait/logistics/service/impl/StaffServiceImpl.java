package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
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
	
	@Value("${rrlogistics.agencyId}")  
    private String agencyId;  
	
	
	@Override
	public String add(Staff s) {//添加员工
		String staffId = getStaffId();
		s.setStaffId(staffId);
		sd.insert(s);
		s.setAgencyid(agencyId);
		return "ok";
	}

	@Override
	public List<Staff> findByInfo(String staffId) {//根据员工id模糊查询
		List<Staff> slist = sd.selectByInfo(staffId);
		return slist;
	}

	@Override
	public List<Staff> findAll(String agencyid) {//根据网点id查询所有员工
		List<Staff> slist = sd.selectAll(agencyid);
		return slist;
	}

	@Override
	public String getStaffId() {//获取最后一个id
		String staffId = sd.getStaffId();
		if(staffId==null){
			staffId=agencyId+"100";
		}else{
			String str = staffId.substring(5);
			staffId=agencyId+String.valueOf(Integer.valueOf(str)+1);
		}
		
		return staffId;
	}

	
	
	@Override
	public List<Staff> selectStaffs() {
		return sd.selectStaffs();
	}

}
