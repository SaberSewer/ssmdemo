<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<%=path%>/css/woncore.css" type="text/css"></link>
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
function del(liuyanoId){
	   var json = {};
	  json.id = liuyanoId;
     $.ajax({
   	  url: "/admin/deleteLiuyan.do",
   	  data: json,
   	  contextType:"application/json;charset=utf-8",
   	  type:"post",
   	  dataType:"json",
   	  success: function (result){
   		  if(result.msg == "isDelete"){
   			  alert("删除成功");
   			  $("#" + liuyanoId).remove();
   		  }else{
   			  alert("删除失败");
   		  }
   	  },
   	  error: function (){
   		  alert("出现了一个预期之外的错误");
   	  }
     })
}
</script>
</head>

<BODY>
	<div class="body-box">
		<TABLE cellSpacing=1 cellPadding=4 width="100%" border=0>
			<c:forEach var="liuyan" items="${liuyanList}">
				<TR id="${liuyan.liuyanId}">
					<TD>
						<TABLE class=tpt width="100%" border=0>
							<TBODY>
								<TR bgColor=#cccccc>
									<TD align=middle width="10%"><STRONG>留言人：</STRONG></TD>
									<TD width="47%"><FONT color=#000000>&nbsp;${liuyan.liuyanUser}</FONT>
									</TD>
									<TD align=middle width="14%"><STRONG>留言时间：</STRONG></TD>
									<TD width="29%"><FONT color=#000000>&nbsp;${liuyan.liuyanDate}</FONT>
										&nbsp;&nbsp;&nbsp;&nbsp; <a style="color: red" href="#"
										onclick="del(${liuyan.liuyanId})">删除</a></TD>
								</TR>
								<TR>
									<TD align=middle><STRONG>标题：</STRONG></TD>
									<TD colSpan=3><FONT color=#000000>&nbsp;${liuyan.liuyanTitle}</FONT>
									</TD>
								</TR>
								<TR>
									<TD vAlign=top align=middle><STRONG>内容：</STRONG></TD>
									<TD colSpan=3>${liuyan.liuyanContent}</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
			</c:forEach>
		</TABLE>
	</div>
</BODY>
</html>
