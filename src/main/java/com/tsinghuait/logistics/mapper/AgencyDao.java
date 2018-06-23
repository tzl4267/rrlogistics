package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Agency;


public interface AgencyDao {
	//查询网点表   给车辆信息 和 订单用
	List<Agency> selectAgency();
}
