package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="loadlistbarcode")*/
public class Loadlistbarcode { //装车运输清单条形码
    private Integer transkey; //编号

    private String orderNumber; //订单编号

    private String transNumber; //运输编号 

    

	

	public String getOrderNumber() {
		return orderNumber;
	}
    //@Id
	public Integer getTranskey() {
		return transkey;
	}

	public void setTranskey(Integer transkey) {
		this.transkey = transkey;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getTransNumber() {
		return transNumber;
	}

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}

	public Loadlistbarcode() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}