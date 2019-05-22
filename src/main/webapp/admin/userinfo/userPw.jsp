<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %> 
<% System.out.print(request.getSession().getAttribute("admin")); %>

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
		<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
        <script language="javascript">
            function check()
            {
       
            	
            	if($("#userPw1").val() != $("#userPw2").val()){
            		alert("两次输入的密码不匹配")
            		return;
            	}
                 var json = {};
                 json.userid = "${sessionScope.admin.userid}";
                 json.userpw = $("#userPw1").val();
                 
                 $.ajax({
                	 url : "/admin/changePassword.do",
                	 type: "post",
                	 dataType : "json",
                	 contextType:"application/json;charset=utf-8",
                	 data: json,
                	 success: function (result){
                		if(result.msg == "isChange"){
                			alert("修改成功，请重新登录")
                			top.location.href = "/admin/logout.do"
                		}
                		if(result.msg == "noChange"){
                			alert("与原密码不匹配")
                		}
                	 },
                	 error: function (){
                		 alert("出现了预期之外的异常");
                	 }
                	 
                 })
                 
            }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				<tr bgcolor="#EEF4EA">
				    <td colspan="2" background="<%=path %>/img/wbg.gif" class='title'><span>密码修改</span></td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				         登录名：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="text" value="${sessionScope.admin.username}" id="username" size="20" disabled="disabled"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        原密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="password" name="userPw" id="userPw" size="22"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				         新密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="password" id="userPw1" name="userpw" size="22"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        确认密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				           <input type="password" name="userpw1" id="userPw2" size="22"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        &nbsp;
				    </td>
			        <td width="75%" bgcolor="#FFFFFF">
			             <input type="button" value="修改" onclick="check()"/>
			             &nbsp;&nbsp;&nbsp;
			             <input type="reset" value="重置"/>
			             <img id="indicator" src="<%=path %>/img/loading32.gif" alt="Loading..." style="display:none"/>
			        </td>
				</tr>
			</table>
   </body>
</html>
