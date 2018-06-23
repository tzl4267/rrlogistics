package com.tsinghuait.logistics.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orderlist")*/
public class Orderlist { // 订单/结算
    private String barcode; //订单条码

	private String orderNumber;//订单编号

    private String sendername; //发件人名

    private String senderaddress; //发货地址
    
    private Integer sendCid;//寄件城市id cid
    
    private Integer sendPid;//寄件省份id pid
    
    private Integer sendArea ;//寄件区id aid

    private String sendertelenumber; //发货人电话

    private String receivername; //收件人名

    private String receiveraddress; //收件地址
    
    private Integer receiverCid;//收件城市  id cid
    
    private Integer receiverPid;//收件省份id pid
    
    private Integer receiverArea ;//收件区id aid

    private String receivertelenumber; //收件人电话

    private Integer number; //物品数量 默认1

    private Double weight; //重量 默认0

    private Double volume; //体积 默认0

    private String name; //

    private String category; //类别  表GoodsType 商品类别

    private Double packprice; //(包装费)

    private String pkgtype; //包裹类别
    @JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date departtime; //出发时间
    @JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date arrivetime; //到达时间

    private String checkstate; //是否达到 

    private String realreceivertelenumber; //接收营业厅编号/网点编号

	private String stuffId;//揽件用户，关联员工

	private String stus;//订单状态 初始为0 ，使用为1

	private String urgent;//是否加急
	
	private String orderPayType;//付费方式 到付/寄付
	
	private Double moneyTota; //总金额
	
	

	public Double getMoneyTota() {
		return moneyTota;
	}

	public void setMoneyTota(Double moneyTota) {
		this.moneyTota = moneyTota;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	//@Id
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public String getSenderaddress() {
		return senderaddress;
	}

	public void setSenderaddress(String senderaddress) {
		this.senderaddress = senderaddress;
	}

	public String getSendertelenumber() {
		return sendertelenumber;
	}

	public void setSendertelenumber(String sendertelenumber) {
		this.sendertelenumber = sendertelenumber;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getReceiveraddress() {
		return receiveraddress;
	}

	public void setReceiveraddress(String receiveraddress) {
		this.receiveraddress = receiveraddress;
	}

	public String getReceivertelenumber() {
		return receivertelenumber;
	}

	public void setReceivertelenumber(String receivertelenumber) {
		this.receivertelenumber = receivertelenumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPackprice() {
		return packprice;
	}

	public void setPackprice(Double packprice) {
		this.packprice = packprice;
	}

	public String getPkgtype() {
		return pkgtype;
	}

	public void setPkgtype(String pkgtype) {
		this.pkgtype = pkgtype;
	}

	public Date getDeparttime() {
		return departtime;
	}

	public void setDeparttime(Date departtime) {
		this.departtime = departtime;
	}

	public Date getArrivetime() {
		return arrivetime;
	}

	public void setArrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}

	public String getRealreceivertelenumber() {
		return realreceivertelenumber;
	}

	public void setRealreceivertelenumber(String realreceivertelenumber) {
		this.realreceivertelenumber = realreceivertelenumber;
	}

	public String getStuffId() {
		return stuffId;
	}

	public void setStuffId(String stuffId) {
		this.stuffId = stuffId;
	}

	public String getStus() {
		return stus;
	}

	public void setStus(String stus) {
		this.stus = stus;
	}

	public String getUrgent() {
		return urgent;
	}

	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}

	
	public String getOrderPayType() {
		return orderPayType;
	}

	public void setOrderPayType(String orderPayType) {
		this.orderPayType = orderPayType;
	}

	
	
	public Integer getSendCid() {
		return sendCid;
	}

	public void setSendCid(Integer sendCid) {
		this.sendCid = sendCid;
	}

	public Integer getSendPid() {
		return sendPid;
	}

	public void setSendPid(Integer sendPid) {
		this.sendPid = sendPid;
	}

	public Integer getSendArea() {
		return sendArea;
	}

	public void setSendArea(Integer sendArea) {
		this.sendArea = sendArea;
	}

	public Integer getReceiverCid() {
		return receiverCid;
	}

	public void setReceiverCid(Integer receiverCid) {
		this.receiverCid = receiverCid;
	}

	public Integer getReceiverPid() {
		return receiverPid;
	}

	public void setReceiverPid(Integer receiverPid) {
		this.receiverPid = receiverPid;
	}

	public Integer getReceiverArea() {
		return receiverArea;
	}

	public void setReceiverArea(Integer receiverArea) {
		this.receiverArea = receiverArea;
	}

	public Orderlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}