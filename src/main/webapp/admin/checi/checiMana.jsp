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
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />

<script language="javascript">
           function checiDel(checiId)
           {
               if(confirm('您确定删除吗？'))
               {
            	   var json = {};
             	  json.id = checiId;
                   $.ajax({
                 	  url: "/admin/deleteCheci.do",
                 	  data: json,
                 	  contextType:"application/json;charset=utf-8",
                 	  type:"post",
                 	  dataType:"json",
                 	  success: function (result){
                 		  if(result.msg == "isDelete"){
                 			  $("#" + checiId).remove();
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
           
           function checiAdd()
           {
                 var url="<%=path%>/admin/checi/checiAdd.jsp";
				 window.location.href=url;
           }
       </script>
</head>

<body leftmargin="2" topmargin="2" background='<%=path%>/img/allbg.gif'>
	<table width="98%" border="0" cellpadding="2" cellspacing="1"
		bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan=8 " background="<%=path%>/img/tbg.gif">&nbsp;航班维护&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="10%">始发地</td>
			<td width="10%">终点地</td>
			<td width="15%">航班日期</td>
			<td width="15%">起飞时间</td>
			<td width="15%">到达时间</td>
			<td width="12%">票价</td>
			<td width="13%">票数</td>
			<td width="15%">操作</td>
		</tr>
		<c:forEach items="${checi}" var="list">
			<tr id="${list.id }" align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">${list.shifazhan}</td>
				<td bgcolor="#FFFFFF" align="center">${list.daodazhan} <s:property
						value="#checi.daodazhan" />
				</td>
				<td bgcolor="#FFFFFF" align="center">${list.piaoshijian} <s:property
						value="#checi.piaoshijian" />
				</td>
				<td bgcolor="#FFFFFF" align="center">${list.startshijian} <s:property
						value="#checi.startshijian" />
				</td>
				<td bgcolor="#FFFFFF" align="center">${list.endshijian} <s:property
						value="#checi.endshijian" />
				</td>
				<td bgcolor="#FFFFFF" align="center">${list.piaojia} <s:property
						value="#checi.piaojia" />
				</td>
				<td bgcolor="#FFFFFF" align="center">${list.piaoshu} <s:property
						value="#checi.piaoshu" />
				</td>
				<td bgcolor="#FFFFFF" align="center"><a
					href="/admin/changeCheci.do?id=${list.id}">编辑</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onclick="checiDel(${list.id})"
					class="pn-loperator">删除</a></td>
			</tr>
		</c:forEach>
	</table>

	<table width='98%' border='0'
		style="margin-top: 8px; margin-left: 5px;">
		<tr>
			<td><input type="button" value="添加" style="width: 80px;"
				onclick="checiAdd()" /></td>
		</tr>
	</table>
</body>
</html>
