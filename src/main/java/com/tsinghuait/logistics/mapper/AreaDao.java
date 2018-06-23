package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Area;

public interface AreaDao {
	//查询区 给订单模块用
	List<Area> selectAreas();
}
