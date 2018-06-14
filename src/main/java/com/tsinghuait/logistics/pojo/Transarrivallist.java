package com.tsinghuait.logistics.pojo;

import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Transarrivallist")*/
public class Transarrivallist { //车辆抵达表
    private String tlId;

    private String transfernumber; //运输编号 包括转运编号 和 装车单号

    private String centernumber; //抵达（网点编号） 该网点或者中转编号

    private Date tlTimee; //抵达时间

    private String departureplace; //出发地

    private String checkstate; //抵达状态

    
	

	public String getCenternumber() {
		return centernumber;
	}

	public void setCenternumber(String centernumber) {
		this.centernumber = centernumber;
	}

	
	//@Id
	public String getTlId() {
		return tlId;
	}

	public void setTlId(String tlId) {
		this.tlId = tlId;
	}

	public Date getTlTimee() {
		return tlTimee;
	}

	public void setTlTimee(Date tlTimee) {
		this.tlTimee = tlTimee;
	}

	public String getDepartureplace() {
		return departureplace;
	}

	public void setDepartureplace(String departureplace) {
		this.departureplace = departureplace;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}

	public String getTransfernumber() {
		return transfernumber;
	}

	public void setTransfernumber(String transfernumber) {
		this.transfernumber = transfernumber;
	}

	public Transarrivallist() {
		super();
		// TODO Auto-generated constructor stub
	}

  
}