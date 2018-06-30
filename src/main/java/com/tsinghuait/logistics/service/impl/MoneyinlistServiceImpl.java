package com.tsinghuait.logistics.service.impl;

import java.util.List;
import java.util.Map;

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
	/* (non-Javadoc)
	 *订单完成输入后，向收款明细表添加收款记录
	 */
	@Override
	public void insertMoneyinlists(Moneyinlist moneyinlist) {
			md.insertMoneyinlist(moneyinlist);
	}
	
	/* (non-Javadoc)
	 * 查询收款明细表的总记录数
	 */
	@Override
	public Map<String, Object> selectCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return md.selectCount(map);
	}
	/* (non-Javadoc)
	 *  按网点查询和日期查询收款明细
	 */
	@Override
	public List<Moneyinlist> selectMoneyinlists(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return md.selectMoneyinlists(map);
	}

}
