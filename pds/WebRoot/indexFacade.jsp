<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>平顶山学院自律与监督委员会</title>
<link type="text/css" href="<%=basePath%>css/24.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/my24.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/zilvwei.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>js/zilvwei.js" ></script>
<script src="<%=basePath%>js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/YLMarquee-1.1.min.js" type="text/javascript"></script>
<script type="text/javascript">


	/*
		吧日期放到div里
	*/
	//alert(getDatailDate());
	
</script>
    
<style type="text/css">
	#scrollDiv 
	{
		background: #c3cbcb;
		height: 160px;
		margin:1px auto;
		width:950px;
	}
	#scrollDiv li {
		display:inline-block;
		margin: 2px 1px; 
		height: 150px; 
	}
	#scrollDiv .img{width: 173px; height: 150px; margin-top: 16px; margin-left: 14px; overflow:hidden;}
	#scrollDiv .img img
	{
		width: 162px;
	}
</style>
</head>
<body>

<jsp:include page="subpage/head.jsp"></jsp:include>

<!--<marquee direction="left" loop=0 scrolldelay="150">
      …………要滚动的文字………
      </marquee>-->
<div class="box">
  <div class="my_span_24 lastestText">
    <div id="lastestTestTitle" class="lastestTestTitle">最新公告：</div>
    <div id="lastestTextContent" class="lastestTextContent">
      <div id="scroolText">
      	<ul>
        	<li>平顶山学院自律与监督委员会网站v1.0正式上线！</li>
        	<li>平顶山学院自律与监督委员会网站v1.0正式上线！</li>
        	<li>平顶山学院自律与监督委员会网站v1.0正式上线！</li>
<%--        	<li>2局长撞人岂能公家垫付 逃犯青睐美国 </li>--%>
<%--        	<li>3局长撞人岂能公家垫付 逃犯青睐美国 </li>--%>
<%--        	<li>4长撞人岂能公家垫付 逃犯青睐美国</li>--%>
        </ul>      
      </div>
    </div>
  </div>
</div>
<div class="s10"></div>
<div class="box firstRow">
  <div class="my_span_13_dot_5 scrollPics" >
    <script type="text/javascript">
		var width=522;var focus_height=225;var text_height=20;
		var swf_height = focus_height+text_height;
		var pics='';var links='';var texts='';
		pics+='pics/o6hzgf0j0u3t.jpg|';
		links+='http://www.jeecms.com/news/2375.htm|';
		texts+='江西之子、化学泰斗--丘星初了解jeecms|';
		pics+='pics/ka30fy9dhsxr.jpg|';
		links+='http://www.jeecms.com/news/1427.htm|';
		texts+='JEEBBS v1.0 Beta版开源发布公告|';
		pics+='pics/k464fvevlfev.jpg|';
		links+='http://www.jeecms.com/news/1201.htm|';
		texts+='JEECMS v2.3.2 正式版发布公告|';
		pics+='pics/zuqsfvew36q2.jpg|';
		links+='http://www.jeecms.com/rjaz/1069.htm|';
		texts+='JEECMS v2.x安装图文指南|';
		pics=pics.substring(0,pics.length-1);
		links=links.substring(0,links.length-1);
		texts=texts.substring(0,texts.length-1);
		document.write('<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="'+width+'" height="'+swf_height+'">');
		document.write('<param name="movie" value="swf/focus3.swf"/>');
		document.write('<param name="quality" value="high"/><param name="bgcolor" value="#F0F0F0"/>');
		document.write('<param name="menu" value="false"/><param name="wmode" value="opaque"/>');
		document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+width+'&borderheight='+focus_height+'&textheight='+text_height+'"/>');
		document.write('<embed src="swf/focus3.swf" width="'+width+'" height="'+swf_height+'" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" wmode="opaque" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash"></embed>');
		document.write('</object>');
	</script>
  </div>
  <div class="my_span_10_dot_5 hotNews" >
    <div id="hotnewsLable">
      <div id="title">今日热点</div>
    </div>
    <div id="hotnewsContent">
    	<h4><a href="<%=basePath%>news/article?artId=<s:property value='news[0].id'/>"><s:property value="news[0].title"/></a></h4>
        <div id="newsList">
        	<s:if test="news.size > 0">
        		abc
        		<s:iterator value="news" status="newsItem" begin="1" end="8" >
	        		·<a href="<%=basePath%>news/article?artId=<s:property value='id'/>"><s:property value="title"/></a><br />
	        	</s:iterator>
        	</s:if>
        	<s:else>
        		没有新闻可以显示
        	</s:else>
    	</div>
    </div>
  </div>
  
