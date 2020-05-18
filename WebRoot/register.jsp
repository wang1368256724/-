<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>注册界面</title>
    <style>
   
body

{

    background: url(${pageContext.request.contextPath}/images/1.jpg) no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
   background-size: cover;//这条一定要    

}


</style> 
  </head>
  
  <body bgcolor="#ddd" style="font-family:Microsoft YaHei" >
  <div style="text-align:center;margin-top:120px">
    <h1 >请注册</h1>
    <form action="registerServlet" method="post">
    	<table style="margin-left:40%">
    		<caption>用户注册</caption>
    		
    		  <input name="id" type="hidden" value="0" />          
    		
    		<tr>
    			<td>登录名：</td>
    			<td><input name="name" type="text" size="21" class="form-control" ></td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td><input name="password" type="password" size="21" class="form-control" ></td>
    		</tr>
    	</table> 
    	<input type="submit" value="注册" class="btn btn-success">
    	<input type="reset" value="重置" class="btn btn-warning"> 
    </form>
    <br> 
    <a href="login.jsp">登录</a>
    </div>
  </body>
</html>
 