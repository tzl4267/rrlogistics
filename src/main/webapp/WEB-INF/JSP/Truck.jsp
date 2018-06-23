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
    <script src="${pageContext.request.contextPath}/js/assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/js/assets/js/custom-scripts.js"></script>
    <style type="text/css">
    #s1{
    color: green
    }
    </style>
</head>
<body>
	<script type="text/javascript">
	function updatebtn(vehiclecode){
		//异步请求根据选择的员工编号，向服务端查询员工信息并显示在表单中
		$.ajax({  
			url: "${pageContext.request.contextPath}/abc/updateSelectTruck?vehiclecode="+vehiclecode,
			dataType: "json",
			success: function(data) {
				
				//alert(data.ename);
				$("#update_vehiclecode").val(data.vehiclecode);
				$("#update_platenumber").val(data.platenumber);
				$("#update_servicetimelimit").val(data.servicetimelimit);
				$("#update_tStus").val(data.tStus);
				$("#update_operation").val(data.operation);
				$("#update_driving").val(data.driving);
				$("#update_kilometre").val(data.kilometre);
				$("#update_motTime").val(data.motTime);
				$("#update_oilConsumption").val(data.oilConsumption);
				$("#update_agencyId").val(data.agencyId);
				//显示修改模态框
				$("#updateModal").modal("show") // hide是隐藏
			}
		});
	}
	
	function insertBtn() {
		 $("#insertModal").modal("show");
		}
	function updateBtn() {
		 $("#updateModal").modal("show");
		}
	function insert_reset(){
		$("#insert_vehiclecode").val("");
		$("#insert_platenumber").val("");
		$("#insert_servicetimelimit").val("");
		$("#insert_tStus").val("");
		$("#insert_operation").val("");
		$("#insert_driving").val("");
		$("#insert_kilometre").val("");	
		$("#insert_motTime").val("");
		$("#insert_oilConsumption").val("");	
		$("#insert_agencyId").val("0");	
		$("#insertModal")[0].reset();
	}
	function update_reset(){
		$("#updateForm")[0].reset();
		}
	</script>

				<form action="${pageContext.request.contextPath}/abc/queryTruck">
								<div style="width: 200px">
								<div class="form-group input-group" align="center">
                                            <input type="text" class="form-control"  name="platenumber" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default" style="height: 34px" type="submit">search <i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                        </div>
                                        </div>
                                          </form>
                                             <div class="pull-left">
  <button type="button" class="btn btn-default" onclick="insertBtn();">  <span class="glyphicon glyphicon-plus"></span> 添加车辆</button>
 </div>
 &nbsp;
                             <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
										 <th>车辆代号</th>
										 <th>车牌号</th>
										 <th>使用时间</th>
										 <th>车辆状态</th>
										 <th>证件</th>
										 <th>行驶证</th>
										 <th>公里数</th>
										 <th>年检到期时间</th>
										 <th>油耗</th>
										 <th>网店编号</th>
										 <th>操作</th>
										 </tr>
                                    </thead>
                                    <tbody>
                                       <c:forEach items="${tl}" var="t">
										 <tr>
										 <td>${t.vehiclecode}</td>
										 <td>${t.platenumber}</td>
										 <td>${t.servicetimelimit}</td>
										 <td>${t.tStus}</td>
										 <td>${t.operation}</td>
										 <td>${t.driving}</td>
										 <td>${t.kilometre}</td>
										 <td>${t.motTime}</td>
										 <td>${t.oilConsumption}</td>
										 <td>${t.agencyId}</td>
										 <td><a href="${pageContext.request.contextPath}/abc/deleteTruck?vehiclecode=${t.vehiclecode}"><button type="button"  class="btn btn-default">删除  <span id="s4" class="glyphicon glyphicon-trash"></span> </button></a></td>
										 <td><button type="button"  class="btn btn-default" onclick='updatebtn("${t.vehiclecode}");'>修改  <span id="s5" class="glyphicon glyphicon-pencil"></span></button></td>
										 </tr>
										 </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
 
 <!-- insert模态框开始 -->
	<div class="modal fade" id="insertModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">填写车辆信息</h4>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/abc/insertTruck" method="post">
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">车牌代号:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_vehiclecode" name="vehiclecode" class="form-control" placeholder="请输入车牌代号" required="required">
    </div>
  </div> 
  	&nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">车牌号:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_platenumber" name="platenumber" class="form-control" placeholder="请输入车牌号" required="required">
    </div>
  </div> 
  	&nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">使用时间:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_servicetimelimit" name="servicetimelimit" class="form-control" placeholder="请输入使用时间" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">车辆状态:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_tStus" name="tStus" class="form-control" placeholder="请输入车辆状态" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">证件:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_operation" name="operation" class="form-control" placeholder="请输入证件" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">行驶证:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_driving" name="driving" class="form-control" placeholder="请输入行驶证" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">公里数:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_kilometre" name="kilometre" class="form-control" placeholder="请输入公里数" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">油耗:</label>
    <div class="col-sm-10">
      <input type="text" id="insert_oilConsumption" name="oilConsumption" class="form-control" placeholder="请输入油耗" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">年检时间:</label>
    <div class="col-sm-10">
      <input type="date" id="insert_motTime" name="motTime" class="form-control" placeholder="请输入年检到期时间" required="required">
    </div>
  </div> 
  &nbsp;
   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">网点编号:</label>
    <div class="col-sm-10">
     <select name="agencyId" class="form-control" id="insert_agencyId">
 <option value="0">----请选择网点----</option>
 <c:forEach items="${al}" var="a">
      <option value="${a.agencyId}">${a.agencyName}</option>
       </c:forEach>
    </select>
    </div>
  </div> 
  &nbsp;
  <div align="center">
