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
	function getRepertoryin() {
		$("#tableRepertoryin").children().children().click(
				function() { //单击行项获取当前行所需数据  
					$("#insertRepertoryinModal input[name='orderNumber']").val(
							$(this).children().eq(2).text());
					$("#insertRepertoryinModal").modal("show");
				});
	}

	function insertRepertoryin() {
		var repertoryin = {
			riId : $("#insertRepertoryinModal input[name='riId']").val(),
			orderNumber : $("#insertRepertoryinModal input[name='orderNumber']").val(),
			riTimee : $("#insertRepertoryinModal input[name='riTimee']").val(),
			destination : $("#insertRepertoryinModal input[name='destination']").val(),
			checkstate : $("#insertRepertoryinModal input[name='checkstate']").get(0).checked == true ? "0" : "1"
		}

		$.ajax({
					url : "/hb/insertRepertoryin",
					type : "post",
					data : repertoryin,
					dataType : "json",
					success : function(data) {
						if (data.msg == "ok") {
							alert("入库记录单生成成功!");
							//隐藏添加模态框
							$("#insertRepertoryinModal").modal("hide");
							$("#insertRepertoryinModal input[name='riTimee']").val("");
							$("#insertRepertoryinModal input[name='destination']").val("");
							$("#insertRepertoryModal").modal("show");
							$("#insertRepertoryModal input[name='orderNumber']").val($("#insertRepertoryinModal input[name='orderNumber']").val());
							$("#insertRepertoryModal input[name='riId']").val(data.primaryKey_riId);
							$("#insertRepertoryinModal input[name='orderNumber']").val("");
							$("#insertRepertoryinModal input[name='riId']").val("");

						} else {
							alert("入库记录单以存在!");
							$("#insertRepertoryinModal").modal("hide");
							$("#insertRepertoryinModal input[name='riTimee']").val("");
							$("#insertRepertoryinModal input[name='destination']").val("");											
							$("#insertRepertoryinModal input[name='orderNumber']").val("");
							$("#insertRepertoryinModal input[name='riId']").val("");
						}
					}
				});
	}

	function insertRepertory() {
		var repertory = {
			rid : $("#insertRepertoryModal input[name='rid']").val(),
			riId : $("#insertRepertoryModal input[name='riId']").val(),
			orderNumber : $("#insertRepertoryModal input[name='orderNumber']").val(),
			areanumber : $("#insertRepertoryModal select[name='areanumber']").val(),
			rownumber : $("#insertRepertoryModal select[name='rownumber']").val(),
			framenumber : $("#insertRepertoryModal select[name='framenumber']").val(),
			placenumber : $("#insertRepertoryModal select[name='placenumber']").val(),
			rTimee : $("#insertRepertoryModal input[name='rTimee']").val(),
			checkstate : $("#insertRepertoryModal input[name='checkstate']").get(0).checked == true ? "0" : "1"
		}

		$.ajax({
			url : "/hb/insertRepertory",
			type : "post",
			data : repertory,
			dataType : "json",
			success : function(data) {
				if (data.msg == "ok") {
					alert("仓库记录单生成成功！");
					$("#insertRepertoryModal input[name='rid']").val("");
					$("#insertRepertoryModal input[name='riId']").val("");
					$("#insertRepertoryModal input[name='orderNumber']").val("");
					$("#insertRepertoryModal select[name='areanumber']").val("");
					$("#insertRepertoryModal select[name='rownumber']").val(""),
					$("#insertRepertoryModal select[name='framenumber']").val("");
					$("#insertRepertoryModal select[name='placenumber']").val("");
					$("#insertRepertoryModal input[name='rTimee']").val("");
					//隐藏添加模态框
					$("#insertRepertoryModal").modal("hide");
				} else {
					alert("仓库记录单已存在！");
					$("#insertRepertoryModal").modal("hide");
					$("#insertRepertoryModal input[name='rid']").val("");
					$("#insertRepertoryModal input[name='riId']").val("");
					$("#insertRepertoryModal input[name='orderNumber']").val("");
					$("#insertRepertoryModal select[name='areanumber']").val("");
					$("#insertRepertoryModal select[name='rownumber']").val(""),
					$("#insertRepertoryModal select[name='framenumber']").val("");
					$("#insertRepertoryModal select[name='placenumber']").val("");
					$("#insertRepertoryModal input[name='rTimee']").val("");					
				}
			}
		});
	}
	
