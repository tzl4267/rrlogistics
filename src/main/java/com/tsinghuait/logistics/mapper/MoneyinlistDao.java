package com.tsinghuait.logistics.mapper;

import com.tsinghuait.logistics.pojo.Moneyinlist;

public interface MoneyinlistDao {
	//订单完成输入后，向收款明细表添加收款记录
   void insertMoneyinlist(Moneyinlist moneyinlist);
}
