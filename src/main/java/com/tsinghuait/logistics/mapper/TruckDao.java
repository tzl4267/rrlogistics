package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Truck;
/*查询所有汽车编号*/
public interface TruckDao {
	/*查询所有汽车编号方法*/
	List<Truck> selectTruck1();


	//查询车辆信息
	List<Truck> selectTruck(Truck truck);
	//删除车辆
	void deleteTruck(String vehiclecode);
	//按车辆id查询
	Truck updateSelectTruck(String vehiclecode);
	//修改车辆
	void updateTruck(Truck truck);
	//添加车辆
	void insertTruck(Truck truck);
}
