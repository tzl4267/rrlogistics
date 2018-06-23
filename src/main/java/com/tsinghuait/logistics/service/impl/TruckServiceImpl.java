package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.TruckDao;
import com.tsinghuait.logistics.pojo.Truck;
import com.tsinghuait.logistics.service.TruckService;

@Service
@Transactional
public class TruckServiceImpl implements TruckService {
	@Resource
	private TruckDao td;

	@Override
	public List<Truck> selectTruck() {
		return td.selectTruck();
	}

}
