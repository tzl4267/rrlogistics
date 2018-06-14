package com.tsinghuait.logistics.pojo;

import java.util.Date;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="repertoryout")*/
public class Repertoryout { //出库管理
    private String roId; 

    private String orderNumber; //订单编号

    private Date roTime; //出库日期

    private String destination; //目的地

    private String transportation; //装运方式

    private String checkstate; //出库状态

    
  
	

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	//@Id
	public String getRoId() {
		return roId;
	}

	public void setRoId(String roId) {
		this.roId = roId;
	}

	public Date getRoTime() {
		return roTime;
	}

	public void setRoTime(Date roTime) {
		this.roTime = roTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}

	public Repertoryout() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}