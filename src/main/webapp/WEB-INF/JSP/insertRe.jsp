<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 入库页面 -->
<link
	href="${pageContext.request.contextPath}/js/assets/css/bootstrap.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/js/assets/js/jquery-1.10.2.js"></script>
<script
	src="${pageContext.request.contextPath}/js/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/assets/js/dataTables/dataTables.bootstrap.js"></script>
</head>
<script type="text/javascript">
	function getA() {
		$("tr").click(
				function() { //单击行项获取当前行所需数据  
					$("input[name='orderNumber']").val(
							$(this).children().eq(0).text());
				})

	}
</script>
<body>
	<center>
		<form action="" method="post">
			抵达编号:<input type="text" name="hid"><br> <input
				type="submit" value="Go">
		</form>
		<table border="1">
			<tr>
				<td>订单编号</td>
				<td>操作</td>
			</tr>

			<c:forEach var="h" items="${hbList}">
				<tr>
					<td>${h.orderNumber}</td>
					<td><button onclick="getA();">添加</button></td>
				</tr>
			</c:forEach>

		</table>
		<br />


		<form action="${pageContext.request.contextPath}/hb/insertHb"
			method="post">
			入库编号:<input type="text" name="riId"><br /> 订单编号:<input
				type="text" name="orderNumber"><br /> 入库时间:<input
				type="text" name="riTimee"><br /> 目的地:<input type="text"
				name="destination"><br /> 入库状态:<input type="text"
				name="checkstate"><br /> 区:<select name="areanumber">
				<option>1</option>
			</select > 排:<select name="rownumber">
				<option>2</option>
			</select > 架:<select name="framenumber">
				<option >3</option>
			</select > 位:<select name="placenumber">
				<option >4</option>
			</select> <input type="submit" value="添加">
		</form>
	</center>
</body>
</html>