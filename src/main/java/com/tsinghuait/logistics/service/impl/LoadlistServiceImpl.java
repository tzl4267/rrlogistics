package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsinghuait.logistics.mapper.LoadlistDao;
import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Driver;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Orderlist;
import com.tsinghuait.logistics.pojo.Staff;
import com.tsinghuait.logistics.pojo.Truck;
import com.tsinghuait.logistics.service.LoadlistService;
@Service
public class LoadlistServiceImpl implements LoadlistService{

	@Resource
	LoadlistDao ld;



	//司机编号
	@Override
	public List<Driver> selectdr() {

		return ld.selectdr();
	}
//车辆代号
	@Override
	public List<Truck> selecttu() {
		return ld.selecttu();
	}
	//网络编点
	@Override
	public List<Orderlist> selectol() {

		return ld.selectol();
	}
	//员工
	@Override
	public List<Staff> selectst() {

		return ld.selectst();
	}
	//本营业厅编号
	@Override
	public List<Agency> selectag() {
		
		return ld.selectag();
	}
	//装车管理
	@Override
	public List<Loadlist> selectlo() {

		return ld.selectlo();
	}
	//生成装车单
	@Override
	public void update(Loadlist loadlist) {
		
		ld.update(loadlist);
		
	}
	//自动生成装车单编号
	@Override
	public void insertlo(Loadlist loadlist) {
		ld.insertlo(loadlist);
		
	}



}
