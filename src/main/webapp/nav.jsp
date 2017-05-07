<%--
  Created by IntelliJ IDEA.
  User: zhh
  Date: 2017/5/5
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="navbar navbar-inverse navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/Admin/index.html" id="logo">高校学生选课系统
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a ><span class="glyphicon glyphicon-user">&nbsp;</span>${session_key_current_user_object.name}</a></li>
                <li><a href="#"<span class="glyphicon glyphicon-log-out">&nbsp;</span>退出</a></li>
            </ul>
        </div>
    </div>
</div>
