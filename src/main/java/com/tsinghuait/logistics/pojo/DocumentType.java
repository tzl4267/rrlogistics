package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="documentType")*/
public class DocumentType { //证件类型

    private Integer  dTid; //证件类型id
    
   	private String dName;//证件类型名称


	

	public String getdName() {
		return dName;
	}


	public void setdName(String dName) {
		this.dName = dName;
	}
	
	
   	//@Id
	public Integer getdTid() {
		return dTid;
	}


	public void setdTid(Integer dTid) {
		this.dTid = dTid;
	}


	public DocumentType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}