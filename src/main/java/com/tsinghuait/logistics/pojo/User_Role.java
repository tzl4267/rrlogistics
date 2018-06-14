/**
 * 
 */
package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//用户 角色关联
@Entity
@Table(name="user_role")*/
public class User_Role {

	private String urid;
	private String userId;//用户id
	private String rid;//角色id
	
	//@Id
	public String getUrid() {
		return urid;
	}
	public void setUrid(String urid) {
		this.urid = urid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public User_Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
