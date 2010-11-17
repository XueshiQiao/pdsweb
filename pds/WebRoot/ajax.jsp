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
		<script type="text/javascript">
		$.post("ajax/test.action", //服务器要接受的url
				{
					name : "lulu"
				}, //传递的参数		
				function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
					//alert(data.au.history);
					var aboutUs = data.au;
					//var obj = JSON.parse(data.au);//eval("("+data+")");	//包数据解析为json 格式  
					$('#result').html(aboutUs.id + "," + aboutUs.history);
				}, 'json' //数据传递的类型  json
		);
</script>
	</head>

	<body>
		<div id="result">
			Hello!
		</div>
	</body>
</html>
