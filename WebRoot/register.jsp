<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!-- �� Bootstrap ���� CSS �ļ� -->
 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery�ļ��������bootstrap.min.js ֮ǰ���� -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>ע�����</title>
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
  
  <body bgcolor="#ddd" style="font-family:Microsoft YaHei" >
  <div style="text-align:center;margin-top:120px">
    <h1 >��ע��</h1>
    <form action="registerServlet" method="post">
    	<table style="margin-left:40%">
    		<caption>�û�ע��</caption>
    		
    		  <input name="id" type="hidden" value="0" />          
    		
    		<tr>
    			<td>��¼����</td>
    			<td><input name="name" type="text" size="21" class="form-control" ></td>
    		</tr>
    		<tr>
    			<td>����:</td>
    			<td><input name="password" type="password" size="21" class="form-control" ></td>
    		</tr>
    	</table> 
    	<input type="submit" value="ע��" class="btn btn-success">
    	<input type="reset" value="����" class="btn btn-warning"> 
    </form>
    <br> 
    <a href="login.jsp">��¼</a>
    </div>
  </body>
</html>
 