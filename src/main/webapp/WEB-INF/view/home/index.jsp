<%--
  Created by IntelliJ IDEA.
  User: zhh
  Date: 2017/5/4
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/base.jsp" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="<%=basePath%>bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/leftMenu.css" rel="stylesheet">
    <script src="<%=basePath%>/js/jquery.min.js"></script>
    <script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<%@include file="/nav.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">
            <%@include file="/menu.jsp"%>
        </div>
        <div class="col-sm-10">
            主窗口
        </div>
    </div>
</div>
<script>
</script>
</body>
</html>
