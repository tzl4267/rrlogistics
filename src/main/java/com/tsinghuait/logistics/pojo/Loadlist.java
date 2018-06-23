package com.tsinghuait.logistics.pojo;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loadlist")*/
public class Loadlist { //车辆装车管理
    private String transNumber; //运输编号

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat( pattern="yyyy-MM-dd")
    private Date timee; //装车日期

    private String hallnumber; //本营业厅编号

    private String destination; //目的地（网点编号）

    private String carnumber; //车辆代号

    private String guardman; //监管员 营业厅工作人员

    private String supercargoman; //押运员 司机

    private String checkstate; //状态

    private String drivernum;//司机编号

    



	public Date getTimee() {
		return timee;
	}
	// @Id
	public String getTransNumber() {
		return transNumber;
	}

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}

	public void setTimee(Date timee) {
		this.timee = timee;
	}

	public String getHallnumber() {
		return hallnumber;
	}

	public void setHallnumber(String hallnumber) {
		this.hallnumber = hallnumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getGuardman() {
		return guardman;
	}

	public void setGuardman(String guardman) {
		this.guardman = guardman;
	}

	public String getSupercargoman() {
		return supercargoman;
	}

	public void setSupercargoman(String supercargoman) {
		this.supercargoman = supercargoman;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}

	public String getDrivernum() {
		return drivernum;
	}

	public void setDrivernum(String drivernum) {
		this.drivernum = drivernum;
	}

	public Loadlist() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}