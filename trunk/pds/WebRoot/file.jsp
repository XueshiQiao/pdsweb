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
	        	  当前位置：网站首页 > 文件下载
	        </div>
	        <div class="s10"></div>
	        <div class="article" >
	        	<h3 class="fileTitle"><s:property value="file.title"/></h3>
	            <div class="fileInfo">
	            	<label>文件名：</label><s:property value="file.fileName" default="匿名"/><br/>
	            	<label>上传者：</label><s:property value="file.uploader" default="匿名"/><br/>
	            	<label>文件大小：</label><s:property value="file.size" default="匿名"/>KB
	            	<label>文件类型：</label><s:property value="file.contentType" /><br/>
	            	<label>上传日期：</label><s:date name="file.date" format="yyyy-MM-dd hh:mm:ss"/> <br/>
	            	<label>下载次数：</label><s:property value="file.downloadTimes" /><br/>
	            </div>
	            <p class="content">
	            	<s:property value="article.content" escape="false"/>
	            	<a href="<%=basePath %>download/download?fileId=<s:property value='file.id' />">
	            		<img src="<%=basePath %>img/download.gif" alt="点击下载" />
	            	</a>
	            </p>
	        </div>
	    </div>
	</div>
	<div class="s10"></div>
	<jsp:include page="/subpage/tail.jsp"></jsp:include>
	</body>
</html>