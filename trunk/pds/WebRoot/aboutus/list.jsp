<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.pds.model.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>关于我们</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px;
	cursor:pointer;
}

.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}

a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.STYLE7 {
	font-size: 12
}
-->
</style>
		<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>

		<link rel="stylesheet"
			href="../jqueryui/css/ui-lightness/jquery-ui-1.8.6.custom.css">
		</link>
		<script type="text/javascript" src="../jqueryui/ui/jquery.ui.core.js"></script>
		<script type="text/javascript" src="../jqueryui/ui/jquery-ui-1.8.6.custom.js"></script>
		<script type="text/javascript" src="../jqueryui/ui/jquery.ui.dialog.js"></script>
		<script type="text/javascript" src="../jqueryui/ui/jquery.ui.widget.js"></script>
		<script type="text/javascript" src="../jqueryui/ui/jquery.ui.button.js"></script>
		
		<%--<link rel="stylesheet" href="../demos.css"></link>--%>
		<script type="text/javascript">
	$(function() {
		$("#btnAdd").button(); //
	});
	</script>
		<script type="text/javascript">
	
	var url = "../aboutus/list.action?pageNo=";
	//转向用户输入的那一页
	function turnToPage(){
		var pageNo = getInputPageNo();
		
		if(!pageNo){
			return false;
		}else{
			window.location=url+pageNo; 
		}
	}
	//转向某一页
	function turnToPageByPageNo(pageNo){
		if(pageNo == false){
			return false;
		}else{
			window.location=url+pageNo; 
		}
	}
	//转向第一页
	function turnToFirstPage(){
		if(getCurrentPageNo() != 1){
			turnToPageByPageNo(1);
		}
	}
	//跳到前一页
	function turnToPrePage(){
		var currentPageNo = getCurrentPageNo();
		if(currentPageNo == "undefined" || currentPageNo <= 1 || isNaN(currentPageNo)){
			return false;
		}else{
			turnToPageByPageNo(currentPageNo-1);
		}
	}
	//跳到下一页
	function turnToNextPage(){
		var currentPageNo = getCurrentPageNo();
		var pageCount = getPageCount();
		if(currentPageNo == "undefined" || pageCount == "undefined" || isNaN(currentPageNo) || currentPageNo >= pageCount){
			return false;
		}else{
			turnToPageByPageNo(currentPageNo+1);
		}
	}
	//转到最后一页
	function turnToLastPage(){
		if(getCurrentPageNo() != getPageCount()){
			turnToPageByPageNo(getPageCount());
		}
	}
	
	//得到当前页码
	function getCurrentPageNo(){
		return parseInt($("#currentPageNo").text()); 
	}
	//得到总页数
	function getPageCount(){
		return parseInt($("#pageCount").text());
	}
	
	//得到用户输入的要转向的页数
	function getInputPageNo(){
		var value = $("#pageNo").val();
		if(value == "" || value == "undefined" || isNaN(value) || value < 0 ){
			return false;
		} else{
			return value;
		}
	}


	var deleteConfirmation = $('<div style="padding:5px;width:400px;height:200px;">确定要删除吗？</div>');
	/////////// delete record //////////////
	function showDeleteConfirmation(id){
		deleteConfirmation.dialog({
			//modal:true,
		    title:'确认删除？',
		    buttons:{
		    	'删除':function(){
					deleteRecord(id);
		        },
		        '取消':function(){
		            $(this).dialog('close');
		        }
		    }
		});
		return false;
	}
	
	function deleteRecord(id){
		window.location =  "delete?id="+id;
	}

	
