<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="org.model.MessBoar"%>
<%@page import="org.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      

<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"> 

<!-- jQuery�ļ��������bootstrap.min.js ֮ǰ���� -->

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<!-- ���µ� Bootstrap ���� JavaScript �ļ� -->

<script  
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>���Խ���</title>

<style>
body {
	background: url(${pageContext.request.contextPath}/images/1.jpg)
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	//
	����һ��Ҫ
}
</style>
<link  rel="stylesheet" href="emo/css/main.css" />
<link rel="stylesheet" type="text/css" href="emo/css/sinaFaceAndEffec.css" />

<script type="text/javascript" src="emo/js/jquery-1.8.3.min.js"></script>
</head>

<body bgcolor="#ddd" style="font-family: Microsoft YaHei">
	<div style="text-align: center; margin-top: 140px">
		<h1>������</h1>
		<c:if test="${not empty error }">

			<h4 align="center">
				<font color="red">${error }</font>   
			</h4>
		</c:if>
		<form action="leaveMessageServlet" method="post" >
			<table style="margin-left: 37%" border="1">
				<caption>��д������Ϣ</caption>
				<tr>
					<td>���Ա���</td>
					<td><input type="text" name="title" class="form-control" /></td>
				</tr>
				<tr>
					<td>��������</td>
					<td><textarea class="form-control" name="message" rows="5"
							cols="35"></textarea></td>
				</tr>
				
				<tr>
					<td>����</td> 
					<td>
				
			<div class="content">
				<div class="cont-box">
					<textarea class="text" placeholder="������..."></textarea>
				</div>
				<div class="tools-box">
					<div class="operator-box-btn"><span class="face-icon"  >����</span>          
				</div>
			</div>
   
					</td>
				</tr>
				
			</table>
			<input type="submit" value="�ύ" class="btn btn-success" /> <input
				type="reset" value="����" class="btn btn-warning" />
		</form>
		<a href="main.jsp">�������԰����</a>
	</div>
	
<script type="text/javascript" src="emo/js/main.js"></script>
<script type="text/javascript" src="emo/js/sinaFaceAndEffec.js"></script>
<script type="text/javascript">
	// �󶨱���
	$('.face-icon').SinaEmotion($('.text'));
	// ���Ա��ؽ���    
	function out() {
		var inputText = $('.text').val();
		$('#info-show ul').append(reply(AnalyticEmotion(inputText)));
	}
	
	var html;
	
</script>
<script>

</script>
</body>
</html>

 