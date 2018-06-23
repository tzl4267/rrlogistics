<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.0.0.js"></script>
<link href="${pageContext.request.contextPath}/js/assets/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/js/assets/css/font-awesome.css" rel="stylesheet" />
<%-- <link href="${pageContext.request.contextPath}/js/assets/css/custom-styles.css" rel="stylesheet" /> --%>
 <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link href="${pageContext.request.contextPath}/js/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
      <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/custom-scripts.js"></script>
    <link href="${pageContext.request.contextPath}/js/jquery.searchableSelect.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery.searchableSelect.js"></script>
</head>
<body>
 <script>
		$(function(){
			$("#select1").searchableSelect();
		});
		function chakanBtn() {
			 $("#chakanModal").modal("show");
			}
		function success() {
			alert("生成成功!");
			}
    </script>
   <br> <br> <br> <br><br> <br><br> <br><br> 
   <div class="container">
   <!-- 添加空白订单 -->
    <form action="${pageContext.request.contextPath}/abc/insertOrderlist">
     <div class="col-sm-2">
    </div>
    <div class="col-sm-2">
    <button class="btn btn-default" type="submit" onclick="success();" >随机添加空白订单 <span class="glyphicon glyphicon-plus"></span></button>
    </div>
    </form>
    <div class="col-sm-4"></div>
      <form action="${pageContext.request.contextPath}/abc/updateSelectOrderlist">
      <div class="col-sm-2">
   <select name="orderNumber" id="select1">
  <option value="0">----请输入快递单号----</option>
 <c:forEach items="${ol}" var="o">
      <option value="${o.orderNumber}">${o.orderNumber}</option>
       </c:forEach>
    </select>
    </div>
    <div class="col-sm-2">
  <button class="btn btn-default" type="submit" >使用订单 <span  class="glyphicon glyphicon-ok"></span></button>
  </div>
   </form>
    </div>
    </div>
    <br><br>
    
	
 <div class="container">
 <form action="${pageContext.request.contextPath}/abc/updateOrderlist">
 <!-- 隐藏前10的input div开始 -->
 					<div id="demo">
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label" >网点编号:</label>
    <div class="col-sm-10">
     <select name="realreceivertelenumber" class="form-control">
 <option value="0">----请选择网点----</option>
 <c:forEach items="${al}" var="a">
      <option value="${a.agencyId}">${a.agencyName}</option>
       </c:forEach>
    </select>
    </div>
  </div> 
  	&nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label" >订单编号:</label>
    <div class="col-sm-10">
      <input type="text"  name="orderNumber" class="form-control" placeholder="请输入订单编号" value="${orderlist.orderNumber}" required="required" readonly="readonly">
    </div>
  </div> 
  	&nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">订单条码:</label>
    <div class="col-sm-10">
      <input type="text"  name="barcode" class="form-control" placeholder="请输入订单条码" value="${orderlist.barcode}" required="required" >
    </div>
  </div> 
  	&nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">发货人姓名:</label>
    <div class="col-sm-10">
      <input type="text"  name="sendername" class="form-control" placeholder="请输入发货人姓名" value="${orderlist.sendername}" required="required">
    </div>
  </div> 
  &nbsp;

  					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">寄件省:</label>
    <div class="col-sm-2">
   
      <select name="sendPid" class="form-control">
 <c:forEach items="${pl}" var="p">
      <option value="${p.pid}">${p.pName}</option>
       </c:forEach>
    </select>
    </div>
    <label for="lastname" class="col-sm-2 control-label">&nbsp;&nbsp;&nbsp;&nbsp;寄件市:</label>
    <div class="col-sm-2">
   
      <select name="sendCid" class="form-control">
 <c:forEach items="${cl}" var="c">
      <option value="${c.cid}">${c.cName}</option>
       </c:forEach>
    </select>
    </div>
    <label for="lastname" class="col-sm-2 control-label">&nbsp;&nbsp;&nbsp;&nbsp;寄件区:</label>
    <div class="col-sm-2">
   
      <select name="sendArea" class="form-control">
 <c:forEach items="${asl}" var="a">
      <option value="${a.aid}">${a.aName}</option>
       </c:forEach>
    </select>
    </div>
  </div> 
  &nbsp;
  					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">发货地址:</label>
    <div class="col-sm-10">
      <input type="text"  name="senderaddress" class="form-control" placeholder="请输入发货地址" value="${orderlist.senderaddress}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">发货人电话:</label>
    <div class="col-sm-10">
      <input type="text"  name="sendertelenumber" class="form-control" placeholder="请输入发货人电话" value="${orderlist.sendertelenumber}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">收件人名:</label>
    <div class="col-sm-10">
      <input type="text" name="receivername" class="form-control" placeholder="请输入年检到期时间" value="${orderlist.receivername}" required="required">
    </div>
  </div> 
  &nbsp;
   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">收件人电话:</label>
    <div class="col-sm-10">
      <input type="text"  name="receivertelenumber" class="form-control" placeholder="请输入收件人电话" value="${orderlist.receivertelenumber}" required="required">
    </div>
  </div> 
  &nbsp;
  				 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">收件省:</label>
    <div class="col-sm-2">
   
     <!--  <input type="text"  name="sendPid" class="form-control" placeholder="请选择寄件省" value="${orderlist.sendPid}" required="required"> -->
      <select name="receiverPid" class="form-control">
 <c:forEach items="${pl}" var="p">
      <option value="${p.pid}">${p.pName}</option>
       </c:forEach>
    </select>
    </div>
    <label for="lastname" class="col-sm-2 control-label">&nbsp;&nbsp;&nbsp;&nbsp;收件市:</label>
    <div class="col-sm-2">
   
     <!--  <input type="text"  name="sendCid" class="form-control" placeholder="请选择寄件省" value="${orderlist.sendPid}" required="required"> -->
      <select name="receiverCid" class="form-control">
 <c:forEach items="${cl}" var="c">
      <option value="${c.cid}">${c.cName}</option>
       </c:forEach>
    </select>
    </div>
    <label for="lastname" class="col-sm-2 control-label">&nbsp;&nbsp;&nbsp;&nbsp;收件区:</label>
    <div class="col-sm-2">
   
      <select name="receiverArea" class="form-control">
 <c:forEach items="${asl}" var="a">
      <option value="${a.aid}">${a.aName}</option>
       </c:forEach>
    </select>
    </div>
  </div> 
  &nbsp;
  					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">收件地址:</label>
    <div class="col-sm-10">
      <input type="text"  name="receiveraddress" class="form-control" placeholder="请选择收件地址 " value="${orderlist.receiveraddress}" required="required">
    </div>
  </div> 
  &nbsp;
  </div>
		<p align="center"><button type="button" class="btn btn-default" data-toggle="collapse" 
		data-target="#demo">
	点击隐藏/展开
