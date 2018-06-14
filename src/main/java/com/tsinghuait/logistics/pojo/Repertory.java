package com.tsinghuait.logistics.pojo;

import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="repertory")*/
public class Repertory {//仓库管理

	 	private String rid; //编号

	    private String orderNumber; //订单编号

	    private Date rTimee; //入库时间

	    private String areanumber; //第n区

	    private String rownumber; //第n行

	    private String framenumber; //第n排

	    private String placenumber; //第n位

	    private String checkstate; //入库状态
	
	    private String riId;//入库管理id Repertoryin

	    

		

		public String getOrderNumber() {
			return orderNumber;
		}

		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}

		public String getAreanumber() {
			return areanumber;
		}

		public void setAreanumber(String areanumber) {
			this.areanumber = areanumber;
		}

		public String getRownumber() {
			return rownumber;
		}

		public void setRownumber(String rownumber) {
			this.rownumber = rownumber;
		}

		public String getFramenumber() {
			return framenumber;
		}

		public void setFramenumber(String framenumber) {
			this.framenumber = framenumber;
		}

		public String getPlacenumber() {
			return placenumber;
		}

		public void setPlacenumber(String placenumber) {
			this.placenumber = placenumber;
		}

		public String getCheckstate() {
			return checkstate;
		}

		public void setCheckstate(String checkstate) {
			this.checkstate = checkstate;
		}

		 //@Id
		public String getRid() {
			return rid;
		}

		public void setRid(String rid) {
			this.rid = rid;
		}

		
		public Date getrTimee() {
			return rTimee;
		}

		public void setrTimee(Date rTimee) {
			this.rTimee = rTimee;
		}

		public String getRiId() {
			return riId;
		}

		public void setRiId(String riId) {
			this.riId = riId;
		}

		public Repertory() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
