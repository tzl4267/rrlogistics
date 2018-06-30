package com.tsinghuait.logistics.pojo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private int allCount;// 数据库总记录数
	private int pageNumber = 5;// 每页显示几条数据
	private int nowPage = 1;// 当前所在页面
	private int allPage;// 分页总页数
	private List<T> ll = new ArrayList<>();

	public List<T> getLl() {
		return ll;
	}

	public void setLl(List<T> ll) {
		this.ll = ll;
	}

	// 设置默认每页显示数据是2条
	public PageBean() {
		this.setPageNumber(2);
	}

	// 根据需要设置每页显示数据条数
	public PageBean(int pageNumber) {
		this.setPageNumber(pageNumber);
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getAllPage() {
		int a = this.getAllCount();// 得到从数据库中查询的总页数
		int b = this.getPageNumber();// 得到每页上设置的记录条数
		// 总结这里定义两个变量来接收接收从数据库中查询的总页数和每页上设置的记录条数
		// 原因是可以减少对数据库的访问次数，从而使功能得到优化
		this.allPage = a % b == 0 ? a / b : a / b + 1;// 得到总页数方法:
		// this.allPage = (int) (Math.ceil(a * 1.0 / b));
		// a%b如果=0，表示没有余数，总页数就是a/b结果
		// a%b如果！=0，表示有余数，总页数就是a/b结果还要加1
		return this.allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
}
