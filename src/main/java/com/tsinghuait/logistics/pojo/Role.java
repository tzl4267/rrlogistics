/**
 * 
 */
package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//角色
@Entity
@Table(name="role")*/
public class Role {
        private String rid;// 
	    private String rname;//角色名称
	    private String rinfo;//角色信息
	    
	    //@Id
		public String getRid() {
			return rid;
		}
		public void setRid(String rid) {
			this.rid = rid;
		}
		public String getRname() {
			return rname;
		}
		public void setRname(String rname) {
			this.rname = rname;
		}
		public String getRinfo() {
			return rinfo;
		}
		public void setRinfo(String rinfo) {
			this.rinfo = rinfo;
		}
		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}
	   
	    
}
