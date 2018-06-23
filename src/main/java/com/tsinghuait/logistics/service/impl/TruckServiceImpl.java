package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.service.TruckService;
import com.tsinghuait.logistics.mapper.TruckDao;
import com.tsinghuait.logistics.pojo.Truck;
@Service
@Transactional
public class TruckServiceImpl implements TruckService{
	@Resource
	private TruckDao td;
	@Override
	public List<Truck> selectTruckAll(Truck truck) {
		return td.selectTruck(truck);
	}
	@Override
	public void deleteTruck(String vehiclecode) {
		td.deleteTruck(vehiclecode);
	}
	@Override
	public Truck updateSelectTruck(String vehiclecode) {
		return td.updateSelectTruck(vehiclecode);
	}
	@Override
	public void updateTruck(Truck truck) {
		td.updateTruck(truck);
	}
	@Override
	public void insertTruck(Truck truck) {
		td.insertTruck(truck);
	}

}
