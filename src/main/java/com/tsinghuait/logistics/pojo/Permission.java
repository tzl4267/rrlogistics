/**
 * 
 */
package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//权限
@Entity
@Table(name="permission")*/
public class Permission {

	     private String pid;// 权限id
	     private String pname;//权限名称
	     private String purl;//权限路径
	     private String pinfo;//权限备注
	     
	    // @Id
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPurl() {
			return purl;
		}
		public void setPurl(String purl) {
			this.purl = purl;
		}
		public String getPinfo() {
			return pinfo;
		}
		public void setPinfo(String pinfo) {
			this.pinfo = pinfo;
		}
		public Permission() {
			super();
			// TODO Auto-generated constructor stub
		}
	     

}
