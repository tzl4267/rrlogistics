package com.tsinghuait.logistics.pojo;

import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="driver")*/
public class Driver { //司机
    private String driverNum; //司机编号

    private String driverName; //姓名
    
    private Integer age; //年龄

    private String idnum; //身份证号

    private String phonenum; //电话号码

    private String sex; //性别

    private Date drivinglicenceperiod; //驾驶证期限
    
    private String dStu;//状态


	

	public Integer getAge() {
		return age;
	}
    //@Id
	public String getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDrivinglicenceperiod() {
		return drivinglicenceperiod;
	}

	public void setDrivinglicenceperiod(Date drivinglicenceperiod) {
		this.drivinglicenceperiod = drivinglicenceperiod;
	}

	
	public String getdStu() {
		return dStu;
	}

	public void setdStu(String dStu) {
		this.dStu = dStu;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}