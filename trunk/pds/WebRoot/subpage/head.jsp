<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="box">
  <div class="my_span_24 topImg">顶部图片</div>
  <div class="s10"></div>
</div>
<div class="box" >
  <div class="span_24 nav" id="navigate">
    <ul>
      <li ><img src="<%=basePath %>img/nav_left.gif" /></li>
      <li id="firstNavItem"><a href="<%=basePath %>index">首页</a></li>
      
      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>
      <li><a href="<%=basePath %>aboutus/aboutus">自律委简介</a></li>
      
<%--      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>--%>
<%--      <li><a href="<%=basePath %>departments/depInfo">机构设置</a></li>--%>
      
      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>
      <li><a href="<%=basePath %>news/listArticles">新闻动态</a></li>
      
      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>
      <li><a href="<%=basePath %>hotarticle/listArticles">院系风采</a></li>

      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>
      <li><a href="<%=basePath %>developing.jsp">自律委风采</a></li>
      
      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>
      <li><a href="<%=basePath %>fileud/listFiles">文件下载</a></li>
      
      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>
      <li><a href="<%=basePath %>tongbao/listTongbao">通报</a></li>
      
      <li><img src="<%=basePath %>img/nav_jiange.gif" /></li>
      <li><a href="<%=basePath %>developing.jsp">留言板</a></li>
      
      <li><img src="<%=basePath %>img/nav_right.gif" /></li>
    </ul>
  </div>
</div>
