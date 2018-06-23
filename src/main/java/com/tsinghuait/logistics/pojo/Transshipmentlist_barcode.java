    package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transshipmentlist_barcode")*/
public class Transshipmentlist_barcode {//转运清单 
    private String primarykey; 

    private String orderNumber; //包裹 编号

    private String tranId; //转运清单 id

    private String state; //商品状态

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

	

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Transshipmentlist_barcode() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}