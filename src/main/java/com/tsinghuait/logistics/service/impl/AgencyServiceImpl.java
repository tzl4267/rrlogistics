package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

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
	}

}
