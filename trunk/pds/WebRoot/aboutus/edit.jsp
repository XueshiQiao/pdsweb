<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="jqueryui/js/jquery-1.4.2.min.js"></script>

	<link rel="stylesheet" href="jqueryui/css/ui-lightness/jquery-ui-1.8.6.custom.css">
	<script type="text/javascript" src="jqueryui/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="jqueryui/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="jqueryui/ui/jquery.ui.button.js"></script>
	<link rel="stylesheet" href="aboutus/niceforms-default.css"></link>
	<script type="text/javascript">
		$(function(){
			$("#submit").button(); //
		});
	</script>
	<style type="text/css">
		.label{
			font-size: 15px;
			color: blue;
			margin-left: 20;
			font-weight: bold;
			
		}
		.btnAdd{
			margin-left: 20px;
		}
	</style>

  </head>
  
  <body>

    
    <form id="add" action="aboutus/update" method="post">
    	<div id="container">

			<form id="addForm" action="departments/update" method="post"
				class="niceform">
				<fieldset>
					<legend>
						修改部门信息
					</legend>
					<dl>
						<dt>
							<label for="model.id">
								ID:
							</label>
						</dt>
						<dd>
							<input type="text" name="aboutUs.id" readonly="readonly" size="32"
								value="<s:property value='aboutUs.id'/>" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.id">
								简介：
							</label>
						</dt>
						<dd>
							<textarea id="introduction" name="aboutUs.introduction" ><s:property value='aboutUs.introduction'/></textarea>
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="aboutUs.history">
								自律委的发展：
							</label>
						</dt>
						<dd>
							<textarea id="history" name="aboutUs.history" ><s:property value='aboutUs.history'/></textarea>
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="aboutUs.competency">
								职能：
							</label>
						</dt>
						<dd>
							<textarea id="competency" name="aboutUs.competency" ><s:property value='aboutUs.competency'/></textarea>
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="aboutUs.contact">
								联系方式：
							</label>
						</dt>
						<dd>
							<textarea id="contact" name="aboutUs.contact" ><s:property value='aboutUs.contact'/></textarea>
						</dd>
					</dl>
<%--    	<span class="label">Id:</span><input readonly="readonly" type="input" name="aboutUs.id" value="<s:property value='aboutUs.id'/>" /><br />--%>
<%--    	<span class="label">简介：</span><textarea id="introduction" name="aboutUs.introduction"><s:property value='aboutUs.introduction'/></textarea><br />--%>
<%--    	<span class="label">历史：</span><textarea id="history" name="aboutUs.history"><s:property value='aboutUs.history'/></textarea><br />--%>
<%--    	<span class="label">职能：</span><textarea id="competency"  name="aboutUs.competency"><s:property value='aboutUs.competency'/></textarea><br />--%>
<%--    	<span class="label">联系方式：</span><textarea id="contact"  name="aboutUs.contact"><s:property value='aboutUs.contact'/></textarea><br />--%>
		    	<script type="text/javascript">
					CKEDITOR.replace( 'introduction');
					CKEDITOR.replace( 'history');
					CKEDITOR.replace( 'competency');
					CKEDITOR.replace( 'contact');
				</script>	
			</fieldset>
			<fieldset>
<%--					<span class="btnEdit"> <input align="middle" id="submit"--%>
<%--							type="submit" value="保存修改" /> </span>--%>
					<input id="submit" type="submit" value="保存修改" />
			</fieldset>
    	
    	
    	
    </form>
  </body>
</html>