</script>


	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="30">
								<img src="images/tab_03.gif" width="15" height="30" />
							</td>
							<td width="1101" background="images/tab_05.gif">
								<img src="images/311.gif" width="16" height="16" />
								<span class="STYLE4">"关于我们"管理</span>
							</td>
							<td width="281" background="images/tab_05.gif">
								<table border="0" align="right" cellpadding="0" cellspacing="0">
									<tr>
										<td width="60">
											<table width="87%" border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td class="STYLE1">
														<div align="center">
															<input type="checkbox" checked="unchecked" name="checkedAll" value="checkbox" />
														</div>
													</td>
													<td class="STYLE1">
														<div align="center">
															全选
														</div>
													</td>
												</tr>
											</table>
										</td>


									</tr>
								</table>
							</td>
							<td width="14">
								<img src="images/tab_07.gif" width="14" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<!-- competency=Hello world0, contact=联系方式0, history=历史0, id=1, introduction=introduction0 -->
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">
								&nbsp;
							</td>
							<td bgcolor="#f3ffe3">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="1" bgcolor="#c0de98">
									<tr>
										<td width="6%" height="26" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												选择
											</div>
										</td>
										<td width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												序号
											</div>
										</td>
										<td width="24%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												简介
											</div>
										</td>
										<td width="10%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												职能
											</div>
										</td>
										<td width="14%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												历史
											</div>
										</td>
										<td width="24%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2">
												联系方式
											</div>
										</td>
										<td width="7%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2">
												编辑
											</div>
										</td>
										<td width="7%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2">
												删除
											</div>
										</td>
									</tr>
									<s:iterator value="page.list" status="au">
										<tr>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE1">
													<input name="checkbox" type="checkbox" class="STYLE2"
														value="checkbox" />
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<s:property value="id" />
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
													<s:property value="introduction" />
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
													<s:property value="competency" />
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
													<s:property value="history" />
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center">
													<a href="#"><s:property value="contact" />
													</a>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE2"><img src="images/037.gif"
															width="9" height="9" />
													</span><span class="STYLE1"> [</span><a
														href="edit?id=<s:property value='id' />">编辑</a><span
														class="STYLE1">]</span>
												</div>
											</td>
<%--											delete?id=<s:property value='id'/>--%>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE2"><img src="images/010.gif"
															width="9" height="9" />
													</span><span class="STYLE2"> </span><span class="STYLE1">[</span><span class="STYLE1"
														onclick="showDeleteConfirmation('<s:property value='id'/>')">删除</span><span
														class="STYLE1">]</span>
												</div>
											</td>
										</tr>
									</s:iterator>


								</table>
							</td>
							<td width="9" background="images/tab_16.gif">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="29">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="29">
								<img src="images/tab_20.gif" width="15" height="29" />
							</td>
							<td background="images/tab_21.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="40%" height="29" nowrap="nowrap">
											<span class="STYLE1">共<s:property
													value="page.totalCount" /> 条纪录，当前第 <span id="currentPageNo"><s:property
														value="page.pageNo" />
											</span>/<span id="pageCount"><s:property
														value="page.pageCount" />
											</span>页，每页<s:property value="page.pageSize" />条纪录</span>
										</td>
										<td width="60%" valign="top" class="STYLE1">
											<div align="right">
												<table width="352" height="20" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="62" height="22" valign="middle">
															<div align="right">
																<img src="images/first.gif" width="37" height="15"
																	onclick="turnToFirstPage();" />
															</div>
														</td>
														<td width="50" height="22" valign="middle">
															<div align="right">
																<img src="images/back.gif" width="43" height="15"
																	onclick="turnToPrePage();" />
															</div>
														</td>
														<td width="54" height="22" valign="middle">
															<div align="right">
																<img src="images/next.gif" width="43" height="15"
																	onclick="turnToNextPage();" />
															</div>
														</td>
														<td width="49" height="22" valign="middle">
															<div align="right">
																<img src="images/last.gif" width="37" height="15"
																	onclick="turnToLastPage();" />
															</div>
														</td>
														<td width="59" height="22" valign="middle">
															<div align="right">
																转到第
															</div>
														</td>
														<td width="25" height="22" valign="middle">
															<span class="STYLE7"> <input id="pageNo"
																	name="textfield" type="text" class="STYLE1"
																	style="height: 10px; width: 25px;" size="5" /> </span>
														</td>
														<td width="23" height="22" valign="middle">
															页
														</td>
														<td width="30" height="22" valign="middle">
															<img src="images/go.gif" width="37" height="15"
																onclick="turnToPage('pageNo');" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</table>
							</td>
							<td width="14">
								<img src="images/tab_22.gif" width="14" height="29" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<div>
			<a id="btnAdd" href="toAdd.action">新增一条记录</a>
		</div>
	</body>
</html>
