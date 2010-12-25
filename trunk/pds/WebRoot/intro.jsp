<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>平顶山学院自律与监督委员会</title>
		<link type="text/css" href="<%=basePath%>css/24.css" rel="stylesheet" />
		<link type="text/css" href="<%=basePath%>css/my24.css"
			rel="stylesheet" />
		<link type="text/css" href="<%=basePath%>css/zilvwei.css"
			rel="stylesheet" />
		<link type="text/css" href="<%=basePath%>css/articles.css"
			rel="stylesheet" />
		<script type="text/javascript" src="<%=basePath%>js/zilvwei.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-1.4.2.min.js"></script>

		<link type="text/css"
			href="<%=basePath%>jqueryui/themes/redmond/jquery.ui.all.css"
			rel="stylesheet" />
		<script type="text/javascript"
			src="<%=basePath%>jqueryui/ui/jquery.ui.core.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>jqueryui/ui/jquery.ui.widget.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>jqueryui/ui/jquery.ui.tabs.js"></script>
	</head>
	<body>

		<jsp:include page="/subpage/head.jsp"></jsp:include>
		<div class="box">
			<div class="span_24">
				<div class="cur_position">
					当前位置：网站首页 > 自律委简介
				</div>
				<div class="s10"></div>
				<div class="article">
					<SCRIPT>
						$(function() {
							$("#tabs").tabs();
						});
					</SCRIPT>

					<div id="tabs">
						<ul>
							<li>
								<a href="#tabs-1">简介</a>
							</li>
							<li>
								<a href="#tabs-2">职能</a>
							</li>
							<li>
								<a href="#tabs-3">自律委的发展</a>
							</li>
							<li>
								<a href="#tabs-4">联系方式</a>
							</li>
						</ul>
						<div id="tabs-1">
							<p>
								<s:property value="aboutUs.introduction" escape="false"/>
							</p>
						</div>
						<div id="tabs-2">
<p>
								<s:property value="aboutUs.competency"  escape="false" />
							</p>
						</div>
						<div id="tabs-3">
							<p>
								<s:property value="aboutUs.history" escape="false" />
							</p>
						</div>
						<div id="tabs-4">
							<p>
								<s:property value="aboutUs.contact" escape="false" />
							</p>
						</div>

					</div>


					<DIV style="DISPLAY: none" class="demo-description">
						<P>
							Click tabs to swap between content that is broken into logical
					</div>
				</div>
			</div>
			<div class="s10"></div>
			<jsp:include page="/subpage/tail.jsp"></jsp:include>
	</body>
</html>