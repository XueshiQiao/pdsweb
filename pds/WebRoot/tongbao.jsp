<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>平顶山学院自律与监督委员会</title>
	<link type="text/css" href="<%=basePath%>css/24.css" rel="stylesheet" />
	<link type="text/css" href="<%=basePath%>css/my24.css" rel="stylesheet" />
	<link type="text/css" href="<%=basePath%>css/zilvwei.css" rel="stylesheet" />
	<link type="text/css" href="<%=basePath%>css/articles.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>js/zilvwei.js" ></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js" ></script>
	</head>
	<body>
	
	<jsp:include page="/subpage/head.jsp" ></jsp:include>
	<div class="box">
	    <div class="span_24">
	    	<div class="cur_position">
	        	  当前位置：网站首页 > 通报
	        </div>
	        <div class="s10"></div>
	        <div class="article" >
	        	<h3><s:property value="tongbao.department"/></h3>
	            <div class="detailedInfo">
	            	<label>日期：</label><s:date name="tongbao.date" format="yyyy-MM-dd hh:mm:ss"/> 
	            </div>
	            <p class="content">
	            	<s:property value="tongbao.content" escape="false"/>
	            </p>
	        </div>
	    </div>
	</div>
	<div class="s10"></div>
	<jsp:include page="/subpage/tail.jsp"></jsp:include>
	</body>
</html>