</script>
<body>
	<div class="container">

		<div class="row">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading" style="text-align: center;">入库管理清单</div>
				<div class="panel-body">
					<form class="form-inline" method="post"
						action="${pageContext.request.contextPath}/hb/selectPageRepertory">
						<div class="form-group">
							<label for="hid">请输入接收编号:</label> <input type="text"
								class="form-control" name="hid">
						</div>
						<button type="submit" class="btn btn-default">查询订单编号</button>
					</form>
				</div>

				<table class="table table-bordered" id="tableRepertoryin">
					<tr style="text-align: center;">
						<td>接收清单编号</td>
						<td>接收编号</td>
						<td>订单编号</td>
						<td>到达状态</td>
						<td>操作</td>
					</tr>

					<c:forEach var="h" items="${pageBean.ll}">
						<tr style="text-align: center;">
							<td>${h.hBId}</td>
							<td>${h.hid}</td>
							<td>${h.orderNumber}</td>
							<td>${h.hType eq "0" ? "良好":"损坏"}</td>
							<td><button type="button" class="btn-sm" onclick="getRepertoryin();">入库</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>


		<div class="row">
			<div class="col-lg-2">
				<font color="red">共有条${pageBean.allCount}记录</font>
			</div>
			<div class="col-lg-2">
				<font color="green">当前页面是${pageBean.nowPage}页/总共有${pageBean.allPage}页</font>
			</div>
			<div class="col-lg-2">
				<a
					href="${pageContext.request.contextPath}/hb/selectPageRepertory?nowPage=1">首页</a>
			</div>
			<div class="col-lg-2">
				<c:if test="${pageBean.nowPage == 1}">上一页</c:if>
				<c:if test="${pageBean.nowPage != 1 }">
					<a
						href="${pageContext.request.contextPath}/hb/selectPageRepertory?nowPage=${pageBean.nowPage-1}">
						上一页 </a>
				</c:if>
			</div>
			<div class="col-lg-2">
				<c:if test="${pageBean.nowPage == pageBean.allPage}">下一页</c:if>
				<c:if test="${pageBean.nowPage != pageBean.allPage}">
					<a
						href="${pageContext.request.contextPath}/hb/selectPageRepertory?nowPage=${pageBean.nowPage+1}">
						下一页 </a>
				</c:if>
			</div>
			<div class="col-lg-2">
				<a
					href="${pageContext.request.contextPath}/hb/selectPageRepertory?nowPage=${pageBean.allPage}">尾页</a>
			</div>
		</div>
	</div>

	<!-- 入库模态框开始 -->
	<div class="modal fade" id="insertRepertoryinModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<font color="orange" size="3">入库记录单</font>
				</div>
				<div class="modal-body">
					<form method="post" class="form-horizontal" role="form"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="riId" class="col-sm-3 control-label">入库单编号:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="riId"
									placeholder="请填写" required="required" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="orderNumber" class="col-sm-3 control-label">订单编号:</label>
							<div class="col-sm-9">

								<input type="text" class="form-control" name="orderNumber"
									required="required" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="riTimee" class="col-sm-3 control-label">入库时间:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="riTimee"
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
							<label for="checkstate" class="col-sm-3 control-label">入库状态:</label>
							<div class="col-sm-9">

								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-default active btn-sm"> <input
										type="radio" name="checkstate" id="insert_checkstate1"
										autocomplete="off" value="0" checked> 完好
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
									onclick="insertRepertoryin();">添加</button>
							</div>

							<div class="col-lg-4 col-sm-4">
								<a href="#" class="btn btn-danger btn-sm active" role="button">放弃添加</a>
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
	<!-- 入库模态框结束-->


	<!-- 仓库模态框开始 -->
	<div class="modal fade" id="insertRepertoryModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<font color="orange" size="3">仓库记录单</font>
				</div>
				<div class="modal-body">
					<form method="post" class="form-horizontal" role="form"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="rid" class="col-sm-3 control-label">仓库单编号:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="rid"
									placeholder="请填写" required="required" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="riId" class="col-sm-3 control-label">入库单编号:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="riId"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="orderNumber" class="col-sm-3 control-label">订单编号:</label>
							<div class="col-sm-9">

								<input type="text" class="form-control" name="orderNumber"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="rTimee" class="col-sm-3 control-label">入库时间:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="rTimee"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<label for="areanumber" class="col-sm-1 control-label">区:</label>
							<div class="col-sm-2">
								<select name="areanumber" class="form-control">
									<option value="0">A</option>
									<option value="1">B</option>
									<option value="2">C</option>
									<option value="3">D</option>
								</select>
							</div>

							<label for="rownumber" class="col-sm-1 control-label">行:</label>
							<div class="col-sm-2">
								<select name="rownumber" class="form-control">
									<option value="0">1</option>
									<option value="1">2</option>
									<option value="2">3</option>
									<option value="3">4</option>
									<option value="4">5</option>
									<option value="5">6</option>
									<option value="6">7</option>
									<option value="7">8</option>
									<option value="8">9</option>
									<option value="9">10</option>
								</select>
							</div>

							<label for="framenumber" class="col-sm-1 control-label">排:</label>
							<div class="col-sm-2">
								<select name="framenumber" class="form-control">
									<option value="0">C</option>
								</select>
							</div>

							<label for="placenumber" class="col-sm-1 control-label">位:</label>
							<div class="col-sm-2">
								<select name="placenumber" class="form-control">
									<option value="0">D</option>
								</select>
							</div>
						</div>


						<div class="form-group">
							<label for="checkstate" class="col-sm-3 control-label">入库状态:</label>
							<div class="col-sm-9">

								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-default active btn-sm"> <input
										type="radio" name="checkstate" id="insert_checkstate1"
										autocomplete="off" value="0" checked> 在库
									</label> <label class="btn btn-default btn-sm"> <input
										type="radio" name="checkstate" id="insert_checkstate2"
										value="1" autocomplete="off"> 已出库
									</label>
								</div>
							</div>
						</div>

						<div style="text-align: center;" class="form-group">
							<div class="col-lg-4 col-sm-4">
								<button type="button" class="btn btn-info btn-sm"
									onclick="insertRepertory();">入库</button>
							</div>

							<div class="col-lg-4 col-sm-4">
								<a href="#" class="btn btn-danger btn-sm active" role="button">放弃入库</a>
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