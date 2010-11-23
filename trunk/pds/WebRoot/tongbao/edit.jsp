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
S
    
    <form id="add" action="tongbao/update" method="post">
    	
    	Id:</span><input readonly="readonly" type="input" name="model.id" value="<s:property value='model.id'/>" /><br />
    	院系:<input type="input" name="model.department" value="<s:property value='model.department'/>" /><br/>
    	班级:<input type="input" name="model.stuClass" value="<s:property value='model.stuClass'/>" /><br/>
    	学生姓名:<input type="input" name="model.stuName" value="<s:property value='model.stuName'/>" /><br/>
    	通报原因:<input type="input" name="model.reason" value="<s:property value='model.reason'/>" /><br/>
    	所在宿舍:<input type="input" name="model.dormitory" value="<s:property value='model.dormitory'/>" /><br/>
    	
    	<input id="submit" type="submit" value="保存修改" />
    </form>
  </body>
</html>
