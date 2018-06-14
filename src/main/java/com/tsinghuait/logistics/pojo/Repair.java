package com.tsinghuait.logistics.pojo;

import java.util.Date;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="repair")*/
public class Repair{//维修管理


	private String rid;//

	private String kilometre;//公里数

	private String vehiclecode;//车辆代号

	private String maintenance;//维修项目

	private String rInfo;//备注

	private Date time;//修理开始时间 

	private String timeSum;//所需时间

	private String drivernum;//申请人 司机

	private String userId;//经手人 财务

	private Double money;//维修金额

	
	//@Id
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getKilometre() {
		return kilometre;
	}

	public void setKilometre(String kilometre) {
		this.kilometre = kilometre;
	}

	public String getVehiclecode() {
		return vehiclecode;
	}

	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}

	public String getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

	public String getrInfo() {
		return rInfo;
	}

	public void setrInfo(String rInfo) {
		this.rInfo = rInfo;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTimeSum() {
		return timeSum;
	}

	public void setTimeSum(String timeSum) {
		this.timeSum = timeSum;
	}

	public String getDrivernum() {
		return drivernum;
	}

	public void setDrivernum(String drivernum) {
		this.drivernum = drivernum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Repair() {
		super();
		// TODO Auto-generated constructor stub
	}


}
