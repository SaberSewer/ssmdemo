<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>

<script language="javascript">
           function userDel(userId)
           {
               if(confirm('您确定删除吗？'))
               {
            	   var json = {};
             	  json.id = userId;
                   $.ajax({
                 	  url: "/admin/deleteUser.do",
                 	  data: json,
                 	  contextType:"application/json;charset=utf-8",
                 	  type:"post",
                 	  dataType:"json",
                 	  success: function (result){
                 		  if(result.msg == "isDelete"){
                 			  $("#" + userId).remove();
                 		  }else{
                 			  alert("删除失败");
                 		  }
                 	  },
                 	  error: function (){
                 		  alert("出现了一个预期之外的错误");
                 	  }
                   })
               }
           }
       </script>
</head>

<body leftmargin="2" topmargin="2" background='<%=path%>/img/allbg.gif'>
	<table width="98%" border="0" cellpadding="2" cellspacing="1"
		bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="12" background="<%=path%>/img/tbg.gif">&nbsp;注册用户维护&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="8%">ID</td>
			<td width="8%">用户名</td>
			<td width="8%">密码</td>
			<td width="8%">真实姓名</td>
			<td width="10%">住址</td>
			<td width="8%">性别</td>
			<td width="10%">联系方式</td>
			<td width="8%">E-mail</td>
			<td width="8%">QQ</td>
			<td width="8%">会员等级</td>
			<td width="8%">积分</td>
			<td width="8%">操作</td>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr id="${user.userId }" align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">${user.userId }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userName }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userPw }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userRealname }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userAddress }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userSex }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userTel }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userEmail }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userQq }</td>
				<td bgcolor="#FFFFFF" align="center">${user.userMan }<c:if
						test="${user.userOne6 < 5}">
					        普通会员</c:if> <c:if
						test="${user.userOne6 >= 5 && user.userOne6 < 10}">
					       黄金会员</c:if> <c:if test="${user.userOne6 >10}">
					        钻石会员</c:if>
				</td>
				<td bgcolor="#FFFFFF" align="center">${user.userOne6 }</td>
				<td bgcolor="#FFFFFF" align="center"><a href="#"
					onclick="userDel(${user.userId })" class="pn-loperator">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
