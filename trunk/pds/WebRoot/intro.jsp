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


		<link type="text/css"
			href="<%=basePath%>jquery_easyui/themes/default/easyui.css"
			rel="stylesheet" />
		<script type="text/javascript" src="<%=basePath%>jquery_easyui/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>jquery_easyui/jquery.easyui.min.js"></script>
		
		<script type="text/javascript">
			$(function() {
				$("#tabs").tabs();
			});
		</script>
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

					<div id="tabs">
						<div id="tabs-1" title="简介" closable="false" style="padding:20px;">
							<p>
								<s:property value="aboutUs.introduction" escape="false"/>
							</p>
						</div>
						<div id="tabs-2" title="职能" closable="false">
							<p>
								<s:property value="aboutUs.competency"  escape="false" />
							</p>
						</div>
						<div id="tabs-3" title="机构设置" closable="false" >
							<p>
								<s:property value="dep.content"  escape="false" />
							</p>
						</div>
						<div id="tabs-4" title="自律委的发展" closable="false">
							<p>
								<s:property value="aboutUs.history" escape="false" />
							</p>
						</div>
						<div id="tabs-5" title="联系方式" closable="false">
							<p>
								<s:property value="aboutUs.contact" escape="false" />
							</p>
						</div>
					</div>

					
				</div>
			</div>
			<div class="s10"></div>
			<jsp:include page="/subpage/tail.jsp"></jsp:include>
	</body>
</html>