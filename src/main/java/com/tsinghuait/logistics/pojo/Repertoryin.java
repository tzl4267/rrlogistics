package com.tsinghuait.logistics.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="repertoryin")*/
public class Repertoryin { //入库管理
	
    private String riId; //编号

    private String orderNumber; //订单编号

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date riTimee; //入库时间

    private String destination; //目的地

    private String checkstate; //入库状态

  
	

	public String getOrderNumber() {
		return orderNumber;
	}
	  //@Id
	public String getRiId() {
		return riId;
	}

	public void setRiId(String riId) {
		this.riId = riId;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}

	
	public Date getRiTimee() {
		return riTimee;
	}

	public void setRiTimee(Date riTimee) {
		this.riTimee = riTimee;
	}

	public Repertoryin() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}