package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Area;

public interface AreaService {
	//查询区 给订单模块用
	List<Area> selectAreas();
}
