<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
			<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
		<script language="javascript">
         
	    	function getMoney(num){
	    		if(num.value > ${checiInfo.piaoshu}){
	    			alert("没这么多票")
	    			return
	    		}
	    			
	    		var a = num.value * $("#jiage").val();
	    		$("#money").html(a);
	    	}
        </script>
	</head>
	<body>
			<form action="/yuding/add.do" name="form1" method="post">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<th height="40" colspan="2" bgcolor="#FFFFFF" class="f12b-red"> 
							预定航班 :
						</th>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							航班信息：
						</td>
						
						<td width="80%" bgcolor="#FFFFFF">
							${checiInfo.id }
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							飞行路线：
						</td>
						
						<td width="80%" bgcolor="#FFFFFF">
							${checiInfo.shifazhan}-${checiInfo.daodazhan}
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							预定数量：
						</td>
						
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text"  size="10" onblur="getMoney(this)"  name="yudingShumu"/>
						    &nbsp;&nbsp;&nbsp;<span id="div1" style="font-size: 11px;">应付金额:<span id="money">${checiInfo.piaojia}</span></span>
						    <input hidden value="${checiInfo.piaojia}" id="jiage" />
						</td>
					</tr>
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							支付方式：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<select name="zhifufangshi" onchange="dd()">
							    <option value="票到付款">票到付款</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							<input type="hidden" name="checiId" id="checiId" value="${checiInfo.id}"/>
							<input type="hidden" name="userId" id="userId" value="${sessionScope.user.userId}"/>
							<input type="submit" value="确定"/>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
