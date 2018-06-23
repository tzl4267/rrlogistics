package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.City;

public interface CityDao {
	//查询市 给订单模块用
	List<City> selectCity();
}
