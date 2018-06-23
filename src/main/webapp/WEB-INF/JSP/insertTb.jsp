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
	function clearVal() {
		$(" input ").val(null);
		$(" select ").val("---请选择---");
	}
</script>

<body>
	<div class="container">
		<div class="row">
			<!--row11开始  -->
			<div class="col-lg-12 col-sm-12">
				<!--row11栅格开始  -->
				<div class="panel panel-default">
					<!--row11面板开始  -->

					<div class="panel-heading" style="text-align: center;">
						<h5>装运管理</h5>
					</div>
					<form action="${pageContext.request.contextPath}/tb/insertTb"
						method="post">
						<!-- row11table开始 -->
						<table class="table">
							<tr style="text-align: center;" class="active">
								<td style="text-align: left;" colspan="2">转运编号:<input
									type="text" name="tranId"></td>
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
									type="text" name="departureplace"></td>
								<td style="text-align: left;" colspan="2">目的地: <input
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
									<button type="submit" class="btn  btn-sm">添加</button>
								</td>
								<td colspan="1"><a href="#" class="btn btn-sm"
									role="button">放弃添加</a>
								<td>
								<td colspan="2"><button type="reset" class="btn btn-sm">重新填写</button>
								</td>
							</tr>

						</table>
					</form>
					<!--row11 table开始 -->
				</div>
				<!--row11面板结束  -->
			</div>
			<!--row11栅格结束  -->
		</div>
		<!--row11结束  -->
	</div>
</body>
</html>