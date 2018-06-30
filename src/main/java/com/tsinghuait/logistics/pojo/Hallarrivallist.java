package com.tsinghuait.logistics.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="hallarrivallist")*/
public class Hallarrivallist { //中转接收 HallArrivalList 
    private String hid; //编号
    
  
    @DateTimeFormat(pattern="yyyy-MM-dd")
   // @JsonFormat(pattern="yyyy-MM-dd")
    private Date timee; //到达日期
    
  //中转单号   对应 Transshipmentlist //转运表 tranid 或者 装车表 Loadlist  transNumber; 运输编号
    private String transferNumber; 
   
    private String agencyId; //本中心站名称
    
   
    
    private String checkstate; //货物到达状态


    
   
    public Date getTimee() {
        return timee;
    }
     
    public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}
	// 
	
	public void setTimee(Date timee) {
        this.timee = timee;
    }

   

    public String getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}

	public String getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(String checkstate) {
        this.checkstate = checkstate;
    }

	public Hallarrivallist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
	@Override
	public String toString() {
		return "Hallarrivallist [hid=" + hid + ", timee=" + timee + ", transferNumber=" + transferNumber + ", agencyId="
				+ agencyId + ", checkstate=" + checkstate + "]";
	}
	
    
	
    
}