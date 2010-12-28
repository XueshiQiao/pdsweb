<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
﻿<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>平顶山学院自律与监督委员会</title>
		
		<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background-color: #1D3647;
		}
		-->
		</style>

		<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="../js/json2.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#submit").click(function (){
					if($("#username").val().trim() =="" || $("#password").val().trim() == ""){
						alert("用户名或密码不能为空！");
						return false;
					}
					
					$.post("login.action", //服务器要接受的url
							{
								username:$("#username").val(),
								password:$("#password").val()
							}, //传递的参数		
							function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
								if(data.result == 'success'){
									alert("登录成功！");
									window.location="index";
								}else if(data.result == 'fail'){
									alert("用户名或密码错误，请重试！");
								}else if(data.result='isNull'){
									alert("用户名和密码不能为空");
								}
								//alert(data.user.username);
								//alert(data.user.password);
								//alert(data.au.history);
								//var aboutUs = data.au;
								//var obj = JSON.parse(data.au);//eval("("+data+")");	//包数据解析为json 格式  
								//$('#result').html(aboutUs.id + "," + aboutUs.history);
							}, 'json' //数据传递的类型  json
					);
					return false;
				});
			});
		</script>


<link href="images/skin.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="top"><img src="images/logo.png" width="279" height="68"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>111</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>22222</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>3333</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"><img src="images/icon-demo.gif" width="16" height="16"><a href="" target="_blank" class="left_txt3"> 123</a> </td>
                      <td width="35%"><img src="images/icon-login-seaver.gif" width="16" height="16"><a href="" class="left_txt3">456</a></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"><span class="login_txt_bt">平顶山学院自律与监督委员会后台登陆</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="middle"><form name="myform" action="index.html" method="post">
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">

                          <tr>
                            <td width="13%" height="38" class="top_hui_text"><span class="login_txt">用户名： </span></td>
                            <td height="38" colspan="2" class="top_hui_text"><input id="username" name="user.username" class="editbox4" value="" size="20">                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="top_hui_text"><span class="login_txt">密码： </span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input id="password" class="user.password" type="password" size="20" name="password">
                              <img src="images/luck.gif" width="19" height="18"> </td>
                          </tr>
                          <tr>
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" ><input name="Submit" id="submit" type="submit" class="button" id="Submit" value="登录"> </td>
                            <td width="67%" class="top_hui_text"><input name="cs" type="button" class="button" id="cs" value="重置" onClick="showConfirmMsg1()"></td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="images/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">Copyright &copy; 2009-2010 www.865171.cn</span></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
