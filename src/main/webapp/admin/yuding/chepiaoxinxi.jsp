<%@ page language="java" pageEncoding="UTF-8"%>
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

<script language="javascript">
	
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
		</tr>
		<s:iterator value="#request.infoList" id="info">
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">${info.shifazhan}</td>
				<td bgcolor="#FFFFFF" align="center">${info.daodazhan}</td>
				<td bgcolor="#FFFFFF" align="center">${info.piaoshijian}</td>
				<td bgcolor="#FFFFFF" align="center">${info.startshijian}</td>
				<td bgcolor="#FFFFFF" align="center">${info.endshijian}</td>
				<td bgcolor="#FFFFFF" align="center">${info.piaojia}</td>
				<td bgcolor="#FFFFFF" align="center">${info.piaoshu}</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
