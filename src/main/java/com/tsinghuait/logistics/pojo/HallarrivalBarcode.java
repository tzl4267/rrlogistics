package com.tsinghuait.logistics.pojo;
/*import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="hallarrivalbarcode")*/
public class HallarrivalBarcode {//中转接收清单
	
	private String hBId;
	
	private String hid; //接收编号 
	
	private String orderNumber;//订单编号
	
	private String hType;//到达状态
	
	

	//@Id
	public String gethBId() {
		return hBId;
	}

	public void sethBId(String hBId) {
		this.hBId = hBId;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String gethType() {
		return hType;
	}

	public void sethType(String hType) {
		this.hType = hType;
	}

	public HallarrivalBarcode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
