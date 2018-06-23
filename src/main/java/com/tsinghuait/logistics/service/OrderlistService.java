package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Orderlist;

public interface OrderlistService {
	//查询没有使用的订单 既stus=0
	List<Orderlist> selectOrderlists();
	//按订单id来查询订单
	Orderlist updateSelectOrderlist(String orderNumber);
	//通过id查询订单后，订单表只有id和状态  需要更改其他属性
	void updateOrderlist(Orderlist orderlist);
	//生成空白订单
	void insertOrderlist(Orderlist orderlist);
}	