</button></p>
		
					
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">物品数量:</label>
    <div class="col-sm-10">
      <input type="text"  name="number" class="form-control" placeholder="请输入物品数量" value="${orderlist.number}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">重量:</label>
    <div class="col-sm-10">
      <input type="text"  name="weight" class="form-control" placeholder="请输入重量" value="${orderlist.weight}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">体积:</label>
    <div class="col-sm-10">
      <input type="text"  name="volume" class="form-control" placeholder="请输入体积" value="${orderlist.volume}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">name:</label>
    <div class="col-sm-10">
      <input type="text"  name="name" class="form-control" placeholder="请输入name" value="${orderlist.name}"  required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">类别:</label>
    <div class="col-sm-10">
       <select name="category" class="form-control">
      <option value="电脑数码">电脑数码</option>
      <option value="运动户外">运动户外</option>
      <option value="图书音像">图书音像</option>
      <option value="服饰鞋包">服饰鞋包</option>
    </select>
    </div>
  </div> 
  &nbsp;
  	
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">包装费:</label>
    <div class="col-sm-10">
      <input type="text"  name="packprice" class="form-control" placeholder="请输入包装费" value="${orderlist.packprice}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">包裹类别:</label>
    <div class="col-sm-10">
      <input type="text"  name="pkgtype" class="form-control" placeholder="请输入包裹类别" value="${orderlist.pkgtype}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">出发时间:</label>
    <div class="col-sm-10">
      <input type="date"  name="departtime" class="form-control" placeholder="请输入出发时间" value="${orderlist.departtime}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">到达时间:</label>
    <div class="col-sm-10">
      <input type="date"  name="arrivetime" class="form-control" placeholder="请输入到达时间" value="${orderlist.arrivetime}" required="required">
    </div>
  </div> 
  &nbsp;
				 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">是否到达:</label>
    <div class="col-sm-10">
    <div class="btn-group" data-toggle="buttons">
    <label class="btn btn-default default">
       <input type="radio" name="checkstate"  value="1" >是
       </label>
       <label class="btn btn-default active">
        <input type="radio" name="checkstate"  value="0" checked="checked">否
        </label>
    </div>
    </div>
  </div> 
	&nbsp;

					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">揽件用户:</label>
    <div class="col-sm-10">
      <select name="stuffId" class="form-control">
 <c:forEach items="${sl}" var="s">
      <option value="${s.staffId}">${s.name}</option>
       </c:forEach>
    </select>
    </div>
  </div> 
  &nbsp;
  			 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">是否加急:</label>
    <div class="col-sm-10">
    <div class="btn-group" data-toggle="buttons">
    <label class="btn btn-default default">
       <input type="radio" name="urgent"  value="1" >是
       </label>
       <label class="btn btn-default active">
        <input type="radio" name="urgent"  value="0" checked="checked">否
        </label>
    </div>
  </div> 
	&nbsp;
		 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">付费方式:</label>
    <div class="col-sm-10">
     <div class="btn-group" data-toggle="buttons">
    <label class="btn btn-default active">
       <input type="radio" name="orderPayType"  value="0" checked="checked">寄付
       </label>
        <label class="btn btn-default default">
        <input type="radio" name="orderPayType"  value="1" >到付
        </label>
    </div>
  </div> 
	&nbsp;
  <div align="center">
<button class="btn btn-default" type="submit" >生成订单 <span id="s1" class="glyphicon glyphicon-ok"></span></button>
 &nbsp;
<button class="btn btn-default" type="button" onclick="insert_reset();">重置 <span id="s2" class="glyphicon glyphicon-refresh"></span></button>
 &nbsp;
<button type="button" class="btn btn-default" data-dismiss="modal">关闭  <span id="s3" class="glyphicon glyphicon-remove"></span></button>
</div>
 </form> 
 </div>   
</body>
</html>