<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 新 Bootstrap 核心 CSS 文件 -->
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script>
	$(document).ready(function () {
 
                $(".form_datetime").datetimepicker({
                format: "yyyy-mm-dd hh:ii:ss",
                linkField: "mirror_field",
                linkFormat: "yyyy-mm-dd hh:ii"
                });
 
	});
 
</script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>找回密码界面</title>
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
    <h1 >找回密码</h1>
    <form action="UpdatePassServlet" method="post">
    	<table style="margin-left:40%">
    		<caption></caption>
    		<tr>
    			<td>要找回密码的登录名：</td>  
    			<td><input name="name" type="text" value="${name }" size="20" class="form-control" readonly="readonly"></td>
    		</tr>
    		<tr>    
    			<td>请输入新的登录密码:</td>
    			<td><input name="password" type="password" size="21" class="form-control" ></td>
    		</tr>
    		
    	</table>      
    	<input type="submit" value="修改密码" class="btn btn-success">
      </form>  
    <br>
    <a href="register.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp">登录</a>
    </div>
  </body>  
</html>
