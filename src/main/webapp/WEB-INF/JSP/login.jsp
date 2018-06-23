<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
body{
background-color: #0091e6;
font-family:"Microsoft YaHei";
}
.main{
margin:5em auto 0;
width:450px;
}
h1{
font-size:2.4em;
padding-bottom: 28px;
color:#FFF;
text-align:center;
}
h2{
font-size:1.5em;
padding-bottom: 20px;
color:#0091e6;
text-align:center;
}
.login{
padding:2em 0;
}
.inset{
position:relative;
background: #FFF;
padding:2.5em;
}
form span{
display:block;
font-size:1.0em;
color:#333;
font-weight:400;
}
input[type="text"],input[type="password"]{
padding:9px;
width:88%;
font-size:1.1em;
margin:3px 0px 2.5px;
color:#666666;
background: #f0f0f0;
border:none;
font-weight:400;
outline:black;
}
.sign{
padding:10px 0 0;
text-align: center;
}
.submit{
margin-right:11px;
background:  #0091e6;
border:none;
outline:none;
padding:8px 30px;
cursor:pointer;
color:#fff;
font-size:0.9em;
border-radius:0.3em;
}
.submit:hover{
background: #999;
}
.aze{
text-align: center;
}
.aze p{
font-size:1em;
color:#FFF;
}
.log{
color: #FFF;
font-size:2em;
position:relative;
left:300px;
}
.sty{
border:1px red solid;
}
.look{
position: relative;
left:350px;
top:-30px;
}
.look a:hover{
color:red;
font-style: red;
}
.register{
position: relative;
left:270px;
top:-30px;
font-size:1.3em;
width:100px;
}
</style>
<script type="text/javascript">
function oc(c){
	$(c).css("border","0.1em red solid");
}
function blu(c){
	var name = $(c).val();
	var a = name.length;
	if(a>6){
		$(c).val(name.substr(0,7));
	}
}
function oe(c){
	$(c).css("border","none");
}
function login(){
	var name =$(".textbox").val();
	var pass=$(".password").val();
	location="";
}
</script>
</head>
<body>
<div class="navbar navbar-inverse">
 	<div class="navbar-header">
  <font class="log">犇犇二手车</font>
  </div>
           </div>

<div class="main">
<div class="login">
<h1>后台登陆</h1>
<div class="inset">
<form action="${pageContext.request.contextPath}/user/login" method="post">
<div>
<h2>请登陆</h2>
<span><label>用户名</label></span>
<span><input type="text" name=userName class="textbox" required oninvalid="oc(this);" onblur="blu(this);" onclick="oe(this);" onkeyup="this.value=this.value.replace(/[/,， #]/g,'')"></span>
</div>
<div>
<span><label>密码</label></span>
<span><input type="password" name="pass" class="password" required oninvalid="oc(this);" onblur="blu(this);" onclick="oe(this);" onkeyup="this.value=this.value.replace(/[/,， #]/g,'')"></span>
<span class="look"><a href="#">找回密码?</a></span>
</div>
<div class="sign">
<input type="submit" value="登陆" class="submit" >
<span class="register"><a href="${pageContext.request.contextPath}/user/into">注册</a></span>
</div>
</form>
</div>
</div>
</div>
<div class="aze">
<p>犇犇二手车</p>
</div>
</body>
</html>