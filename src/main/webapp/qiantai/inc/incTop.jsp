<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <style type="text/css">
        .Header {background: url(<%=path %>/img/banner.jpg) #d10e00 repeat-x left top; height: 70px;width: 966px;}
        .HeaderTop {margin: 0px auto;}
     </style>
     
     <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
     <script type="text/javascript">
            function huiyuanzhongxin()
	        {
				     var url="<%=path %>/auser/index.jsp";
					 window.open(url);
			
	        }
	        function reg()
	        {
	                var url="<%=path %>/qiantai/userinfo/userReg.jsp";
	                var n="";
	                var w="480px";
	                var h="500px";
	                var s="resizable:no;help:no;status:no;scroll:yes";
				    openWin(url,n,w,h,s);
	        }
     </script>
  </head>
  
  <body>
        <div class="Header HeaderTop">
			<br/>
			<font style="font-size: 40px;color: white;font-weight: bolder;display: block;text-align: center;">
			      基于java的机票售票系统的设计与实现
			</font>
		</div>
		<div class="topmenu cbody1">
			<ul>
				 <li class="thisclass">
					<a href="<%=path %>/qiantai/default.jsp">系统首页</a>
				 </li>
				 <li class="thisclass">
					<a href="#" onclick="reg()">免费注册</a>
				 </li>
				 <li class="thisclass">
					<a href="#" onclick="huiyuanzhongxin()">会员中心</a>
				 </li>
				 <li class="thisclass">
					<a target="_blank" href="liuyan.do">留言板</a>
				 </li> 
			</ul>
		</div>
		<form id="searchForm" action="/search.do" name="for" method="post">
			<div class="topsearch">
				<div class="title"></div>
				    <table>
				       <tr>
				           <td>
				                 始发地：<input class="inputText" size="10" name="shifazhan" type="text"/>
				           </td>
				           <td>
				                 航班日期：<input class="inputText" size="10" name="piaoshijian" readonly="readonly" class="Wdate"  type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
				           </td>
				           <td>
				                 起飞时间断：<input class="inputText" size="10" name="startshijian" readonly="readonly" class="Wdate"  type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})"/>
				           </td>
				           <td>
				               --<input class="inputText" size="10" name="endshijian" readonly="readonly" class="Wdate"  type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})"/>
				           </td>
				           <td>
				               <input type="submit" value="search">
				           </td>
				       </tr>
				    </table>
				<div id="page_search_right">
					<script>
						<!--var day="";
						var month="";
						var ampm="";
						var ampmhour="";
						var myweekday="";
						var year="";
						mydate=new Date();
						myweekday=mydate.getDay();
						mymonth=mydate.getMonth()+1;
						myday= mydate.getDate();
						year= mydate.getFullYear();
						if(myweekday == 0)
						weekday=" 星期日 ";
						else if(myweekday == 1)
						weekday=" 星期一 ";
						else if(myweekday == 2)
						weekday=" 星期二 ";
						else if(myweekday == 3)
						weekday=" 星期三 ";
						else if(myweekday == 4)
						weekday=" 星期四 ";
						else if(myweekday == 5)
						weekday=" 星期五 ";
						else if(myweekday == 6)
						weekday=" 星期六 ";
						document.write(year+"年"+mymonth+"月"+myday+"日 "+weekday);
						//-->
					</script>
				</div>
				<div style="clear: both"></div>
			</div>
		</form>
  </body>
</html>
