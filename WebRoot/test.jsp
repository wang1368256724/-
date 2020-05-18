<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title> 
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
 
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
 
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>   
</head> 
<body> 
 <form action="FileUpload" method="post" enctype="multipart/form-data"> 
 <br> 
 文件一：<input type="file" name="file1" /> <br> 
 文件二：<input type="file" name="file2" /> <br> 
 上传者:<input type="text" name="uploader"/> <br> 
  日期:<input type="text" name="date"/> <br> 
  <input type="submit" value="提交"/> 
  
 </form> 
</body> 
</html>       