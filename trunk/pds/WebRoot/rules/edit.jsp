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
<script type="text/javascript" src="js/jqvalidator/jquery.validator.js"></script>
<link rel="stylesheet" href="js/jqvalidator/jqvalidator.css"></link>
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

			<form id="editForm" action="rules/update" method="post" class="niceform">
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
			            <dd><input type="text" value="<s:property value='model.title'/>" name="model.title"  size="32" maxlength="128"  require="true" datatype="require" msg="该项不能为空"  /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.content">内容</label></dt>
			            <dd><textarea name="model.content"  rows="5" cols="60"  require="true" datatype="require" msg="该项不能为空" ><s:property value='model.content'/></textarea></dd>
			        </dl>
			        <dl>
			        	<dt><label for="model.brief">内容摘要</label></dt>
			            <dd><textarea  name="model.brief"  rows="5" cols="60"  require="true" datatype="require" msg="该项不能为空" <s:property value='model.brief'/></textarea></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.author">作者:</label></dt>
			            <dd><input type="text" value="<s:property value='model.author'/>" name="model.author" id="" size="32" maxlength="128" /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.dep">部门:</label></dt>
			            <dd><input type="text" value="<s:property value='model.dep'/>" name="model.dep" id="" size="32" maxlength="128"  require="true" datatype="require" msg="该项不能为空"  /></dd>
			        </dl>
			    	<dl>
			        	<dt><label for="model.visitedCount">点击量:</label></dt>
			            <dd><input type="text" value="<s:property value='model.visitedCount'/>" name="model.visitedCount" id="" size="32" maxlength="128"  require="true" datatype="integer" msg="点击量不能为空，且必须是整数"  /></dd>
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
			<script type="text/javascript">
				$("#editForm").checkForm();
			</script>
		</div>
	</body>
</html>
