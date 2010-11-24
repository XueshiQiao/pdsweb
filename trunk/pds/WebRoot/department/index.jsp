<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
    This is aboutus JSP page. <br>
    <a href="aboutus/test"> Test方法</a>
    
    <form id="add" action="aboutus/add" method="post">
    	简介：<input type="input" name="aboutUs.introduction"/><br />
    	历史：<input type="input" name="aboutUs.history"/><br />
    	职能：<input type="input" name="aboutUs.competency"/><br />
    	联系方式：<input type="input" name="aboutUs.contact"/><br />
    	<input type="submit" value="提交" />
    </form>
  </body>
</html>
