<%--
  Created by IntelliJ IDEA.
  User: zhh
  Date: 2017/5/4
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<script type="text/javascript">
    var baseUrl = "<%=basePath%>";
</script>

