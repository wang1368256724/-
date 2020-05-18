<%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
  
<%@page import="java.util.List"%><html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title> 
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
<body> 
  <div style="margin-left:40%;margin-top:100px">
 <br> 
 --------------直接下载------------ 
 <br> 
 <% 
 List<String> fileNames = (List<String> )request.getAttribute("fileNames"); 
 for(String fileName : fileNames) { 
 %> 
  
 <form action="FileUpload" method="get"> 
  <input type="hidden" name="fileName" value="<%=fileName %>" /> 
  <input type="submit" value="下载:<%=fileName %>" /> 
 </form> 
 <% 
 } 
 %> 
 <br> 
   
 </br>
 </div> 
  
</body> 
</html> 