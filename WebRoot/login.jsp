<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
  
    <title>登录界面</title>
    
    <!-- 新 Bootstrap 核心 CSS 文件 -->
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>    
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
  <c:if test="${not empty error }">
  <h1 align="center"><font color="red">${error }</font></h1></c:if>
  <div style="text-align:center;margin-top:120px">
    <h1 >请登录</h1>
    <form action="loginServlet" method="post">
    	<table style="margin-left:40%">
    		<caption>用户登录</caption>
    		<tr>
    			<td>登录名：</td>
    			<td><input name="name" type="text" size="20" class="form-control" ></td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td><input name="password" type="password" size="21" class="form-control" ></td>
    		</tr>
    	</table> 
    	<input type="submit" value="登录" class="btn btn-success">
    	<input type="reset" value="重置" class="btn btn-warning"> 
    </form>
    <br>
    <a href="register.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="findpassword.jsp">找回密码</a>
    </div>
  </body>  
</html>
