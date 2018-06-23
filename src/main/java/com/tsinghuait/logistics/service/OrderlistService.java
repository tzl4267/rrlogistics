package com.tsinghuait.logistics.service;

import com.tsinghuait.logistics.pojo.Orderlist;

public interface OrderlistService {

	
	//根据id查询
	Orderlist selector(String orderNumber );
	//修改收件人姓名
	void updateor(Orderlist orderlist);
	//修改状态
	void updateod(Orderlist orderlist);
}
