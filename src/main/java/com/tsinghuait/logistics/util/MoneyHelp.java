package com.tsinghuait.logistics.util;

import com.tsinghuait.logistics.pojo.Moneyinlist;
import com.tsinghuait.logistics.pojo.PageBean;

public class MoneyHelp {//wj 结算管理用
	
	private Double sum_money;
	private PageBean<Moneyinlist> pagebean;
	public Double getSum_money() {
		return sum_money;
	}
	public void setSum_money(Double sum_money) {
		this.sum_money = sum_money;
	}
	public PageBean<Moneyinlist> getPagebean() {
		return pagebean;
	}
	public void setPagebean(PageBean<Moneyinlist> pagebean) {
		this.pagebean = pagebean;
	}

}
