package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Agency;


public interface AgencyService {
	//查询网点表   给车辆信息 和 订单用
	List<Agency> selectAgency();
}
