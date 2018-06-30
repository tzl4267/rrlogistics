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
财务人员:${userName}
<hr>
<center><h2>结算管理</h2></center>
<br>

<hr>


<div class="row">
<div class="col-lg-1 col-md-1" ></div>
<div class="col-lg-10 col-md-10" ><center>营业厅编号:&nbsp;<input type="text" id="agencyId" name="agencyId"/>
 <input type="button" value="search" onclick="seach()">
 &nbsp;&nbsp;&nbsp;<input type="button" value="确定导出excel" onclick="out_excel()"/> </center></div>
<div class="col-lg-1 col-md-1" ></div>
</div>
<br>
<div class="row">
<div class="col-lg-1 col-md-1" ></div>
<div class="col-lg-5 col-md-5" >起始日期:<input type="date" id="begin_time" name="begin_time"/></div>
<div class="col-lg-2 col-md-2" ></div>
<div class="col-lg-3 col-md-3" >终止日期:<input type="date" id="end_time" name="end_time"/></div>
<div class="col-lg-1 col-md-1" ></div>
</div>

<br>
<div class="row">
<div class="col-lg-1 col-md-1" ></div>
<div class="col-lg-10 col-md-10" >
  <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
										 <th>收款条形码</th>
										 <th>收款日期</th>
										 <th>收款金额</th>
										 <th>包裹单</th>
										
										 </tr>
                                    </thead>
                                    <tbody>
                                      
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
 


<div class="col-lg-1 col-md-1" ></div>
</div>
<div class="row">
<div class="col-lg-1 col-md-1" ></div>
<div class="col-lg-2 col-md-2" >共有<span id="allCount">0</span>条记录</div>
<div class="col-lg-4 col-md-4" >当前页面第<span id="nowPage_1">0</span>页/总共有<span id="allPage">0</span>页

<input type="hidden" id="nowPage" value="0"/>

</div>
<div class="col-lg-1 col-md-1" ><a onclick="index()">首页</a></div>
<div class="col-lg-1 col-md-1" ><a onclick="last()">上一页</a></div>
<div class="col-lg-1 col-md-1" ><a onclick="next()">下一页</a></div>
<div class="col-lg-1 col-md-1" ><a onclick="over()">尾页</a></div>
<div class="col-lg-1 col-md-1" ></div>

</div>
<br>
<div class="row">
<div class="col-lg-9 col-md-9" ></div>


<div class="col-lg-3 col-md-3" >当前页共<span id="page_money">0</span>元/共计<span id="sum_money">0</span>元</div>
</div>
</div>

<script type="text/javascript">
 function  seach(){//根据条件查询收款明细
	 timebidui();//调判断前后时间的方法
	 var ac={"begin_time":$("#begin_time").val(),"end_time":$("#end_time").val(),"nowPage":$("#nowPage").val(),
			"agencyId":$("#agencyId").val() };
	var t=0;
	 
	 $.ajax({
			url : "${pageContext.request.contextPath}/moneyinlist/hello1",
			type:"post",
			data:ac,
			success:function(data){
				if(data==""){
					$("#nowPage").val("0");
				}else{
					//每次要先把表格中除第一行的元素清空
					$("table tr:gt(0)").remove();
					for(i=0;i<data.pagebean.ll.length;i++){
						$("table").append("<tr><td>"+data.pagebean.ll[i].mid+"</td><td>"+data.pagebean.ll[i].mTimee
							+"</td><td>"+data.pagebean.ll[i].moneyTota+"</td><td>"+data.pagebean.ll[i].orderNumber+"</td></tr>")
					}
					$("#allCount").html(data.pagebean.allCount);
					$("#nowPage_1").html(data.pagebean.nowPage);
					$("#allPage").html(data.pagebean.allPage);
					$("#nowPage").val(data.pagebean.nowPage);
					
					//计算当前页的总金额
					$("table tr:gt(0)").each(function(){
					var y=$(this).find("td").eq(2).text();
					t=y*1+t;
					})
					//把前页金额和总金额赋值到所属的元素中
					$("#page_money").html(t);
					$("#sum_money").html(data.sum_money);
				}
			}
		});
 }
	
	function next(){//下一页的函数方法
		var a=$("#nowPage").val();
		a=parseInt(a,10)+1;
		$("#nowPage").val(a);
		seach();//调查询方法
	}
	
	function last(){//上一页的方法
		var a=$("#nowPage").val();
		a=parseInt(a,10)-1;
		$("#nowPage").val(a);
		seach();
	}
	
	function index(){
		$("#nowPage").val("1");
		seach();//调查询方法
	}
	
	function over(){//尾页的方法
		$("#nowPage").val("over");
		seach();//调查询方法
	}
	
    function timebidui(){// 前后时间的比对方法
    	var a=$("#begin_time").val();
    	var b=$("#end_time").val();
    	if(a!=""&&b!=""){//条件如过两个时间元素都有值时才判断
    		a=a.replace(/-/g, '/');
    		b=b.replace(/-/g, '/');
    	    var c=new Date(a);
    	    var d=new Date(b);
    	    if(c>d){
    	    	$("#end_time").val("");//如果前面的时间大于后的时间，直接把后面的时间清空
    	    }
    	}
    	
    }
	
    function out_excel(){//poi 导出
    	var a=$("#allCount").html();
    	if(a=="0"){//判断是否查出收款清单了
    	 alert("请先查询收款单明细");
    	}else{
    	location.href="${pageContext.request.contextPath}/moneyinlist//hello2"; 
    	//这里不能用ajax请求，ajax请求无法弹出下载保存对话框
    	}
    }
	
</script>
</body>
</html>