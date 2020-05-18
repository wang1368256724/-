<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>      
<%@page import="org.model.MessBoar" %>
<%@page import="org.dao.*" %>
<%@page import="java.util.*" %>    
<!-- 新 Bootstrap 核心 CSS 文件 -->
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
  <head>  
    <title>留言板界面</title> 
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
     <h1 align="center">这里是留言板主界面</h1>
     <div style="width: 500px; margin-left: 36%">    
		<form action="QueryListServlet" method="post">
			
			<div class="form-group">
				<input type="text" class="form-control" id="name" name="v"
					placeholder="请输入全局搜索文字" class="input-medium"> <input
					type="submit" value="点击查询" class="btn btn-mini btn-primary"
					style="margin-left: 100px; margin-top: 2px;" />
			</div>  
		</form>
	</div>     
   <form  action="leavemessage.jsp" method="post">
  		<table  class="table  table-striped" >  
  			<caption>所有留言信息</caption>  
  			<tr class="info"><th>留言id</th><th>留言时间</th>
				<th>留言标题</th><th>留言内容</th>
				<th>上传图片-附件</th>
				<th>回复</th>
				</tr>
  		<%
  			ArrayList<MessBoar> al=new ArrayList<MessBoar>();   
  			al= (ArrayList)session.getAttribute("al");
  			if(al!=null){
  				Iterator iter=al.iterator();
  				while(iter.hasNext()){
  				MessBoar mb=(MessBoar)iter.next();
  		%>
  				<tr  class="warning"><td><%= mb.getId() %></td>
  					<td><%= mb.getTime().toString() %></td>
  					<td><%= mb.getTitle() %></td>    
  					<td><%= mb.getMessage() %></td>  
  					<td><a href="${pageContext.request.contextPath}/ToUploadServlet?id=<%= mb.getId() %>" >去上传</a></td>
  					<td><a href="${pageContext.request.contextPath}/ReplyServlet?method=add&id=<%= mb.getId() %>" >回复</a>
  					&nbsp;&nbsp;
  					<a href="${pageContext.request.contextPath}/ReplyServlet?method=select&id=<%= mb.getId() %>" >查看回复</a></td>
  					
  					</tr>
  		<%   
  			}
  			} 
  		 %>
  		</table> 
  	</form>
   <a style="margin-left:42%" href="leavemessage.jsp" class="btn btn-success">留言</a>
    </div>
  </body>
</html>
