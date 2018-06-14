package com.tsinghuait.logistics.pojo;

import java.util.Date;

/*import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certificates")*/
public class Certificates { //证件管理


		private Integer cid;//
		
		private String cNumber;//证件编号
		
		
		private Date cTime;//年审时间
		
		
		private Date overTime;//过期时间
		
		
		private Integer did;//证件类型编号 DocumentType

		
		

		public String getcNumber() {
			return cNumber;
		}


		public void setcNumber(String cNumber) {
			this.cNumber = cNumber;
		}




		public Date getcTime() {
			return cTime;
		}


		public void setcTime(Date cTime) {
			this.cTime = cTime;
		}


		public Date getOverTime() {
			return overTime;
		}


		public void setOverTime(Date overTime) {
			this.overTime = overTime;
		}


		

		//@Id
		public Integer getCid() {
			return cid;
		}


		public void setCid(Integer cid) {
			this.cid = cid;
		}


		public Integer getDid() {
			return did;
		}


		public void setDid(Integer did) {
			this.did = did;
		}


		public Certificates() {
			super();
			// TODO Auto-generated constructor stub
		}






}