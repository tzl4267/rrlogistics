package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.OrderlistDao;
import com.tsinghuait.logistics.pojo.Orderlist;
import com.tsinghuait.logistics.service.OrderlistService;
@Service
@Transactional
public class OrderlistServiceImpl implements OrderlistService{
	
	@Resource
	private OrderlistDao od;
	
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
