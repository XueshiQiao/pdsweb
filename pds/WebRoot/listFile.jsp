<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>平顶山学院自律与监督委员会</title>
<link type="text/css" href="<%=basePath%>css/24.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/my24.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/zilvwei.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/articles.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>js/zilvwei.js" ></script>
<script src="<%=basePath%>js/jquery-1.4.2.min.js" type="text/javascript"></script>
   
</head>
<body>
<jsp:include page="/subpage/head.jsp" />

<div class="box">
    <div class="span_17">
    	<div class="cur_position">
        	  当前位置：网站首页 > 文件下载
        </div>
        <div class="s10"></div>
        <div class="list" >
        	<s:iterator value="filePageModel.list" status="file">
	        	<div class="article_item">
	            	<h3><a><s:property value="title"/></a></h3>
	                <p class="date">
		            	<label>文件大小：</label><s:property value="size" />	KB				
		            	<label>下载量：</label><s:property value="downloadTimes" />			
		            	<label>上传日期：</label><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/>
	                </p>
	            	<p class="content">	
	               		文件名：<span class="fileName"><s:property value="fileName"/></span>
	               		<a href="<%=basePath %>download/download?fileId=<s:property value='id' />" class="filedownload"> [单击下载]</a> 
	                </p>
	            	<hr/>
	            </div>
        	</s:iterator>
        	
            <div class="paganation">
                <a id="firstPage" href="#" class="pageItem">首页</a> 
                <a id="prePage" href="#"  class="pageItem">上一页</a> 
                <a id="nextPage" href="#"  class="pageItem">下一页 </a>
                <a id="tailPage" href="#"  class="pageItem">尾页 </a>
                <a  class="pageItem">页次：<s:property value="filePageModel.pageNo"/>/<s:property value="artPageModel.pageCount"/>页  </a>
                <a  class="pageItem">共<s:property value="filePageModel.totalCount"/>条记录 </a>
                <a  class="pageItem"><s:property value="filePageModel.pageSize"/>条记录/页</a>
            </div>       
      </div>
    </div>
<%--    <div class="span_7"  style="height:600px;">--%>
<%--    	<div style="height:300px;">--%>
<%--        </div>--%>
<%--        <div style="height:500px;">--%>
<%--        </div>--%>
<%--    </div>--%>
</div>

<div class="s10"></div>

<jsp:include page="/subpage/tail.jsp" />

</body>
</html>
