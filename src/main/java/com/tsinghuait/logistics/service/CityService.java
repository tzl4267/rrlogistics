package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.City;

public interface CityService {
	//查询市 给订单模块用
	List<City> selectCity();
}
