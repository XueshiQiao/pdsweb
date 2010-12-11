<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'ajax.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="js/json2.js"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
	          var validateForm = function() {
		        	var fileName = $('#theFile').val();
		  			var m=parseInt(fileName.toString().lastIndexOf("."))+1;
		  		    var extVal=fileName.toString().substr(m);
<%--		  			if(extVal!="txt") {--%>
<%--		  				alert('文件类型必须为txt文件！');--%>
<%--		  				return false;--%>
<%--		  			}--%>
		  			$('#upMessage').html('文件上传中，请等待... ...');
		  			return true;	
	        };

	          var showResponse = function(data,status) { 
	              $('#upMessage').fadeIn("fast",function(){
	             	 
	              });
	     		return true;
	           };
	    	  var options={		
	    	    	target : '#upMessage',	
	  				url : 'upload/ajaxUpload.action',
	  				beforeSubmit: validateForm,
	  				success : showResponse,
	  				resetForm:true
	  			};
	    	  $('#upForm').ajaxForm(options);    	  
	      });     
		</script>
	</head>

	<body>
		<form id="upForm" method="POST" enctype="multipart/form-data">
		文件标题：<input type="text" name="title" /><br />
		上传文件：<input type="file" name="upload" id="theFile"/>
		<br/>
		<input type="submit" value="提交" />
		<div id="upMessage" style="displan:hidden"></div>
	</form>
	</body>
</html>
