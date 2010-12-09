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
	    <!-- 
    
    private int id; //id
	private String title; //标题
	private String content; //内容 
	private String author; //作者，发布人
	private Date date; //更新时间日期
	
	private String brief; //文章概要
//	private String thumbnail;//缩略图
	
	private int visitedCount; //点击量，访问量
	private String dep;//文章来自哪个部门
     -->
		<div id="container">

			<form id="updateForm" action="hotarticle/update" method="post"
				class="niceform">
				<fieldset>
					<legend>
						修改文章信息
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
							<label for="model.author">
								发布人:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.author" readonly="readonly" size="32"
								value="<s:property value='model.author'/>" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.title">
								标题:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.title" size="32"
								value="<s:property value='model.title'/>" maxlength="128" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="model.dep">
								发布部门:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.dep" size="32"
								value="<s:property value='model.dep'/>" maxlength="128" />
						</dd>
					</dl>
					
					<dl>
						<dt>
							<label for="model.content">
								内容:
							</label>
						</dt>
						<dd>
							<textarea id="content" name="model.content" rows="5" cols="60">
								<s:property value='model.content' />
							</textarea>
						</dd>
					</dl>

					<script type="text/javascript">
						CKEDITOR.replace( 'content');
					</script>
					
					<dl>
						<dt>
							<label for="model.visitedCount">
								浏览量:
							</label>
						</dt>
						<dd>
							<input type="text" name="model.visitedCount" size="32"
								value="<s:property value='model.visitedCount'/>" maxlength="128" />
						</dd>
					</dl>
					
				</fieldset>
				<fieldset>
					<span class="btnEdit"> <input align="middle" id="submit"
							type="submit" value="保存修改" /> </span>
				</fieldset>
			</form>
		</div>
	</body>
</html>
