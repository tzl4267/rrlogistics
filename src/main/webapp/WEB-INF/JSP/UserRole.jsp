<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
 <link href="${pageContext.request.contextPath}/js/cpts/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/js/cpts/assets/css/font-awesome.css" rel="stylesheet" />
     <!-- Morris Chart Styles-->
   
        <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/js/cpts/assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/js/cpts/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
    <div id="wrapper">
    
       <jsp:include page="nav.jsp"></jsp:include>
       
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            用户信息 
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
             
                
            <div class="row">
            <div class="col-md-1"></div>
                <div class="col-md-9">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>用户名称</th>
                                            <th>角色</th>
                                            <th>姓名</th>
                                            <th>性别</th>
                                            <th>证件号</th>
                                            <th>联系方式</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="userRole">
                                        
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
                <div class="col-md-2"></div>
            </div>
           
                <!-- /. ROW  -->
        </div>
              
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->

        <script>
            $(function () {
               $.ajax({
            	   url:"${pageContext.request.contextPath}/user/searchURole/",
            	   type:"post",
            	   dataType:"json",
            	   success:function(data){
            		   var userRole = $("#userRole");
            		  $(data).each(function(){
            			 userRole.append("<tr class='odd gradeX'>"+
            					  "<th>"+this.userName+"</th><th>"+this.rname+"</th><th>"+this.name+"</th>"+
                                  "<th>"+this.sex+"</th><th>"+this.idnumber+"</th><th>"+this.phonenum+"</th>"+
                                  "<th><button>修改</button>|<button>删除</button></th><th class='hide'>"+this.userId+"</th>"
                                  +"</tr>");
            		  });
            		  $("button:contains('修改')").on('click',function(){
            			  alert($(this).parent().next().text());
            			  window.location="${pageContext.request.contextPath}/user/enterupdateuser?userId="+$(this).parent().next().text();
       	            });
            		  $("button:contains('删除')").on('click',function(){
            			  window.location="${pageContext.request.contextPath}/user/deleteUser?userId="+$(this).parent().next().text();
       	            }); 
            	   },
            	   error:function(data){}
               });
            });
            
           
    </script>
         <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/js/cpts/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
