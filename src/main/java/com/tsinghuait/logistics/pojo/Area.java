package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area")*/
public class Area {//区域

	private Integer aid;//
	
	private String aName;//区域名称
	
	private Integer cid;//所属城市

	//@Id
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
