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
中转中心业务员:${userName}
<hr>
<center><h2>中转接收</h2></center>
<br>


<div class="row">
<div class="col-lg-4 col-md-4" >本中转中心编号：${agency	Id}</div>

<div class="col-lg-5 col-md-5" ></div>
<div class="col-lg-3 col-md-3" >接收日期：<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,10) %></div>

</div>
<hr>
<br><br><br>
<form action="${pageContext.request.contextPath}/hallarrivallist/hello1" id="form1" method="post" enctype="multipart/form-data" onsubmit="return userCheck()">

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
<div class="col-lg-8 col-md-8" >导人中转导入表：<input type="file" name="mfile" id="mfile"><br> <input type="button" value="生成中转单" onclick="tijiao()"/></div>
<div class="col-lg-4 col-md-4"></div>
</div>

<br>
<div class="row">
<div class="col-lg-4 col-md-4" >中转接收单号：<select id="select"> <option value ="0">--请选择--</option></select>
</div>
<div class="col-lg-4 col-md-4"><input type="date" id="timee"><input type="button" value="查询中转接收单" onclick="chuxundan()"></div>
<div class="col-lg-4 col-md-4"> <input type="button" onclick="exportExcel()" value="下   载"></div>
</div>
</form>
</div>
<script type="text/javascript">
 function radio_dianji(a){
	
	
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
	 
	
	
	function tijiao(){//poi导出
		var a= $("input[name='radio']").get(0).checked==true?$("#tranId").val():$("#transNumber").val();
		var b=$("#mfile").val();
		if(a==""){
			alert("请填好单号！");
		}else if(b==""){
			alert("请选择上传的文件");
		}else{
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
	}
	
	 function exportExcel(){  //poi下载
		 var cd=$("#select").val();
		 if(cd=="0"){
			alert("请选择好中转中心接收单！");
		 }else{
		 location.href="${pageContext.request.contextPath}/hallarrivallist/hello2?hid="+$("#select").val();  
		//这里不能用ajax请求，ajax请求无法弹出下载保存对话框
		 }
	 }   
	 
	 function chuxundan(){//根据时间天查询中转接收单
		
		var ss=$("#timee").val();
		if(ss==""){
			alert("请先选择好日期！！");
		}else{
		 $.ajax({
				url : "${pageContext.request.contextPath}/hallarrivallist/hello3?timee="+$("#timee").val(),
				type:"post",
				//data:{"timee":$("#timee").val()},
				success:function(data){
					
					console.log(data);
					$("#select").empty();
					if(data.length==0){
						$("#select").append("<option value=0>-请选择-</option>");
					}
					
					for(i=0;i<data.length;i++){
						
						$("#select").append("<option value="+data[i].hid+">"+data[i].hid+"</option>");
					}
				}
			});
		}
		 
	 }
	 
	 $("#transNumber").blur(function(){//装车单离开焦点事件
		
		 var cf= $("#transNumber").val();
		  
			if(cf==""){
			alert("请输入单号 装车单");
			}else{
				 $.ajax({
						url : "${pageContext.request.contextPath}/hallarrivallist/hello4",
						type:"post",
						data:{"transNumber":cf},
						success:function(data){
						 if(data.biaoji=="error"){
							 alert("输入的单号有误，请重新输入！");
							 $("#transNumber").val("");
							 
						 }
						}
					});
			}

		
		})
	 
	 $("#tranId").blur(function(){//中转单离开焦点事件
		
			var cf= $("#tranId").val();
			if(cf==""){
			alert("请输入单号中转中心");
			}else{
				 $.ajax({
						url : "${pageContext.request.contextPath}/hallarrivallist/hello5",
						type:"post",
						data:{"tranId":cf},
						success:function(data){
						 if(data.biaoji=="error"){
							 alert("输入的单号有误，请重新输入！");
							 $("#tranId").val("");
						 }
						}
					});
			}
			});

</script>
</body>
</html>