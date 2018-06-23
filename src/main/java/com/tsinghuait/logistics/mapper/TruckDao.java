package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Truck;
/*查询所有汽车编号*/
public interface TruckDao {
	/*查询所有汽车编号方法*/
	List<Truck> selectTruck();
}
