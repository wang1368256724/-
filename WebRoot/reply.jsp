<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="org.model.MessBoar" %>
<%@page import="org.dao.*" %>
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery�ļ��������bootstrap.min.js ֮ǰ���� -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>�ظ����Խ���</title>
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
  
  <body bgcolor="#ddd" style="font-family:Microsoft YaHei">
  <div style="text-align:center;margin-top:140px">
    <h1 >��ظ�����</h1>
   <form action="ReplyServlet?method=reply&id=${id }" method="post">
  			<table style="margin-left: 37%" border="1">
  			<caption>��д�ظ���Ϣ</caption> 
  		    	
  			<tr><td>�ظ�����</td>
  				<td>
  				 
  
  				
  				<textarea  class="form-control" name="message" rows="5" cols="35"></textarea></td>
			</tr>
  			</table>
  		<input type="submit" value="�ύ" class="btn btn-success"/>
  		<input type="reset" value="����" class="btn btn-warning"/>
  	</form>
    <a href="main.jsp">�������԰����</a>  
    </div>
  </body>
</html>

