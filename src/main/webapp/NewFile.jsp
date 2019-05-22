<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/admin/test.do">
		<input type="text" name="username">
		<input type="password" name="userpw">
		记住我：<input type="checkbox" value="true" name="remember">
		<input type="submit" value="提交">
	</form>
</body>
</html>