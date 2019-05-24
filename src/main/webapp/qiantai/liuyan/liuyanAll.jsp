<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
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
<script src="/js/wangEditor.min.js"></script>
<script src="/js/jquery-3.4.1.js"></script>
   <script>
       $(document).ready(function (){
        var E = window.wangEditor;
        var editor = new E('#eitd');
		editor.customConfig.uploadImgServer = '<%=path%>/liuyan/upload.do';
		editor.customConfig.uploadImgMaxSize = 10 * 1024 * 1024;
		editor.customConfig.uploadImgLength = 10;
		editor.customConfig.uploadFileName = 'img';
		editor.customConfig.uploadImgHooks ={
			customInsert : function (insertImg, result, editor){
				var url = result.data;
				insertImg(url);
			}
		}
        editor.create();


        $("#tj").click(function (){
        	var json = {}
        	var title= $("#liuyanTitle").val();
			var text = editor.txt.html();
			json.title = title;
			json.context = text;
			$.ajax({
				url:"/liuyan/text.do",
				data: json,
				dataType: "json",
				type: "post",
				success: function (date){
					if(date.tag == 'success'){
						alert('留言成功')
						location.href = "/liuyan.do"	
					}
					
				},
				error: function (){
					alert("服务器遇见怪兽了")
				}
			})
        })
       })
   </script>
</head>

<BODY>
	<div class="body-box">
		<TABLE cellSpacing=1 cellPadding=4 width="100%" border=0>
			<c:forEach var="liuyan" items="${liuyanList }">
				<TR>
					<TD>
						<TABLE class=tpt width="100%" border=0>
							<TBODY>
								<TR bgColor=#cccccc>
									<TD align=middle width="10%"><STRONG>留言人：</STRONG></TD>
									<TD width="47%"><FONT color=#000000>&nbsp;${liuyan.liuyanUser }</FONT>
									</TD>
									<TD align=middle width="14%"><STRONG>留言时间：</STRONG></TD>
									<TD width="29%"><FONT color=#000000>&nbsp;${liuyan.liuyanDate }</FONT>
									</TD>
								</TR>
								<TR>
									<TD align=middle><STRONG>标题：</STRONG></TD>
									<TD colSpan=3><FONT color=#000000>&nbsp;${liuyan.liuyanTitle}</FONT>
									</TD>
								</TR>
								<TR>
									<TD vAlign=top align=middle><STRONG>内容： </STRONG></TD>
									<TD colSpan=3>${liuyan.liuyanContent}</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
			</c:forEach>
		</TABLE>
		<BR>
			<table border="0">
				<tr>
					<td style="font-size: 11px;">标题</td>
					<td><input type="text" id="liuyanTitle" size="50" /></td>
				</tr>
				<tr>
					<td style="font-size: 11px;">内容</td>
					<td>

						<div id="eitd"></div>
					</td>
				</tr>
				<tr>
					<td style="font-size: 11px;">&nbsp;</td>
					<td><input id="tj" type="button" name="" value="提交留言"></td>
				</tr>
			</table>
	</div>
</BODY>
</html>
