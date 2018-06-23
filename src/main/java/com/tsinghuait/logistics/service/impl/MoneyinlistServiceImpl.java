package com.tsinghuait.logistics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.MoneyinlistDao;
import com.tsinghuait.logistics.pojo.Moneyinlist;
import com.tsinghuait.logistics.service.MoneyinlistService;
@Service
@Transactional
public class MoneyinlistServiceImpl implements MoneyinlistService{
	@Resource
	private MoneyinlistDao md;
	@Override
	public void insertMoneyinlists(Moneyinlist moneyinlist) {
			md.insertMoneyinlist(moneyinlist);
	}

}
