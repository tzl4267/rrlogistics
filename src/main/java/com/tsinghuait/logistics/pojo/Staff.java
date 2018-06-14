package com.tsinghuait.logistics.pojo;

import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")*/
public class Staff { //员工
    private String staffId; //编号

    private String name; //姓名

    private String sex; //性别

    private String position; //职位 工资根据工龄 基本工资 绩效 扣工资 实上班时间计算
	//基本工资*（实上班时间/应上班时间）+工龄*（一年应涨工资）+绩效-处罚
	// 绩效 根据职位确定绩效算法


    private String idnumber; //身份证号

    private Date workingstarttime; //工作开始时间 计算工龄
    
    private Integer seniority;//工龄  计时器 月底计算员工工龄

    private String phonenum; //电话

    private String agencyid; //机构编号 --> Agency
    


	

	public String getName() {
		return name;
	}
	 // @Id
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public Date getWorkingstarttime() {
		return workingstarttime;
	}

	public void setWorkingstarttime(Date workingstarttime) {
		this.workingstarttime = workingstarttime;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(String agencyid) {
		this.agencyid = agencyid;
	}

	
	public Integer getSeniority() {
		return seniority;
	}

	public void setSeniority(Integer seniority) {
		this.seniority = seniority;
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}