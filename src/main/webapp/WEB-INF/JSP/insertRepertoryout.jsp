<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	padding-top: 60px;
}
</style>
<!-- 入库页面 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.js">
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

	function getRepertoryout() {
		$("#tableRepertoryout").children().children().click(
				function() { //单击行项获取当前行所需数据 			
					$("#insertRepertoryoutModal input[name='orderNumber']")
							.val($(this).children().eq(1).text());
					$("#insertRepertoryoutModal").modal("show");
				});
	}

	function insertRepertoryout() {
		var repertoryout = {
			roId : $("#insertRepertoryoutModal input[name='roId']").val(),
			orderNumber : $("#insertRepertoryoutModal input[name='orderNumber']").val(),
			roTime : $("#insertRepertoryoutModal input[name='roTime']").val(),
			destination : $("#insertRepertoryoutModal input[name='destination']").val(),
			transportation : $("#insertRepertoryoutModal input[name='transportation']").val(),
			checkstate : $("#insertRepertoryoutModal input[name='checkstate']").get(0).checked == true ? "0" : "1"
		}

		$.ajax({
			url : "/hb/insertRepertoryout",
			type : "post",
			data : repertoryout,
			dataType : "json",
			success : function(data) {
				if (data.msg == "ok") {
					alert("出库记录单生成成功！");
					$("#insertRepertoryoutModal input[name='roId']").val("");
					$("#insertRepertoryoutModal input[name='orderNumber']").val("");
					$("#insertRepertoryoutModal input[name='roTime']").val("");
					$("#insertRepertoryoutModal input[name='destination']").val("");
					$("#insertRepertoryoutModal input[name='transportation']").val("");
					//隐藏添加模态框
					$("#insertRepertoryoutModal").modal("hide");
				} else {
					alert("出库记录单已存在！");
					$("#insertRepertoryoutModal input[name='roId']").val("");
					$("#insertRepertoryoutModal input[name='orderNumber']").val("");
					$("#insertRepertoryoutModal input[name='roTime']").val("");
					$("#insertRepertoryoutModal input[name='destination']").val("");
					$("#insertRepertoryoutModal input[name='transportation']").val("");
					//隐藏添加模态框
					$("#insertRepertoryoutModal").modal("hide");
				}
			}
		});
	}
</script>
<body>
	<div class="container">

		<div class="row">
			<table class="table table-bordered" id="tableRepertoryout">
				<tr style="text-align: center;">
					<td colspan="10">出库清单管理</td>
				</tr>

				<tr style="text-align: center;">
					<td>仓库编号</td>
					<td>订单编号</td>
					<td>入库时间</td>
					<td>区</td>
					<td>行</td>
					<td>排</td>
					<td>位</td>
					<td>订单状态</td>
					<td>入库单号</td>
					<td>操作</td>
				</tr>

				<c:forEach var="r" items="${pageBean.ll}">
					<tr style="text-align: center;">
						<td>${r.rid}</td>
						<td>${r.orderNumber}</td>
						<td><fmt:formatDate value="${r.rTimee}" pattern="yyyy-MM-dd" /></td>
						<td>${r.areanumber}</td>
						<td>${r.rownumber}</td>
						<td>${r.framenumber}</td>
						<td>${r.placenumber}</td>
						<td>${r.checkstate eq "0" ? "在库":"已出库"}</td>
						<td>${r.riId}</td>
						<td><button type="button" class="btn-sm"
								onclick="getRepertoryout();">出库</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div class="row">
			<div class="col-lg-2">
				<font color="red">共有条${pageBean.allCount}记录</font>
			</div>
			<div class="col-lg-2">
				<font color="green">当前页面是${pageBean.nowPage}页/总共有${pageBean.allPage}页</font>
			</div>
			<div class="col-lg-2">
				<a href="${pageContext.request.contextPath}/hb/selectPageRepertoryout?nowPage=1">首页</a>
			</div>
			<div class="col-lg-2">
				<c:if test="${pageBean.nowPage == 1}">上一页</c:if>
				<c:if test="${pageBean.nowPage != 1 }">
					<a
						href="${pageContext.request.contextPath}/hb/selectPageRepertoryout?nowPage=${pageBean.nowPage-1}">
						上一页 </a>
				</c:if>
			</div>
			<div class="col-lg-2">
				<c:if test="${pageBean.nowPage == pageBean.allPage}">下一页</c:if>
				<c:if test="${pageBean.nowPage != pageBean.allPage}">
					<a
						href="${pageContext.request.contextPath}/hb/selectPageRepertoryout?nowPage=${pageBean.nowPage+1}">
						下一页 </a>
				</c:if>
			</div>
			<div class="col-lg-2">
				<a
					href="${pageContext.request.contextPath}/hb/selectPageRepertoryout?nowPage=${pageBean.allPage}">尾页</a>
			</div>
		</div>
	</div>
	
	<!-- 出库模态框开始 -->
	<div class="modal fade" id="insertRepertoryoutModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<font color="orange" size="3">出库记录单</font>
				</div>
				<div class="modal-body">
					<form method="post" class="form-horizontal" role="form"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="roId" class="col-sm-3 control-label">出库单编号:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="roId"
									placeholder="请填写" required="required" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="orderNumber" class="col-sm-3 control-label">订单编号:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="orderNumber" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="roTime" class="col-sm-3 control-label">出库时间:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="roTime"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="destination" class="col-sm-3 control-label">目的地:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="destination">
							</div>
						</div>

						<div class="form-group">
							<label for="transportation" class="col-sm-3 control-label">装运方式:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="transportation">
							</div>
						</div>



						<div class="form-group">
							<label for="checkstate" class="col-sm-3 control-label">出库状态:</label>
							<div class="col-sm-9">

								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-default active btn-sm"> <input
										type="radio" name="checkstate" id="insert_checkstate1"
										autocomplete="off" value="0" checked> 良好
									</label> <label class="btn btn-default btn-sm"> <input
										type="radio" name="checkstate" id="insert_checkstate2"
										value="1" autocomplete="off"> 损坏
									</label>
								</div>
							</div>
						</div>

						<div style="text-align: center;" class="form-group">
							<div class="col-lg-4 col-sm-4">
								<button type="button" class="btn btn-info btn-sm"
									onclick="insertRepertoryout();">出库</button>
							</div>

							<div class="col-lg-4 col-sm-4">
								<a href="#" class="btn btn-danger btn-sm active" role="button">放弃出库</a>
							</div>

							<div class="col-lg-4 col-sm-4">
								<button type="reset" class="btn btn-warning btn-sm">重新填写</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 仓库模态框结束-->
</body>
</html>