package com.tsinghuait.logistics.pojo;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="goodtype")*/
public class GoodsType { //货品类型

    private Integer gid; //货品类型id
    
    private String gName; //货品类型名称

   
	

	public String getgName() {
		return gName;
	}
	// @Id
	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}

   

	
    
}