package com.tsinghuait.logistics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsinghuait.logistics.mapper.OrderlistDao;
import com.tsinghuait.logistics.pojo.Orderlist;
import com.tsinghuait.logistics.service.OrderlistService;
@Service
public class OrderlistServiceImpl implements OrderlistService{

			@Resource
			private OrderlistDao od;

	//根据id查询
	@Override
	public Orderlist selector(String orderNumber) {
		
		return od.selector(orderNumber);
		
	}
	//修改收件人姓名
	@Override
	public void updateor(Orderlist orderlist) {
		od.updateor(orderlist);
		
	}
	//修改状态
	@Override
	public void updateod(Orderlist orderlist) {
		od.updateod(orderlist);
		
	}



}
