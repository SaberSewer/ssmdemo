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
<script language="JavaScript" src="<%=path%>/js/public.js"
	type="text/javascript"></script>
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script language="javascript">
           function yudingDel(yudingId)
           {
               if(confirm('您确定删除吗？'))
               {

            	   var json = {};
             	  json.id = yudingId;
                   $.ajax({
                 	  url: "/admin/deleteYuding.do",
                 	  data: json,
                 	  contextType:"application/json;charset=utf-8",
                 	  type:"post",
                 	  dataType:"json",
                 	  success: function (result){
                 		  if(result.msg == "isDelete"){
                 			  $("#" + yudingId).remove();
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
           function yudingShouli(yudingId, userId)
           {
               if(confirm('您确定受理该订单吗？'))
               {
                   window.location.href="/admin/shouli.do?userId="+userId+"&yudingId=" + yudingId;
               }
           }
           
           function chepiaoxinxi(checiId)
	        {
	             location.href = "/admin/checiInfo.do?id="+checiId
	        }
	        
	        
	        function userxinxi(userId)
	        {
	        	location.href = "/admin/userInfo.do?id="+userId
	        }
           
       </script>
</head>

<body leftmargin="2" topmargin="2" background='<%=path%>/img/allbg.gif'>
	<table width="98%" border="0" cellpadding="2" cellspacing="1"
		bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan=7 " background="<%=path%>/img/tbg.gif">&nbsp;航班预定&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="16%">预定时间</td>
			<td width="13%">预定航班</td>
			<td width="13%">预定用户</td>
			<td width="10%">预定数量</td>
			<td width="13%">支付方式</td>
			<td width="13%">状态</td>
			<td width="22%">操作</td>
		</tr>
		<c:forEach var="yuding" items="${yudingList}">
			<tr id="${yuding.yudingId}" align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">${yuding.yudingShijian}</td>
				<td bgcolor="#FFFFFF" align="center"><a href="#"
					onclick="chepiaoxinxi(${yuding.checiId})">航班信息</a></td>
				<td bgcolor="#FFFFFF" align="center"><a href="#"
					onclick="userxinxi(${yuding.userId})">用户信息</a></td>
				<td bgcolor="#FFFFFF" align="center">${yuding.yudingShumu}</td>
				<td bgcolor="#FFFFFF" align="center">${yuding.zhifufangshi}</td>
				<td bgcolor="#FFFFFF" align="center" style="color: red"><c:if
						test="${yuding.yudingZhuantai == 0}">
					   
					        未受理
					    </c:if> <c:if test="${yuding.yudingZhuantai == 1}">
					   
					       已受理
					    </c:if></td>
				<td bgcolor="#FFFFFF" align="center"><a href="#"
					onclick="yudingDel(${yuding.yudingId})" class="pn-loperator">删除订单</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${yuding.yudingZhuantai == 0}">
						<a href="#" onclick="yudingShouli(${yuding.yudingId}, ${yuding.userId})"
							class="pn-loperator">受理订单</a>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
