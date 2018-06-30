package com.tsinghuait.logistics.service;

import java.util.List;
import java.util.Map;

import com.tsinghuait.logistics.pojo.Moneyinlist;

public interface MoneyinlistService {
	// 订单完成输入后，向收款明细表添加收款记录
	void insertMoneyinlists(Moneyinlist moneyinlist);

	// 查询收款明细表的总记录数
	Map<String, Object> selectCount(Map<String, Object> map);

	// 按网点查询和日期查询收款明细
	List<Moneyinlist> selectMoneyinlists(Map<String, Object> map);

}
