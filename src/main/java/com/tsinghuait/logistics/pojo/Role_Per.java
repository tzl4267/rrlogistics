/**
 * 
 */
package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//权限 角色关联表
@Entity
@Table(name="role_per")*/
public class Role_Per {

	private String rpid;//
	private String pid;//权限id
	private String rid;//角色id
	
	//@Id
	public String getRpid() {
		return rpid;
	}
	public void setRpid(String rpid) {
		this.rpid = rpid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public Role_Per() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
