<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="org.model.MessBoar" %>
<%@page import="org.dao.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- �� Bootstrap ���� CSS �ļ� -->
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery�ļ��������bootstrap.min.js ֮ǰ���� -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
  <head>  
    <title>���԰����Իظ�����</title>  
    <style>
   
body

{

    background: url(${pageContext.request.contextPath}/images/1.jpg) no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
   background-size: cover;//����һ��Ҫ    

}


</style>
  </head>

  <body bgcolor="#ddd" >
     <h1 align="center">���������԰����Բ鿴�ظ�������</h1>
   <form  action="leavemessage.jsp" method="post">
  		<table  class="table  table-striped" >
  			<caption>���Իظ���Ϣ</caption>
  			<tr class="info"><th>�ظ�id</th><th>�ظ�ʱ��</th>
				<th>�ظ�����</th>
				</tr>
				<c:forEach varStatus="vs" var="v" items="${list }">
				<tr class="warning"><td>${v.rid }</td><td>${v.replytime}</td>
				<td>${v.replymessage }</td>
				</tr>
				</c:forEach>    
  		
  		</table> 
  	</form>
  	����<a href="loginServlet">����</a>���������档   
  </body>
</html>
