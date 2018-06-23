package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Agency;

public interface AgencyDao {

	List<Agency> selectByInfo(String agencyId);//根据网点id模糊查询相关网点
	
	
	List<Agency> selectAll();//查询所有网点
	
	//查询网点表   给车辆信息 和 订单用
	List<Agency> selectAgency();
}
