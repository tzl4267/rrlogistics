package com.tsinghuait.logistics.pojo;

import java.util.Date;

/*import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankaccount")*/
public class Bankaccount { //银行账户

	private String bid;//账号id

    private String bNumber; //卡号

	private String stuffId;//员工id

    private Date bTime; //转账时间

	private Double money;//转账金额

	private String wid;//工资管理id

	//@Id
	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	

	public String getbNumber() {
		return bNumber;
	}

	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}

	public String getStuffId() {
		return stuffId;
	}

	public void setStuffId(String stuffId) {
		this.stuffId = stuffId;
	}

	

	public Date getbTime() {
		return bTime;
	}

	public void setbTime(Date bTime) {
		this.bTime = bTime;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public Bankaccount() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}