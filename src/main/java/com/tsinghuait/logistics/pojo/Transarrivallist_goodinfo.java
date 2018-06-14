package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="transarrivallist_goodinfo")*/
public class Transarrivallist_goodinfo { //抵达清单  到营业网点为抵达
    private String primarykey; //编号

    private String orderNumber; //包裹编号

    private String state; //商品状态

    private String tlId; // --> Transarrivallist //车辆抵达id

   //@Id
	public String getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(String primarykey) {
		this.primarykey = primarykey;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public String getTlId() {
		return tlId;
	}

	public void setTlId(String tlId) {
		this.tlId = tlId;
	}

	public Transarrivallist_goodinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}