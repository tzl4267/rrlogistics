package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Truck;

public interface TruckService {
	//查询车辆信息
	List<Truck> selectTruckAll(Truck truck);
	//删除车辆
	void deleteTruck(String vehiclecode);
	//按车辆id查询
	Truck updateSelectTruck(String vehiclecode);
	//修改车辆
	void updateTruck(Truck truck);
	//添加车辆
	void insertTruck(Truck truck);
}
