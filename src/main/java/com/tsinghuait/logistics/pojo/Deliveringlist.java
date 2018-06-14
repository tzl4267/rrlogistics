package com.tsinghuait.logistics.pojo;

import java.util.Date;

/*import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="deliveringlist")*/
public class Deliveringlist { //派件

	private String did;//主键

	private String orderNumber; //订单编号

    private Date timee; //到达日期 

    private String deliveryman; //派送员

    private String checkstate; //状态 是否签收

	private String dInfo;//备注 未签收

	//@Id
	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getTimee() {
		return timee;
	}

	public void setTimee(Date timee) {
		this.timee = timee;
	}

	public String getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(String deliveryman) {
		this.deliveryman = deliveryman;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}

	public String getdInfo() {
		return dInfo;
	}

	public void setdInfo(String dInfo) {
		this.dInfo = dInfo;
	}

	public Deliveringlist() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}