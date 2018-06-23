package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Driver;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Orderlist;
import com.tsinghuait.logistics.pojo.Staff;
import com.tsinghuait.logistics.pojo.Truck;

public interface LoadlistDao {

	//查询装车单
	List<Loadlist> selectlo();
	//查询司机
	List<Driver> selectdr();	
	//查询卡车
	List<Truck> selecttu();
	//查询网点编号
	List<Orderlist> selectol();
	//查询员工编号
	List<Staff> selectst();
	//查询营业网点
	List<Agency> selectag();
	//生成装车单
	void update(Loadlist loadlist);
	//自动生成单号
	void insertlo(Loadlist loadlist);
}
