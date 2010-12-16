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
<link rel="stylesheet" href="tongbao/niceforms-default.css"></link>
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

			<form id="editForm" action="tongbao/add" method="post"
				class="niceform">
				<fieldset>
					<legend>
						修改通报
					</legend>
					<dl>
						<dt>
							<label for="model.id">
								ID:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.id" readonly="readonly" size="32"
								value="<s:property value='model.id'/>" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.department">
								院系:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.department" size="32"
								value="<s:property value='model.department' />" require="true" datatype="require" msg="此项不能为空" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.stuClass">
								班级:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.stuClass" size="32"
								value="<s:property value='model.stuClass'/>"  require="true" datatype="require" msg="此项不能为空" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.stuName">
								学生姓名
							</label>
						</dt>
						<dd>
							<input type="text" name="model.stuName" id="email" size="32"
								value="<s:property value='model.stuName'/>" require="true" datatype="require" msg="此项不能为空" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.reason">
								通报原因:
							</label>
						</dt>
						<dd>
							<textarea name="model.reason" rows="5" cols="60" require="true" datatype="require" msg="此项不能为空"><s:property value='model.reason'/></textarea>
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.dormitory">
								所在宿舍:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.dormitory" id="email" size="32"
								value="<s:property value='model.dormitory'/>" require="true" datatype="require" msg="此项不能为空" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.date">
								日期:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.date" id="email" size="32" readonly="true"
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
			    <script> 
					$('#editForm').checkForm();
				</script>
		</div>
	</body>
</html>
