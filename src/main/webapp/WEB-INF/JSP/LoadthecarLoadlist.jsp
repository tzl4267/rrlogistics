<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-3.0.0.js"></script>
<link href="${pageContext.request.contextPath}/js/assets/css/bootstrap.css" rel="stylesheet" />  
<link href="${pageContext.request.contextPath}/js/assets/css/font-awesome.css" rel="stylesheet" />
<%-- <link href="${pageContext.request.contextPath}/js/assets/css/custom-styles.css" rel="stylesheet" /> --%>
 <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link href="${pageContext.request.contextPath}/js/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />      <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/custom-scripts.js"></script>
    <script src="${pageContext.request.contextPath}/js/layui-v2.3.0/layui/layui.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui-v2.3.0/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/js/jquery.searchableSelect.js"></script>
    <link href="${pageContext.request.contextPath}/js/jquery.searchableSelect.css"  />  
<title>Insert title here</title>
<!-- 插件 -->
  <script type="text/javascript">
		$(function(){
			$('aaaa').searchableSelect();
		});
    </script>
</head>
<body>
<div align="center" style="width: 1900px;">
    <div style="width: 800px;"align="left" >
    <!-- 根据运输编号添加信息 -->
    <form action="${pageContext.request.contextPath}/L/update">
       	<div class="layui-row">
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>		
    </div>
    <div  class="layui-col-xs6 layui-col-sm12 layui-col-md6">
      <div style="font-size: 19px"><label>运输编号:</label>
      <div class="layui-input-inline">
           <select name="transNumber" >
  			<option value="0">---请选择---</option>
      		<c:forEach items="${Loadlist}" var="l">
      <option value="${l.transNumber}">${l.transNumber}</option>
       </c:forEach>
           </select>
      <a href="${pageContext.request.contextPath}/L/update1"><button class="layui-btn layui-btn-sm layui-btn-normal" style="font-size: 19px" >生成运输编号</button></a>
      </div>
    </div>
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div>&nbsp;</div>
    </div>
    </div><br /><br /><br /><br />
  
	<div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div style="font-size: 17px"> <label >本营业厅编号:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
       <div class="layui-input-inline">
      <select name="hallnumber">
        <option value="">---请选择---</option>
        <c:forEach items="${Agency}" var="a">
  		<option  value="${a.agencyId }" >${a.agencyId }</option>
		</c:forEach>
      </select>
    </div>		
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>
    <!-- 内层删格结束 -->			
    </div>
    </div>

    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div>&nbsp;</div>
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div style="font-size: 17px"> <label>网点编号:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
      <select name="destination">
        <option value="">---请选择---</option>
        <c:forEach items="${Orderlist}" var="o">
  		<option  value="${o.realreceivertelenumber }" >${o.realreceivertelenumber }</option>
		</c:forEach>
      </select>
    </div>				
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div></div>
    </div>
    </div><!-- 外层删格结束 -->
    <br /><br /><br /><br /><br />
    <!-- 外层删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div style="font-size: 17px"> <label >车辆代号:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
       <div class="layui-input-inline">
      <select name="carnumber">
        <option value="0">---请选择---</option>
        <c:forEach items="${Truck}" var="t">
  <option  value="${t.vehiclecode }" >${t.vehiclecode }</option>
</c:forEach>
      </select>
    </div>		
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>
    <!-- 内层删格结束 -->			
    </div>
    </div>

    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div>&nbsp;</div>
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div style="font-size: 17px"> <label >监管员:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
      <select name="guardman">
        <option value="">---请选择---</option>
        <c:forEach items="${Staff}" var="s">
  		<option  value="${s.name }" >${s.name }</option>
		</c:forEach>
      </select>
    </div>				
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div></div>
    </div>
    </div><!-- 外层删格结束 -->
    
    <br /><br /><br /><br /><br />
    <!-- 外层删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div style="font-size: 17px"> <label >押运员:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
       <div class="layui-input-inline">
      <select name="supercargoman">
        <option value="">---请选择---</option>
        <c:forEach items="${Driver}" var="d">
  		<option  value="${d.driverName }" >${d.driverName }</option>
		</c:forEach>
      </select>
    </div>		
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>
    <!-- 内层删格结束 -->			
    </div>
    </div>

    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div style="font-size: 17px"> <label >装车日期:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="date" name="timee" class="layui-input">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>
    <!-- 内层删格结束 -->			
    </div>
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div style="font-size: 17px"> <label >司机编号:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
      <select name="drivernum">
        <option value="">---请选择---</option>
       <c:forEach items="${Driver}" var="d">
  <option  value="${d.driverName }" >${d.driverName }</option>
</c:forEach>
      </select>
    </div>				
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div></div>
    </div>
    </div><!-- 外层删格结束 --><br><br><br>
    		<!-- 外层删格 -->
           <div class="layui-row">
       <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div class="layui-input-inline">
        &nbsp;
		</div>		
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div class="layui-input-inline">
		<button type="submit" class="layui-btn">确认</button>

		</div>		
    </div>
    <div  class="layui-col-xs3 layui-col-sm12 layui-col-md3">
      <div class="layui-input-inline">
        &nbsp;
		</div>		
    </div>
    <div  class="layui-col-xs3 layui-col-sm12 layui-col-md3">
      <div class="layui-input-inline">

        <button type="button" class="layui-btn">取消</button>

		</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div class="layui-input-inline">
        &nbsp;
		</div>		
    </div>
   </div>
   </form>
    </div>
</div>

</body>
</html>