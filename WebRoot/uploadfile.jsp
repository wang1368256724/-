<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@page import="org.model.MessBoar"%>
<%@page import="org.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

<script  
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文件上传界面</title>

<style>
body {
	background: url(${pageContext.request.contextPath}/images/1.jpg)
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	//
	这条一定要
}
</style>
<link  rel="stylesheet" href="emo/css/main.css" />
<link rel="stylesheet" type="text/css" href="emo/css/sinaFaceAndEffec.css" />

<script type="text/javascript" src="emo/js/jquery-1.8.3.min.js"></script>
</head>

<body bgcolor="#ddd" style="font-family: Microsoft YaHei">
	<div style="text-align: center; margin-top: 140px">
		
		<c:if test="${not empty error }">

			<h4 align="center">
				<font color="red">${error }</font>
			</h4>
		</c:if>     
		<form action="FileUpload" method="post" enctype="multipart/form-data">
			<table style="margin-left: 37%" border="1">
				<tr>
					<td>留言标题</td>
					<td><input type="text" name="title" class="form-control" value="${msg.title }"/></td>
				</tr>
				<tr>
					<td>留言内容</td>
					<td><textarea class="form-control" name="message" rows="5" 
							cols="35">${msg.message }</textarea></td>
				</tr>
				<tr>
					<td>图片</td>
					<td>
					请选择图片<font color="red">(可不上传为空)</font><input type="file" name="file1" >
					</td>
				</tr> 
				
				<tr> 
					<td>附件</td>
					<td>
					请选择附件<font color="red">(可不上传为空)</font><input type="file" name="file2" >
					</td>
				</tr>
			</table>
			<input type="submit" value="提交" class="btn btn-success" /> <input
				type="reset" value="重置" class="btn btn-warning" />
		</form>
		<a href="main.jsp">返回留言板界面</a>
	</div>
	
<script type="text/javascript" src="emo/js/main.js"></script>
<script type="text/javascript" src="emo/js/sinaFaceAndEffec.js"></script>
<script type="text/javascript">
	// 绑定表情
	$('.face-icon').SinaEmotion($('.text'));
	// 测试本地解析    
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

