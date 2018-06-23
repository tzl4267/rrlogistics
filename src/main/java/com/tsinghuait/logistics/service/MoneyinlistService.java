package com.tsinghuait.logistics.service;


import com.tsinghuait.logistics.pojo.Moneyinlist;

public interface MoneyinlistService {
	//订单完成输入后，向收款明细表添加收款记录
	void insertMoneyinlists(Moneyinlist moneyinlist);
}
