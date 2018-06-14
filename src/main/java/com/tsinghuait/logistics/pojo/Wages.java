package com.tsinghuait.logistics.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="wages")*/
public class Wages { //工资管理

    private String wid; //工资管理id
    
   	private String staffId;//员工id

	private Double pay;//实发
	
	private Double payment;//应付

	private Double baseWages;//基本工资
   
	private Double meritPay ;//绩效工资

	private Double seniorityPay;//工龄工资
	
    private Double personalLeave;//事假应扣

	private Double sickLeave ;//病假应扣

	private Double socialSecurity ;//社保代缴

	private Double incomeTax ;//所得税代缴

	
	//@Id
	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getBaseWages() {
		return baseWages;
	}

	public void setBaseWages(Double baseWages) {
		this.baseWages = baseWages;
	}

	public Double getMeritPay() {
		return meritPay;
	}

	public void setMeritPay(Double meritPay) {
		this.meritPay = meritPay;
	}

	public Double getSeniorityPay() {
		return seniorityPay;
	}

	public void setSeniorityPay(Double seniorityPay) {
		this.seniorityPay = seniorityPay;
	}

	public Double getPersonalLeave() {
		return personalLeave;
	}

	public void setPersonalLeave(Double personalLeave) {
		this.personalLeave = personalLeave;
	}

	public Double getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Double sickLeave) {
		this.sickLeave = sickLeave;
	}

	public Double getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(Double socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public Double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
	}

	public Wages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}