<button class="btn btn-default" type="submit" >添加车辆<span id="s1" class="glyphicon glyphicon-ok"></span></button>
 &nbsp;
<button class="btn btn-default" type="button" onclick="insert_reset();">重置 <span id="s2" class="glyphicon glyphicon-refresh"></span></button>
 &nbsp;
<button type="button" class="btn btn-default" data-dismiss="modal">关闭  <span id="s3" class="glyphicon glyphicon-remove"></span></button>
</div>
 </form>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
		</div>
		<!-- insert模态框结束 -->
		
		
		
 
 <!-- update模态框开始 -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改车辆信息</h4>
				</div>
				<div class="modal-body">
					<form id="updateForm" action="${pageContext.request.contextPath}/abc/updateTruck" method="post">
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">车牌代号:</label>
    <div class="col-sm-10">
      <input type="text" id="update_vehiclecode"  name="vehiclecode" class="form-control" value="${truck.vehiclecode}" required="required" readonly="readonly">
    </div>
  </div> 
  	&nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">车牌号:</label>
    <div class="col-sm-10">
      <input type="text" id="update_platenumber"  name="platenumber" class="form-control" value="${truck.platenumber}"  required="required" >
    </div>
  </div> 
  	&nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">使用时间:</label>
    <div class="col-sm-10">
      <input type="text" id="update_servicetimelimit"  name="servicetimelimit" class="form-control" value="${truck.servicetimelimit}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">车辆状态:</label>
    <div class="col-sm-10">
      <input type="text" id="update_tStus"  name="tStus" class="form-control" value="${truck.tStus}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">证件:</label>
    <div class="col-sm-10">
      <input type="text" id="update_operation"  name="operation" class="form-control" value="${truck.operation}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">行驶证:</label>
    <div class="col-sm-10">
      <input type="text" id="update_driving"  name="driving" class="form-control" value="${truck.driving}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">公里数:</label>
    <div class="col-sm-10">
      <input type="text" id="update_kilometre"  name="kilometre" class="form-control" value="${truck.kilometre}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">油耗:</label>
    <div class="col-sm-10">
      <input type="text" id="update_oilConsumption"  name="oilConsumption" class="form-control" value="${truck.oilConsumption}" required="required">
    </div>
  </div> 
  &nbsp;
					 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">年检时间:</label>
    <div class="col-sm-10">
      <input type="date" id="update_motTime"  name="motTime" class="form-control" value="${truck.motTime}" required="required">
    </div>
  </div> 
  &nbsp;
   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">网点编号:</label>
    <div class="col-sm-10">
     <select name="agencyId" class="form-control" id="update_agencyId">
 <option value="0">----请选择网点----</option>
 <c:forEach items="${al}" var="a">
      <option value="${a.agencyId}" ${truck.agencyId eq a.agencyId ? "selected" : ""}>${a.agencyName}</option>
       </c:forEach>
    </select>
    </div>
  </div> 
  &nbsp;
  <div align="center">
<button class="btn btn-default" type="submit" >修改车辆信息 <span id="s1" class="glyphicon glyphicon-ok"></span></button>
 &nbsp;
<button class="btn btn-default" type="button" onclick="update_reset();">重置 <span id="s2" class="glyphicon glyphicon-refresh"></span></button>
 &nbsp;
<button type="button" class="btn btn-default" data-dismiss="modal">关闭  <span id="s3" class="glyphicon glyphicon-remove"></span></button>
</div>
 </form>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
		</div>
		<!-- update模态框结束 -->
 
 
</body>
</html>