package com.tsinghuait.logistics.pojo;

import java.util.Date;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="truck")*/
public class Truck { //卡车表
    private String vehiclecode; //车辆代 号

    private String platenumber; //车牌号

    private String servicetimelimit; //使用时间

	private String tStus;//车辆状态

	private String operation;//营运证(证件) Certificates

	private String driving;//行驶证 Certificates

	private String kilometre;//公里数

	private Date motTime;//年检到期时间

	private Double oilConsumption;//油耗
	
	private String agencyId;//网点编号

	//@Id
	public String getVehiclecode() {
		return vehiclecode;
	}

	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}

	public String getServicetimelimit() {
		return servicetimelimit;
	}

	public void setServicetimelimit(String servicetimelimit) {
		this.servicetimelimit = servicetimelimit;
	}

	public String gettStus() {
		return tStus;
	}

	public void settStus(String tStus) {
		this.tStus = tStus;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getDriving() {
		return driving;
	}

	public void setDriving(String driving) {
		this.driving = driving;
	}

	public String getKilometre() {
		return kilometre;
	}

	public void setKilometre(String kilometre) {
		this.kilometre = kilometre;
	}

	public Date getMotTime() {
		return motTime;
	}

	public void setMotTime(Date motTime) {
		this.motTime = motTime;
	}

	public Double getOilConsumption() {
		return oilConsumption;
	}

	public void setOilConsumption(Double oilConsumption) {
		this.oilConsumption = oilConsumption;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}