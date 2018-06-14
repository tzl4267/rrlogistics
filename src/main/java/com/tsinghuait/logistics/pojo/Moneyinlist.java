package com.tsinghuait.logistics.pojo;

import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="moneyinlist")*/
public class Moneyinlist { //收款明细
    private String mid; //编号

    private Date mTimee; //时间

    private Double moneyTota; //总金额
    
    private Double PackingMoney;//包装费用
    
    private Double Postage;//邮费
    
    private Double protectValue;//保价

	private String payType;//付款方式 现金、银行转账

    private String staffid; //员工编号 --> staff

    private String checkstate; //状态

    private String orderNumber; // 订单编号

    private String payer; //付款人
	
	private String note; //备注

	

	



	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	
	//@Id
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Date getmTimee() {
		return mTimee;
	}

	public void setmTimee(Date mTimee) {
		this.mTimee = mTimee;
	}

	public Double getMoneyTota() {
		return moneyTota;
	}

	public void setMoneyTota(Double moneyTota) {
		this.moneyTota = moneyTota;
	}

	public Double getPackingMoney() {
		return PackingMoney;
	}

	public void setPackingMoney(Double packingMoney) {
		PackingMoney = packingMoney;
	}

	public Double getPostage() {
		return Postage;
	}

	public void setPostage(Double postage) {
		Postage = postage;
	}

	public Double getProtectValue() {
		return protectValue;
	}

	public void setProtectValue(Double protectValue) {
		this.protectValue = protectValue;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Moneyinlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    

   

   

    

  

    

   

  
}