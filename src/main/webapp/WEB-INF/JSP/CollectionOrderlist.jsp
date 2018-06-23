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
<title>Insert title here</title>
<!--对比收件人姓名是否相同 -->
<script type="text/javascript">
function aaa() {

	if("${odl.receivername}"!=$("#receivername").val()){
		//不相同吧填写的值转给id为ww
		$('#ww').val($('#receivername').val());
		//弹出模态框
		$("#myModal").modal("show");
	}else {
		//点击按钮
		$("#queding").submit();
	}

}

</script>
</head>
	<body>
		<div align="center" style="width: 1800px;">
		<!-- 根据快递单号查询 -->
		<form action="${pageContext.request.contextPath}/O/Orderlist">
		 <label style="font-size: 20px">快递单号:</label>
      <div class="layui-input-inline">
        <input type="text" name="orderNumber"  class="layui-input" id="kddh">
        </div>
        <button 	class="layui-btn layui-btn-normal" >查询</button>
        </form>
        <br>
        <div style="width: 800px;" align="left">
        <label style="font-size: 17px">快递单号:</label>
      <div class="layui-input-inline">
        <input type="text" value="${odl.orderNumber}" class="layui-input" disabled="disabled">
		</div>
		<hr />
		<!-- 外层删格 -->
			<div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div> <label style="font-size: 17px">收件人姓名:</label>
      <!-- 内层 删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" id="receivername" class="layui-input">
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
      <div>&nbsp;	</div>
    </div>
    </div><!-- 外层删格结束 -->
    <hr/>
    
    
    <!-- 寄件 --><!-- 外层删格 -->
    <div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div> <label style="font-size: 17px">寄件人姓名:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="sendername" value="${odl.sendername }" class="layui-input" disabled="disabled">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>			
    </div>
    </div>

    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div>&nbsp;</div>
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div><label style="font-size: 17px">收件人姓名:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="receivername" value="${odl.receivername}" class="layui-input" disabled="disabled">
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
    
    <div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div> <label style="font-size: 17px">寄件人手机号:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="sendertelenumber" value="${odl.sendertelenumber}"  class="layui-input" disabled="disabled">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>			
    </div>
    </div>

    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div>&nbsp;</div>
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div><label style="font-size: 17px">收件人手机号:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="receivertelenumber"  value="${odl.receivertelenumber}" class="layui-input" disabled="disabled">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div></div>
    </div>
    </div>
    
    <div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div> <label style="font-size: 17px">寄件人地址:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="senderaddress" value="${odl.senderaddress}"  class="layui-input" disabled="disabled">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>			
    </div>
    </div>

    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div>&nbsp;</div>
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div><label style="font-size: 17px">收件人地址:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="receiveraddress" value="${odl.receiveraddress}"  class="layui-input" disabled="disabled">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div></div>
    </div>
    </div>
    <div class="layui-row">
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div> <label style="font-size: 17px">重量:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="weight"  value="${odl.weight}" class="layui-input" disabled="disabled">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>			
    </div>
    </div>

    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <label style="font-size: 17px">体积:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="volume"  value="${odl.volume}" class="layui-input" disabled="disabled">
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div>	
    </div>
    
    <div  class="layui-col-xs4 layui-col-sm12 layui-col-md4">
      <div><label style="font-size: 17px">运费:</label>
    <div class="layui-row">
    <div  class="layui-col-xs8 layui-col-sm12 layui-col-md8">
      <div class="layui-input-inline">
        <input type="text" name="moneyTota"  value="${odl.moneyTota}" class="layui-input" disabled="disabled"> 
		</div>			
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div>&nbsp;</div>
    </div></div></div>
    </div>
    </div><br><br>
    <!-- 按钮开始 -->
       <div class="layui-row">
       <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div class="layui-input-inline">
        &nbsp;
		</div>		
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div class="layui-input-inline">
        <form action="${pageContext.request.contextPath}/O/Orderlist3"    id="queding"  >
		<input type="hidden" name="orderNumber" value="${ odl.orderNumber}"/>
		<button type="button" onclick="aaa();" class="layui-btn">确认</button>
</form>
		</div>		
    </div>
    <div  class="layui-col-xs3 layui-col-sm12 layui-col-md3">
      <div class="layui-input-inline">
        &nbsp;
		</div>		
    </div>
    <div  class="layui-col-xs3 layui-col-sm12 layui-col-md3">
      <div class="layui-input-inline">

        <a href="${pageContext.request.contextPath}/O/Orderlist1"><button type="button" class="layui-btn">取消</button></a>

		</div>
    </div>
    <div  class="layui-col-xs2 layui-col-sm12 layui-col-md2">
      <div class="layui-input-inline">
        &nbsp;
		</div>		
    </div>
   </div>

    <!-- 按钮结束 -->
    
        </div>
        
        </div>
<!-- 模态框开始 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					收件人姓名不一致！
				</h4>
			</div>
			<div  >
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/O/Orderlist2">			
    				<input type="hidden" name="sendername"  value="" id="ww">
    				<input type="hidden" name="orderNumber" value="${ odl.orderNumber}"/>
    				
    				<input type="file" class="form-control"  name="name">
    				<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary">
					确认
				</button>
			</div>
					</form>		
							
			</div>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- 模态框结束 -->	
		
    </body>
</html>