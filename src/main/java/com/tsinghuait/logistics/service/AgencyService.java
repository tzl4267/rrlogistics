package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Agency;

<<<<<<< HEAD
public interface AgencyService {
	
	List<Agency> findByInfo(String agencyId);//根据网点id模糊查询相关网点
	
	
	List<Agency> findAll();//查询所有网点
	

=======

public interface AgencyService {
	//查询网点表   给车辆信息 和 订单用
	List<Agency> selectAgency();
>>>>>>> refs/heads/xlb01
}
