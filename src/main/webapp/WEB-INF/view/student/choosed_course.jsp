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
                            <th>授课教师</th>
                            <th>上课地点</th>
                            <th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</th>
                            <th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时</th>
                            <th>限定人数</th>
                            <th>已选人数</th>
                            <th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${unchoosed_course_lists}" var="i">
                            <tr>
                                <td>${i['sno']}</td>
                                <td>${i['name']}</td>
                                <td>${i['teacherName']}</td>
                                <td>${i['address']}</td>
                                <td>${i['studyScore']}</td>
                                <td>${i['studySlot']}</td>
                                <td>${i['allQuato']}</td>
                                <td>${i['choosedQuato']}</td>
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
                            <th>授课教师</th>
                            <th>上课地点</th>
                            <th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</th>
                            <th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时</th>
                            <th>限定人数</th>
                            <th>已选人数</th>
                            <th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${choosed_course_lists}" var="i">
                            <tr>
                                <td>${i['sno']}</td>
                                <td>${i['name']}</td>
                                <td>${i['teacherName']}</td>
                                <td>${i['address']}</td>
                                <td>${i['studyScore']}</td>
                                <td>${i['studySlot']}</td>
                                <td>${i['allQuato']}</td>
                                <td>${i['choosedQuato']}</td>
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
