package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.CityDao;
import com.tsinghuait.logistics.pojo.City;
import com.tsinghuait.logistics.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService{
	@Resource
	private CityDao cd;
	@Override
	public List<City> selectCity() {
		return cd.selectCity();
	}

}
