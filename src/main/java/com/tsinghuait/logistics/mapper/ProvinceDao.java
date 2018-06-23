package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Province;

public interface ProvinceDao {
	//查询省  订单模块使用
	List<Province>selectProvinces();   
}
