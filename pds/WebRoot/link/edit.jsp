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

		<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="jqueryui/js/jquery-1.4.2.min.js"></script>
		<link rel="stylesheet" href="jqueryui/css/ui-lightness/jquery-ui-1.8.6.custom.css"></link>
		<script type="text/javascript" src="jqueryui/ui/jquery.ui.core.js"></script>
		<script type="text/javascript" src="jqueryui/ui/jquery.ui.widget.js"></script>
		<script type="text/javascript" src="jqueryui/ui/jquery.ui.button.js"></script>
		<link rel="stylesheet" href="hotarticle/niceforms-default.css"></link>
		
		
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

			<form id="updateForm" action="link/update" method="post"
				class="niceform">
				<fieldset>
					<legend>
						修改友情链接信息
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
							<label for="model.name">
								标题:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.name" size="32" require="true" datatype="require" msg="标题不能为空" 
								value="<s:property value='model.name'/>" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.url">
								链接地址:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.url" size="32" require="true" datatype="url" msg="地址必须为url格式的地址" 
								value="<s:property value='model.url'/>" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.sortId">
								序号:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.sortId" size="32" require="true" datatype="integer" msg="序号必须为数字" 
								value="<s:property value='model.sortId'/>" maxlength="128" />
						</dd>
					</dl>
					
				</fieldset>
				<fieldset>
					<span class="btnEdit"> <input align="middle" id="submit"
							type="submit" value="保存修改" /> </span>
				</fieldset>
			</form>
			<script type="text/javascript">
				$("#updateForm").checkForm();
			</script>
		</div>
	</body>
</html>
