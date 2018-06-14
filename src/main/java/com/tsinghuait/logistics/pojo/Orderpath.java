package com.tsinghuait.logistics.pojo;

import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderpath")*/
public class Orderpath { //订单路径
    private String odId; //编号

    private String orderNumber; //订单编号

    private String content; //内容

	private Date oTime;//到达时间

	private String agencyId;//营业网点编号

	private String num;//网点在路径中排位

	
	

	public String getOrderNumber() {
		return orderNumber;
	}

	//@Id
	public String getOdId() {
		return odId;
	}

	public void setOdId(String odId) {
		this.odId = odId;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Date getoTime() {
		return oTime;
	}

	public void setoTime(Date oTime) {
		this.oTime = oTime;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Orderpath() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}