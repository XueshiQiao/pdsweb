<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加</title>
    
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
	<link rel="stylesheet" href="jqueryui/css/ui-lightness/jquery-ui-1.8.6.custom.css"></link>
	<script type="text/javascript" src="jqueryui/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="jqueryui/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="jqueryui/ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="jqueryui/jquery.form.js"></script>
	
	<!-- 表单验证框架 -->
	<script type="text/javascript" src="js/jqvalidator/jquery.validator.js"></script>
	<link rel="stylesheet" href="js/jqvalidator/jqvalidator.css"></link>
	
	<link rel="stylesheet" href="tongbao/niceforms-default.css"></link>
	
		
	<script type="text/javascript">
		$(function(){
			$("#submit").button(); //
			$('#addForm').ajaxForm(function(responseText, statusText, xhr, $form) { 
				if(statusText=="success"){
					alert("保存成功！");
				}else{
					alert("保存失败,请联系管理员！");
				}
            }); 
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
  
    <div id="container">
    
    <form id="addForm" action="tongbao/add" method="post" class="niceform">
    	<fieldset>
	    	<legend>添加通报</legend>
	    	<dl>
	        	<dt><label for="model.department">院系:</label></dt>
	            <dd><input type="text" name="model.department" size="32" maxlength="128" require="true" datatype="require" msg="此项不能为空"/></dd>
	        </dl>
	    	<dl>
	        	<dt><label for="model.stuClass">班级:</label></dt>
	            <dd><input type="text" name="model.stuClass"  size="32" maxlength="128" require="true" datatype="require" msg="此项不能为空" /></dd>
	        </dl>
	    	<dl>
	        	<dt><label for="model.stuName">学生姓名</label></dt>
	            <dd><input type="text" name="model.stuName" id="email" size="32" maxlength="128" require="true" datatype="require" msg="此项不能为空" /></dd>
	        </dl>
	    	<dl>
	        	<dt><label for="model.reason">通报原因:</label></dt>
	            <dd><textarea name="model.reason"  rows="5" cols="60" require="true" datatype="require" msg="此项不能为空"></textarea></dd>
	        </dl>
	    	<dl>
	        	<dt><label for="model.dormitory">所在宿舍:</label></dt>
	            <dd><input type="text" name="model.dormitory" id="email" size="32" maxlength="128" require="true" datatype="require" msg="此项不能为空" /></dd>
	        </dl>
	    	
	<%--    	<input type="input" name="model.department" /><br/>--%>
	<%--    	班级:<input type="input" name="model.stuClass" /><br/>--%>
	<%--    	学生姓名:<input type="input" name="model.stuName" /><br/>--%>
	<%--    	通报原因:<input type="input" name="model.reason" /><br/>--%>
	<%--    	所在宿舍:<input type="input" name="model.dormitory" /><br/>--%>
    	</fieldset>
		<fieldset class="action">
	    	<span class="btnAdd">
	    		<input align="middle" id="submit" type="submit" value="添加通报" />
	    	</span>
		</fieldset>
    	
    </form>
    <script> 
		$('#addForm').checkForm();
	</script>
	    
    </div>
  </body>
</html>
