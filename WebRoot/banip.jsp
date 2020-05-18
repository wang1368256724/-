<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
	form{
	wnameth:70%;
	margin-left:20%; 
	}
	</style>
</head>
<body>
<h3 align="center"><font color="green">禁止用户ip添加</font></h3>
<c:if test="${not empty error }">
   
<h5 align="center"><font color="red">${error }</font></h5>
</c:if>
<form  action="BanServlet">
	<div class="form-group">    
	<input type="hidden" name="type" value="1" /> 
		<label for="name">ip</label> 
		<input type="text" class="form-control" name="v" 
			   placeholder="请输入要禁止的用户ip">
	</div> 
	  
	
	<input type="submit" class="btn btn-success" value="添加" style="margin-left:40%;"/>
	</form>     
	<c:if test="${not empty mm }">
	<script>
	alert('添加banIP成功,系统已生效');     
	</script>
	</c:if> 
 
</body>
</html>