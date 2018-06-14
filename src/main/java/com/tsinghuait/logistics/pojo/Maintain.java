package com.tsinghuait.logistics.pojo;

import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="maintain")*/
public class Maintain{//保养记录

	private Integer mid;//


	private String vehiclecode;//车辆代号

	private String mInfo;//备注

	private Date time;//保养时间

	private Double money;//金额

	private String drivernum;//司机编号

	private String userId;//经手人

	

	

	public String getVehiclecode() {
		return vehiclecode;
	}
	//@Id
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}

	public String getmInfo() {
		return mInfo;
	}

	public void setmInfo(String mInfo) {
		this.mInfo = mInfo;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
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

	public Maintain() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}