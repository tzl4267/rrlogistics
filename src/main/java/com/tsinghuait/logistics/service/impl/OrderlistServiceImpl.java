package com.tsinghuait.logistics.service.impl;

import java.util.List;

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

	
	@Override
	public List<Orderlist> selectOrderlists() {
		return od.selectOrderlists();
	}

	@Override
	public Orderlist updateSelectOrderlist(String orderNumber) {
		return od.updateSelectOrderlist(orderNumber);
	}

	@Override
	public void updateOrderlist(Orderlist orderlist) {
		orderlist.setStus("1");
		od.updateOrderlist(orderlist);
	}


	@Override
	public void insertOrderlist(Orderlist orderlist) {
		od.insertOrderlist(orderlist);
	}

}
