package com.tsinghuait.logistics.pojo;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="agency")
public class Agency { //机构 代理 网点
    private String agencyId; //机构编号

    private String agencyName; //机构名称  地址 襄樊市樊城区建设路257号


	private Integer cid;//城市id

	private String cType;//机构类型 营业网点/中转中心  

	//@Id
	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Agency() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
   
}