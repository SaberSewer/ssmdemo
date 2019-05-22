<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>

<body>
	<div class="left_row">
		<div class="list">
			<div class="list_bar">用户登录</div>
			<div class="list_content">
				<div id="div">
					<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	<div class="left_row">
		<div class="list">
			<div class="list_bar">网站公告</div>
			<div class="list_content">
				<div id="div">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">

						<c:forEach var="msg" items="${sessionScope.gonggao}">
						<tr>
							<td height="28" id="roll-line-1607838439" width="100%"><div
									class="" style="padding: 2px 0px;">
									<div class="f-left">
										<img src="<%=path%>/img/head-mark3.gif" align="middle"
											class="img-vm" border="0" /> <a
											href="<%=path%>/gonggao/show.do?gonggaoId=${msg.gonggaoId}"
											><span style="">
													${msg.gonggaoTitle}</span></a>
									</div>
									<div class="clear"></div>
								</div></td>
						</tr>
						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="left_row">
		<div class="list">
			<div class="list_bar">网站日历表</div>
			<div class="list_content">
				<jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>
