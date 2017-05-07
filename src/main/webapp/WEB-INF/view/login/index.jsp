<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/base.jsp" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>登录</title>
	<link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="<%=basePath%>css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form class="form-signin" action="<%=basePath%>user/login" method="post">
		<h2 class="form-signin-heading">高校学生选课系统</h2>
		<label class="sr-only">用户名</label>
		<input type="text" class="form-control" placeholder="用户名" required name="sno">
		<label class="sr-only">密码</label>
		<input type="password" class="form-control" placeholder="密码" required name="password">
		<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
	</form>
</div>
</body>
</html>
