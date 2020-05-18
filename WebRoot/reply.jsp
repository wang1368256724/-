<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="org.model.MessBoar" %>
<%@page import="org.dao.*" %>
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>回复留言界面</title>
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
  
  <body bgcolor="#ddd" style="font-family:Microsoft YaHei">
  <div style="text-align:center;margin-top:140px">
    <h1 >请回复留言</h1>
   <form action="ReplyServlet?method=reply&id=${id }" method="post">
  			<table style="margin-left: 37%" border="1">
  			<caption>填写回复信息</caption> 
  		    	
  			<tr><td>回复内容</td>
  				<td>
  				 
  
  				
  				<textarea  class="form-control" name="message" rows="5" cols="35"></textarea></td>
			</tr>
  			</table>
  		<input type="submit" value="提交" class="btn btn-success"/>
  		<input type="reset" value="重置" class="btn btn-warning"/>
  	</form>
    <a href="main.jsp">返回留言板界面</a>  
    </div>
  </body>
</html>

