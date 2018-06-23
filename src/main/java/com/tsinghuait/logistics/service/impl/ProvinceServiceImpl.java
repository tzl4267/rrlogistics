package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.ProvinceDao;
import com.tsinghuait.logistics.pojo.Province;
import com.tsinghuait.logistics.service.ProvinceService;
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService{
	@Resource
	private ProvinceDao pd;
	@Override
	public List<Province> selectProvinces() {
		return pd.selectProvinces();
	}

}