</div>
<div class="s10"></div>
<div class="box secondRow">
  <div class="my_span_8 people">
    <div class="bar_title">院系风采 </div>
    <div class="articleList">
        <div id="newsList">
        	<s:iterator value="hotArticles" status="article">
        		·<a href="<%=basePath%>hotarticle/article?artId=<s:property value='id'/>"><s:property value="title"/></a><br />
        	</s:iterator>
        	
    	</div>
    </div>
  </div>
  <div class="my_span_9 fengcai" >
    <div class="bar_title">通报 </div>
    <div class="articleList">
    	<s:iterator value="tongbaos" status="tongbao">
       		·<a href="<%=basePath%>tongbao/tongbao?tbId=<s:property value='id'/>"><s:property value="department"/></a><br />
       	</s:iterator>        
    </div>
  </div>
  <div class="my_span_7 download" >
    <div class="bar_title"> 下载中心 </div>
    <div class="articleList">
        <s:iterator value="files" status="file">
       		·<a href="<%=basePath%>fileud/file?fileId=<s:property value='id'/>"><s:property value="fileName"/></a><br />
       	</s:iterator>  
    </div>
  </div>
</div>
<div class="s10"></div>
<div class="box">
  <div class="my_span_24 beautifulPic"></div>
</div>
<div class="s10"></div>
<div class="box">
  <div class="my_span_24 articleWithPic" >
    <div class="tuwen_title"> 图文 <span class="tuwen_title more"> <a href="#">更多..</a> </span> </div>    
    <div class="tuwen_content">
    	<div id="scrollDiv">
            <ul>
                <li>
                    <div class="img">
                        <a href="#"><img src="Image/01.jpg" /></a>
                    </div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
                <li>
                    <div class="img">
                        <a href="#"><img src="Image/01.jpg" /></a></div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
                <li>
                    <div class="img">
                        <img src="Image/01.jpg" /></div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
                <li>
                    <div class="img">
                        <img src="Image/02.jpg" /></div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
                <li>
                    <div class="img">
                        <img src="Image/01.jpg" /></div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
                <li>
                    <div class="img">
                        <img src="Image/02.jpg" /></div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
                <li>
                    <div class="img">
                        <img src="Image/01.jpg" /></div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
                <li>
                    <div class="img">
                        <img src="Image/02.jpg" /></div>
                    <a herf="#" style="color:#000066">abc</a>
                </li>
            </ul>
        </div>
    </div>
  </div>
</div>
<div class="s10"></div>

<!-- 友情链接部分 -->
<div class="box">
  <div class="span_24 links" >
    <div class="bar_title link_title">友情链接</div>
    <div id="content"> 
    	<s:iterator value="links" status="link">
    		<a href="<s:property value="url" />"><s:property value="name" /></a>
    	</s:iterator>
    </div>
  </div>
</div>
<div class="s10"></div>

<jsp:include page="subpage/tail.jsp"></jsp:include>

<div class="s10"></div>
<div class="box">

<div>
<script type="text/javascript">

    $("#scrollDiv").YlMarquee({
        visible:5,
        step:3
    });
	$("#scroolText").YlMarquee({
        textMode:true,
		visible:2,
		step:3
    });
	
</script>

</body>
</html>
