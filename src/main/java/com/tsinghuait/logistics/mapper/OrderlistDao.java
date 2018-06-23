package com.tsinghuait.logistics.mapper;


import java.util.List;

import com.tsinghuait.logistics.pojo.Orderlist;

public interface OrderlistDao {

	//根据id查询
	Orderlist selector(String orderNumber );
	//修改收件人姓名
	void updateor(Orderlist orderlist);
	//修改状态
	void updateod(Orderlist orderlist);

	//查询没有使用的订单 既stus=0
	List<Orderlist> selectOrderlists();
	//按订单id来查询订单
	Orderlist updateSelectOrderlist(String orderNumber);
	//通过id查询订单后，订单表只有id和状态  需要更改其他属性
	void updateOrderlist(Orderlist orderlist);
	//生成空白订单
	void insertOrderlist(Orderlist orderlist);
}
