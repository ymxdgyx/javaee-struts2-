<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
登录界面
<form action="user!login.action" method = "post">
	用户名：<input name = "name" type = "text">
	密码：<input name = "password" type = "text">
	邮箱：<input name = "email" type = "text">
	<input name = "submit" type = "submit" value = "登陆">
</form>
</body>
</html>