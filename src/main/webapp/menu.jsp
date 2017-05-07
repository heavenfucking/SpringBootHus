<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
    <li class="active">
        <a href="#">
            <i class="glyphicon glyphicon-th-large"></i>
            首页
        </a>
    </li>
    <c:forEach items="${session_key_system_menu_all}" var="menu">
        <li>
            <a href="#${menu.id}" class="nav-header collapsed" data-toggle="collapse">
                <i class="glyphicon glyphicon-cog"></i>
                ${menu.name}
                <span class="pull-right glyphicon glyphicon-chevron-down"></span>
            </a>
            <ul id="${menu.id}" class="nav nav-list collapse secondmenu" style="height: 0px;">
                <c:forEach items="${menu.childrenModule}" var="m">
                    <li><a href="<%=basePath%>${m.url}">${m.name}</a></li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
    <li>
        <a href="#">
            <i class="glyphicon glyphicon-fire"></i>
            关于系统
        </a>
    </li>
</ul>
