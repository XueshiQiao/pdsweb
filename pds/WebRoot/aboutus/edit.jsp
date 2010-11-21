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
	
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="../jqueryui/js/jquery-1.4.2.min.js"></script>

<link rel="stylesheet" href="../jqueryui/themes/base/jquery.ui.all.css">
<script type="text/javascript" src="../jqueryui/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="../jqueryui/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="../jqueryui/ui/jquery.ui.button.js"></script>
<%--<link rel="stylesheet" href="../demos.css"></link>--%>
	<script type="text/javascript">
	$("input:submit").button();
	
	</script>

  </head>
  
  <body>

    
    <form id="add" action="aboutus/update" method="post">
    	
    	Id:<input readonly="readonly" type="input" name="aboutUs.id" value="<s:property value='aboutUs.id'/>" /><br />
<%--    	简介：<input type="input" name="aboutUs.introduction" value="<s:property value='aboutUs.introduction'/>" /><br />--%>
<%--    	历史：<input type="input" name="aboutUs.history" value="<s:property value='aboutUs.history'/>"/><br />--%>
<%--    	职能：<input type="input" name="aboutUs.competency" value="<s:property value='aboutUs.competency'/>"/><br />--%>
<%--    	联系方式：<input type="input" name="aboutUs.contact" value="<s:property value='aboutUs.contact'/>"/><br />--%>
<%--    	--%>
    	简介：<textarea id="introduction" name="aboutUs.introduction"><s:property value='aboutUs.introduction'/></textarea><br />
    	历史：<textarea id="history" name="aboutUs.history"><s:property value='aboutUs.history'/></textarea><br />
    	职能：<textarea id="competency"  name="aboutUs.competency"><s:property value='aboutUs.competency'/></textarea><br />
    	联系方式：<textarea id="contact"  name="aboutUs.contact"><s:property value='aboutUs.contact'/></textarea><br />
    	<script type="text/javascript">
			CKEDITOR.replace( 'introduction');
			CKEDITOR.replace( 'history');
			CKEDITOR.replace( 'competency');
			CKEDITOR.replace( 'contact');
		</script>	
    	
    	
    	<input type="submit" value="提交" />
    </form>
  </body>
</html>
