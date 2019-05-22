<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
        <script language="javascript">
           function adminDel(userId)
           {
               if(confirm('您确定删除吗？'))
               {
            	  var json = {};
            	  json.id = userId;
                  $.ajax({
                	  url: "/admin/deleteAdmin.do",
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
           
           function adminAdd()
           {
                 var url="/admin/admin/adminAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/img/tbg.gif">&nbsp;管理员---管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="25%">ID</td>
					<td width="25%">用户名</td>
					<td width="25%">密码</td>
					<td width="25%">操作</td>
		        </tr>	
		        <c:forEach var="list" items="${adminLits}">
				<tr id="${list.userid}" align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="center">
					${list.userid}
	
					</td>
					<td width="25%" bgcolor="#FFFFFF" align="center">
					${list.username}
		
					</td>
					<td width="25%" bgcolor="#FFFFFF" align="center">
					${list.userpw}

					</td>
					<td width="25%" bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="adminDel(${list.userid})" class="pn-loperator">删除</a>
					</td>
				</tr>
				</c:forEach>
			
			</table>
			
			<table width="98%"  border=" 0"style="margin-top:8px; margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="adminAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
