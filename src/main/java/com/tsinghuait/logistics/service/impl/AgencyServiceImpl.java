package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.AgencyDao;
import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.service.AgencyService;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService{

	
	
	@Resource
	private AgencyDao ad;
	
	@Override
	public List<Agency> findByInfo(String agencyId) {//根据网点id模糊查询相关网点
		List<Agency> alist = ad.selectByInfo(agencyId);
		return alist;
	}

	@Override
	public List<Agency> findAll() {//查询所有网点
		List<Agency> alist = ad.selectAll();
		return alist;
=======
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.AgencyDao;
import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.service.AgencyService;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService{
	@Resource
	private AgencyDao ad;
	@Override
	public List<Agency> selectAgency() {
		
		return ad.selectAgency();
>>>>>>> refs/heads/xlb01
	}

}
