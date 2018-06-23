<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>测试页面</title>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/js/cpts/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/js/cpts/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${pageContext.request.contextPath}/js/cpts/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/js/cpts/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' /> 
     
</head>

<body>
    <div id="wrapper">
        <jsp:include page="nav.jsp"></jsp:include>

       
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">


                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Dashboard <small>Summary of your App</small>
                        </h1>
						<ol class="breadcrumb">
  <li><a href="#">Home</a></li>
  <li><a href="#">Library</a></li>
  <li class="active">Data</li>
</ol>
                    </div>
                </div>
				
				
          
			
		
				<footer><p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
				
        
				</footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
     	<script src="${pageContext.request.contextPath}/js/jquery-3.0.0.js" type="text/javascript"></script>

    <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/js/cpts/assets/js/bootstrap.min.js"></script>
	 
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/js/cpts/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="${pageContext.request.contextPath}/js/cpts/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/cpts/assets/js/morris/morris.js"></script>
	
	
	<script src="${pageContext.request.contextPath}/js/cpts/assets/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/js/cpts/assets/js/easypiechart-data.js"></script>
	
	 <script src="${pageContext.request.contextPath}/js/cpts/assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/js/cpts/assets/js/custom-scripts.js"></script>

<script type="text/javascript">
$("a:contains('new page')").bind('click',function(){
	$("#page-inner").empty();  
	$("#page-inner").load("${pageContext.request.contextPath}/user/NewFile");  
	
});
function loadPage(path){
	$("#page-inner").empty();  
	$("#page-inner").load("${pageContext.request.contextPath}/"+path);  
}
</script>
</body>

</html>