<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 转运表添加页面 -->
<style type="text/css">
body {
	padding-top: 60px;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.js">
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
	function insertTransshipmentlist() {
		var transshipmentlist = {
			tranId : $("#insertTransshipmentlistForm input[name='tranId']").val(),
			tranTime : $("#insertTransshipmentlistForm input[name='tranTime']").val(),
			vehiclecode : $("#insertTransshipmentlistForm select[name='vehiclecode']").val(),
			checkstate : $("#insertTransshipmentlistForm input[name='checkstate']").get(0).checked == true ? "0" : "1",
			departureplace : $("#insertTransshipmentlistForm input[name='departureplace']").val(),
			destination : $("#insertTransshipmentlistForm input[name='destination']").val(),
			containernumber : $("#insertTransshipmentlistForm input[name='containernumber']").val(),
			supercargo : $("#insertTransshipmentlistForm input[name='supercargo']").val(),
		}

		$.ajax({
			url : "/tb/insertTransshipmentlist",
			type : "post",
			data : transshipmentlist,
			dataType : "json",
			success : function(data) {
				if (data.msg == "ok") {
					alert("装运单生成成功！");
					$("#insertTransshipmentlist_barcodeModal").modal("show");
					$("#insertTransshipmentlist_barcodeModal input[name='tranId']").val(data.primaryKey_tranId);
					$("#insertTransshipmentlistForm input[name='tranId']").val("");
					$("#insertTransshipmentlistForm input[name='tranTime']").val("");
					$("#insertTransshipmentlistForm select[name='vehiclecode']").val("");			
					$("#insertTransshipmentlistForm input[name='departureplace']").val("");
					$("#insertTransshipmentlistForm input[name='destination']").val("");
					$("#insertTransshipmentlistForm input[name='containernumber']").val("");
					$("#insertTransshipmentlistForm input[name='supercargo']").val("");
				} else {
					alert("装运单已存在,不能重复生成!");
				}
			}
		});
	}

	function insertTransshipmentlist_barcode() {
		var transshipmentlist_barcode = {
			primarykey : $("#insertTransshipmentlist_barcodeModal input[name='primarykey']").val(),
			tranId : $("#insertTransshipmentlist_barcodeModal input[name='tranId']").val(),
			orderNumber : $("#insertTransshipmentlist_barcodeModal input[name='orderNumber']").val(),
			state : $("#insertTransshipmentlist_barcodeModal input[name='state']").get(0).checked == true ? "0" : "1",
		}

		$.ajax({
			url : "/tb/insertTransshipmentlist_barcode",
			type : "post",
			data : transshipmentlist_barcode,
			dataType : "json",
			success : function(data) {
				if (data.msg == "ok") {
					alert("装运清单生成成功！");
					$("#insertTransshipmentlist_barcodeModal").modal("hide");
					$("#insertTransshipmentlist_barcodeModal input[name='primarykey']").val("");
					$("#insertTransshipmentlist_barcodeModal input[name='tranId']").val("");
					$("#insertTransshipmentlist_barcodeModal input[name='orderNumber']").val("");					
				} else {
					alert("装运清单已存在！");
					$("#insertTransshipmentlist_barcodeModal").modal("hide");
					$("#insertTransshipmentlist_barcodeModal input[name='primarykey']").val("");
					$("#insertTransshipmentlist_barcodeModal input[name='tranId']").val("");
					$("#insertTransshipmentlist_barcodeModal input[name='orderNumber']").val("");
				}
			}
		});
	}
</script>


<body>
	<div class="container">

		<form method="post" id="insertTransshipmentlistForm">
			<div class="panel panel-default">
				<div class="panel-heading" style="text-align: center;">装运管理</div>
				<table class="table table-striped">
					<tr style="text-align: center;" class="active">
						<td style="text-align: left;" colspan="2">转运编号:<input
							type="text" name="tranId" readonly="readonly" ></td>
						<td style="text-align: left;" colspan="2">装运时间: <input
							type="text" name="tranTime" readonly="readonly">
						</td>
					</tr>

					<tr style="text-align: center;" class="active">
						<td style="text-align: left;" colspan="2">车辆编号: <select
							name="vehiclecode">
								<option>---请选择---</option>
								<c:forEach var="t" items="${truckList}">
									<option value="${t.vehiclecode}">${t.vehiclecode}</option>
								</c:forEach>
						</select></td>
						<td style="text-align: left;" colspan="2">
							<div class="form-group">
								<label for="checkstate" class="col-sm-3 control-label">到达状态:</label>
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
						</td>
					</tr>

					<tr style="text-align: center;" class="active">
						<td style="text-align: left;" colspan="2">出发地: <input
							type="text" name="departureplace" required></td>
						<td style="text-align: left;" colspan="2" required >目的地: <input
							type="text" name="destination"></td>
					</tr>

					<tr style="text-align: center;" class="active">
						<td style="text-align: left;" colspan="2">货柜号: <input
							type="text" name="containernumber"></td>
						<td style="text-align: left;" colspan="2">监管员: <input
							type="text" name="supercargo"></td>
					</tr>


					<tr style="text-align: center;" class="active">
						<td style="text-align: left;" colspan="1">
							<button type="button" class="btn  btn-sm"
								onclick="insertTransshipmentlist();">添加</button>
						</td>
						<td colspan="1"><a href="#"
							class="btn btn-default btn-sm active" role="button">放弃装运</a>
						<td>
						<td colspan="2"><button type="reset" class="btn btn-sm">重新填写</button>
						</td>
					</tr>
				</table>
			</div>
		</form>

		<!-- 入库模态框开始 -->
		<div class="modal fade" id="insertTransshipmentlist_barcodeModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true" data-backdrop="false">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<font color="orange" size="3">装运清单</font>
					</div>
					<div class="modal-body">
						<form method="post" class="form-horizontal" role="form"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="primarykey" class="col-sm-3 control-label">清单编号:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="primarykey"
										placeholder="请填写" required="required" readonly="readonly">
								</div>
							</div>

							<div class="form-group">
								<label for="orderNumber" class="col-sm-3 control-label">订单编号:</label>
								<div class="col-sm-9">

									<input type="text" class="form-control" name="orderNumber"
										required="required" placeholder="请填写">
								</div>
							</div>

							<div class="form-group">
								<label for="tranId" class="col-sm-3 control-label">装运单号:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="tranId"
										readonly="readonly" required="required">
								</div>
							</div>

							<div class="form-group">
								<label for="state" class="col-sm-3 control-label">商品状态:</label>
								<div class="col-sm-9">

									<div class="btn-group" data-toggle="buttons">
										<label class="btn btn-default active btn-sm"> <input
											type="radio" name="state" id="insert_state1"
											autocomplete="off" value="0" checked> 完好
										</label> <label class="btn btn-default btn-sm"> <input
											type="radio" name="state" id="insert_state2" value="1"
											autocomplete="off"> 损坏
										</label>
									</div>
								</div>
							</div>

							<div style="text-align: center;" class="form-group">
								<div class="col-lg-4 col-sm-4">
									<button type="button" class="btn btn-info btn-sm"
										onclick="insertTransshipmentlist_barcode();">添加</button>
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

	</div>
</body>
</html>