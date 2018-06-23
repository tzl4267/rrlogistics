<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<style type="text/css">
 #container{
 font-size: 17px;
padding:11px;
  
}
</style>


<body>

<center><h1>物流信息管理系统</h1></center>
<div class="container" id="container">
中转中心业务员:
<hr>
<center><h2>中转接收</h2></center>
<br>


<div class="row">
<div class="col-lg-4 col-md-4" >本中转中心编号：</div>

<div class="col-lg-5 col-md-5" ></div>
<div class="col-lg-3 col-md-3" >接收日期：<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,10) %></div>

</div>
<hr>
<br><br><br>
<form action="${pageContext.request.contextPath}/hallarrivallist/hello1" id="form1" method="post" enctype="multipart/form-data">

<div class="row">
<div class="col-lg-4 col-md-4" ><input type="radio" name="radio"  checked  value="0" onclick="radio_dianjione(this)" >货运中转单:
<input type="text" name="tranId" id="tranId" /></div>
<div class="col-lg-4 col-md-4" ></div>
<div class="col-lg-4 col-md-4" >
<input type="radio" name="radio" value="1" onclick="radio_dianji(this)" >货运装车单号:
<input type="text" name="transNumber" id="transNumber" readonly="readonly"/></div>
</div>
<br>
<div class="row">
<div class="col-lg-2 col-md-2" >货物到达状态: 
 <br/>
</div>
<div class="col-lg-2 col-md-2" ><input type="radio" name="checkstate" value="0" checked>完好</div>
<div class="col-lg-2 col-md-2" ><input type="radio" name="checkstate" value="1">缺损</div>
<div class="col-lg-2 col-md-2" ><input type="radio" name="checkstate" >丢失</div>
<div class="col-lg-4 col-md-4" ></div>
</div>
<br>
<div class="row">
<div class="col-lg-8 col-md-8" >导人中转导入表：<input type="file" name="mfile"><br> <input type="button" value="生成中转单" onclick="tijiao()"/></div>
<div class="col-lg-4 col-md-4"></div>
</div>

<br>
<div class="row">
<div class="col-lg-8 col-md-8" >中转接收单号：<select id="select"> <option value ="0">请选择</option></select>
</div>
<div class="col-lg-4 col-md-4"><input type="button" onclick="exportExcel()" value="下载"></div>
</div>
</form>
</div>
<script type="text/javascript">
 function radio_dianji(a){
	alert("ddds");
      $("#dcg").val("1234");
	
	if(a.checked){
		$("#transNumber").prop("readonly",false);
		$("#tranId").prop("readonly",true);
	}else{
		$("#transNumber").prop("readonly",true);
		$("#tranId").prop("readonly",false);
	}
}

	function radio_dianjione(a){
		if(a.checked){
			$("#transNumber").prop("readonly",true);
			$("#tranId").prop("readonly",false);
		}else{
			$("#transNumber").prop("readonly",false);
			$("#tranId").prop("readonly",true);
		}
	}
	 
	
	
	function tijiao(){
		
		var form1=document.getElementById("form1");
		 var fd = new FormData(form1);
		// console.log(fd);
			$.ajax({
				url : "${pageContext.request.contextPath}/hallarrivallist/hello1",
				type:"post",
				data:fd,
				success:function(data){
					if(data.biaoji=="ok"){
						alert(data.hsddd);
					$("#select").append("<option value="+data.ha.hid+">"+data.ha.hid+"</option>");
					$("#select").val(data.ha.hid);
					}else{
						alert(data.hsddd);
					}
				},
			 	processData:false,
				contentType:false
			});
	}
	
	 function exportExcel(){  
		 location.href="${pageContext.request.contextPath}/hallarrivallist/hello2?hid="+$("#select").val();  
		//这里不能用ajax请求，ajax请求无法弹出下载保存对话框
	 }   

</script>
</body>
</html>