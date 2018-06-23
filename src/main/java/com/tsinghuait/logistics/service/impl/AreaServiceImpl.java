package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.AreaDao;
import com.tsinghuait.logistics.pojo.Area;
import com.tsinghuait.logistics.service.AreaService;
@Service
@Transactional
public class AreaServiceImpl implements AreaService{
	@Resource
	private AreaDao ad;
	
	@Override
	public List<Area> selectAreas() {
		return ad.selectAreas();
	}

}
