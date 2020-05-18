<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="org.model.MessBoar" %>
<%@page import="org.dao.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 新 Bootstrap 核心 CSS 文件 -->
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
  <head>  
    <title>留言板留言回复界面</title>  
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

  <body bgcolor="#ddd" >
     <h1 align="center">这里是留言板留言查看回复主界面</h1>
   <form  action="leavemessage.jsp" method="post">
  		<table  class="table  table-striped" >
  			<caption>留言回复信息</caption>
  			<tr class="info"><th>回复id</th><th>回复时间</th>
				<th>回复内容</th>
				</tr>
				<c:forEach varStatus="vs" var="v" items="${list }">
				<tr class="warning"><td>${v.rid }</td><td>${v.replytime}</td>
				<td>${v.replymessage }</td>
				</tr>
				</c:forEach>    
  		
  		</table> 
  	</form>
  	单击<a href="loginServlet">这里</a>返回主界面。   
  </body>
</html>
