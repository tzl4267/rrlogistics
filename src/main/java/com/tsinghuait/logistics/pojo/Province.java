

package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="province")*/
public class Province { //省份

    private String pid; //省份
    
    private String pName; //省份名称

    
   // @Id
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

   

	
    
}