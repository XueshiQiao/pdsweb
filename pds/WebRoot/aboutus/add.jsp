<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="sample.js"></script>
	<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
	
	
  </head>
  
  <body>
    <a href="aboutus/test"> Test方法</a>
    
    <form id="addForm" action="aboutus/add" method="post">
    	简介：<textarea id="introduction" name="aboutUs.introduction"></textarea><br />
    	<script type="text/javascript">
			CKEDITOR.replace( 'introduction');
		</script>	
    	历史：<textarea id="history" name="aboutUs.history"></textarea><br />
    	职能：<textarea id="competency"  name="aboutUs.competency"></textarea><br />
    	联系方式：<textarea id="contact"  name="aboutUs.contact"></textarea><br />
    	<input type="submit" value="提交" />
    </form>
  </body>
</html>