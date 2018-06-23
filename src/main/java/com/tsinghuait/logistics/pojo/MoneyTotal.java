package com.tsinghuait.logistics.pojo;

import java.util.Date;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="moneytotal")*/
public class MoneyTotal {//收款记录
	
		private String mTid; //编号

	    private Date mTime; //时间

	    private Double actualAmount ; //实收

	    private Double receivable;//应收
	    
	    private String mInfo;//备注
	    
	    private String agencyId;//网点编号

	    
	    //@Id
		public String getmTid() {
			return mTid;
		}

		public void setmTid(String mTid) {
			this.mTid = mTid;
		}

		public Date getmTime() {
			return mTime;
		}

		public void setmTime(Date mTime) {
			this.mTime = mTime;
		}

		public Double getActualAmount() {
			return actualAmount;
		}

		public void setActualAmount(Double actualAmount) {
			this.actualAmount = actualAmount;
		}

		public Double getReceivable() {
			return receivable;
		}

		public void setReceivable(Double receivable) {
			this.receivable = receivable;
		}

		public String getmInfo() {
			return mInfo;
		}

		public void setmInfo(String mInfo) {
			this.mInfo = mInfo;
		}

		public String getAgencyId() {
			return agencyId;
		}

		public void setAgencyId(String agencyId) {
			this.agencyId = agencyId;
		}

		public MoneyTotal() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
}
