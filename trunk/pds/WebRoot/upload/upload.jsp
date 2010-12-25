<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	

  </head>
  
  <body>
  <s:fielderror /><hr/>
    <form action="upload/upload.action" method="post" enctype="multipart/form-data">
    	文件标题：<input type="text" name="title" /><br />
    	选择文件：<input type="file" name="upload" /><br />
    	<input value="上传" type="submit" />
  	</form>
  	<hr/>
  		允许上传的文件：
    	<ul>
    		<li>纯文本文件(.txt)</li>	
    		<li>Excel文件</li>	
    		<li>Word文件</li>	
    		<li>PPT文件</li>	
    		<li>图片（bmp gif jpg jpeg png）</li>	
    		<li>压缩rar，zip文件</li>	
    	</ul>
  </body>
  <s:debug />
</html>
