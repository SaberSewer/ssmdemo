<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 

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
        	var title= $("#gonggaoTitle").val();
			var text = editor.txt.html();
			json.title = title;
			json.context = text;
			$.ajax({
				url:"/admin/addGonggao.do",
				data: json,
				dataType: "json",
				type: "post",
				success: function (date){
					if(date.tag == "success"){
						alert("公告发布成功");
						location.href = "initGonggao.do"
					}
				},
				error: function (){
					alert("服务器被怪兽破坏了")
				}
			})
        })
       })
   </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/gonggaoAdd.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>公告添加</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						          标题：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" id="gonggaoTitle" name="gonggaoTitle" size="80"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        内容：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						         <div id="eitd"></div>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						      
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input id="tj" type="button" name="" value="提交公告">
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
