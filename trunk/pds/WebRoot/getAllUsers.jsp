<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>execute.jsp</title>
    
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
  <br />
  <s:if test="#request.users == null">
  	暂时还没有用户注册。
  </s:if>
  <s:else>
  	当前有<s:property value="#request.users.size"/>个注册用户.<hr />
  	<table border ="1">
	  <s:iterator value="#request.users" id="user" status="sta">
	  
	 	<tr <s:if test="#sta.odd" >style="background-color:#bbbbbb"</s:if> >
	 		<td>
			  	<s:property value="id"/>
	 		</td>
	 		<td>
			  	<s:property value="username"/>
	 		</td>
	 		<td>
			  	<s:property value="password"/>
	 		</td>
	 	</tr>
	  </s:iterator>
  	</table>
  </s:else>
  </body>
</html>
