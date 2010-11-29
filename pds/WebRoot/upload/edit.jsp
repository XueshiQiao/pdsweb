<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<link rel="stylesheet"
	href="jqueryui/css/ui-lightness/jquery-ui-1.8.6.custom.css"></link>
<script type="text/javascript" src="jqueryui/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="jqueryui/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="jqueryui/ui/jquery.ui.button.js"></script>
<link rel="stylesheet" href="rules/niceforms-default.css"></link>
<script type="text/javascript">
	$(function() {
		$("#submit").button(); //
	});
</script>
		<style type="text/css">
.label {
	font-size: 15px;
	color: blue;
	margin-left: 20;
	font-weight: bold;
}

.btnEdit {
	margin-left: 20px;
}
</style>

	</head>

	<body>
		<div id="container">

			<form id="updateForm" action="file/update" method="post" class="niceform">
				<fieldset>
					<legend>
						修改
					</legend>
			    	<dl>
			        	<dt><label for="model.id">ID:</label></dt>
			            <dd><input type="text" value="<s:property value='model.id'/>" name="model.id" readonly="readonly" size="32" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.title">标题:</label></dt>
			            <dd><input type="text" value="<s:property value='model.title'/>" name="model.title"  size="32" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.fileName">原文件名:</label></dt>
			            <dd><input type="text" value="<s:property value='model.fileName'/>" name="model.fileName" readonly="readonly" id="" size="32" maxlength="128" /></dd>
			        </dl>
			        <dl>
			        	<dt><label for="model.size">大小(kb):</label></dt>
			            <dd><input type="text" value="<s:property value='model.size'/>" name="model.size" readonly="readonly" id="" size="32" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.location">上传位置:</label></dt>
			            <dd><input type="text" value="<s:property value='model.location'/>" name="model.location" readonly="readonly" id="" size="60" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.contentType">文件类型:</label></dt>
			            <dd><input type="text" value="<s:property value='model.contentType'/>" name="model.contentType" readonly="readonly" id="" size="60" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.realUploadPath">文件真实路径:</label></dt>
			            <dd><input type="text" value="<s:property value='model.realUploadPath'/>" name="model.realUploadPath" readonly="readonly" id="" size="60" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.uploader">上传者:</label></dt>
			            <dd><input type="text" value="<s:property value='model.uploader'/>" name="model.uploader" id="" size="32" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.downloadTimest">下载次数:</label></dt>
			            <dd><input type="text" value="<s:property value='model.downloadTimes'/>" name="model.downloadTimes" id="" size="32" maxlength="128" /></dd>
			        </dl>
			        <dl>
						<dt>
							<label for="model.date">
								日期:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.date" id="email" size="32"
								value="<s:date name='model.date' format='yyyy-MM-dd HH:mm:ss'/>" maxlength="128" />
						</dd>
					</dl>
				</fieldset>
				<fieldset>
					<span class="btnEdit"> 
						<input align="middle" id="submit" type="submit" value="保存修改" /> 
					</span>
				</fieldset>

			</form>
		</div>
	</body>
</html>
