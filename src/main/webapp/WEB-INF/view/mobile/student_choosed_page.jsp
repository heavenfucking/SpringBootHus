<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhh
  Date: 2017/5/10
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/base.jsp"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title></title>
    <link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/leftMenu.css" rel="stylesheet">
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">在线教学质量评价系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        个人信息<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">修改密码</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        选课管理<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>wx_course/stulist">学生选课</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <br>
            <div class="row">
                <div class="col-sm-3">
                    <form style="margin: 0px">
                        <div class="input-group">
                            <input type="text" class="form-control">
                               <span class="input-group-btn">
                                   <button class="btn btn-info" type="button">搜索</button>
                        </span>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table class="table table-bordered">
                        <caption>
                        </caption>
                        <thead>
                        <tr>
                            <th>课程编号</th>
                            <th>课程名称</th>
                            <%--<th>授课教师</th>--%>
                            <%--<th>上课地点</th>--%>
                            <%--<th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</th>--%>
                            <%--<th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时</th>--%>
                            <%--<th>限定人数</th>--%>
                            <%--<th>已选人数</th>--%>
                            <th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${unchoosed_course_lists}" var="i">
                            <tr>
                                <td>${i['sno']}</td>
                                <td>${i['name']}</td>
                                <%--<td>${i['teacherName']}</td>--%>
                                <%--<td>${i['address']}</td>--%>
                                <%--<td>${i['studyScore']}</td>--%>
                                <%--<td>${i['studySlot']}</td>--%>
                                <%--<td>${i['allQuato']}</td>--%>
                                <%--<td>${i['choosedQuato']}</td>--%>
                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-sm btn-primary" role="button"
                                           href="<%=basePath%>student/choose/course?id=${i['id']}">选课</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination pull-right">
                        <li><a href="#">上一页</a></li>
                        <li><a href="#">下一页</a></li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table class="table table-bordered">
                        <caption>
                        </caption>
                        <thead>
                        <tr>
                            <th>课程编号</th>
                            <th>课程名称</th>
                            <%--<th>授课教师</th>--%>
                            <%--<th>上课地点</th>--%>
                            <%--<th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</th>--%>
                            <%--<th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时</th>--%>
                            <%--<th>限定人数</th>--%>
                            <%--<th>已选人数</th>--%>
                            <th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${choosed_course_lists}" var="i">
                            <tr>
                                <td>${i['sno']}</td>
                                <td>${i['name']}</td>
                                <%--<td>${i['teacherName']}</td>--%>
                                <%--<td>${i['address']}</td>--%>
                                <%--<td>${i['studyScore']}</td>--%>
                                <%--<td>${i['studySlot']}</td>--%>
                                <%--<td>${i['allQuato']}</td>--%>
                                <%--<td>${i['choosedQuato']}</td>--%>
                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-sm btn-danger" role="button"
                                           href="<%=basePath%>student/unchoose/course?id=${i['id']}">退选</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>