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
	<!-- nice form -->
<%--	<script language="javascript" type="text/javascript" src="tongbao/niceforms.js"></script>--%>
	<link rel="stylesheet" href="news/niceforms-default.css"></link>
	<script type="text/javascript" src="js/jqvalidator/jquery.validator.js"></script>
	<link rel="stylesheet" href="js/jqvalidator/jqvalidator.css"></link>
	
		
	<script type="text/javascript">
		$(function(){
			$("#submit").button(); //
<%--			for ( i = 0; i < parent.frames.length; ++i ){--%>
<%--				if ( parent.frames[i].FCK ){--%>
<%--					parent.frames[i].FCK.UpdateLinkedField();--%>
<%--				}--%>
<%--			}--%>

		//使用ajaxForm在火狐下提交不成功  使用ckeditor的数据提交不上去。
<%--			$('#addForm').ajaxForm(function(responseText, statusText, xhr, $form) { --%>
<%--				if(statusText=="success"){--%>
<%--					alert("保存成功！");--%>
<%--				}else{--%>
<%--					alert("保存失败,请联系管理员！");--%>
<%--				}--%>
<%--				//alert('status: ' + statusText + '\n\nresponseText: \n' + responseText + --%>
<%--		        //'\n\nThe output div should have already been updated with the responseText.');--%>
<%--            }); --%>
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
    
    <form id="addForm" action="news/add" method="post" class="niceform">
    	<fieldset>
	    	<legend>添加新闻</legend>
	    	<dl>
	        	<dt><label for="model.title">标题:</label></dt>
	            <dd><input type="text" name="model.title" size="32" maxlength="128" require="true" datatype="require" msg="标题不能为空" /></dd>
	        </dl>
	    	<dl>
	        	<dt><label for="model.dep">部门:</label></dt>
	            <dd><input type="text" name="model.dep" size="32" maxlength="128" require="true" datatype="require" msg="标题不能为空" /></dd>
	        </dl>
	        <dl>
				<dt>
					<label for="model.content">
						内容:
					</label>
				</dt>
				<dd>
					<textarea id="content" name="model.content" rows="5" cols="60" require="true" datatype="require" msg="标题不能为空" >
					</textarea>
				</dd>
			</dl>

			<script type="text/javascript">
				CKEDITOR.replace( 'content');
				$("#addForm").checkForm();
			</script>
	    	
    	</fieldset>
		<fieldset class="action">
	    	<span class="btnAdd">
	    		<input align="middle" id="submit" type="submit" value="添加文章" />
	    	</span>
		</fieldset>
    	
    </form>
    </div>
  </body>
</html>
