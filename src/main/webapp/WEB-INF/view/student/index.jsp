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
    <script src="<%=basePath%>js/jquery.min.js"></script>
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
                <div class="col-sm-3">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">增加</button>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table class="table table-bordered">
                        <caption>&nbsp;</caption>
                        <thead>
                        <tr>
                            <th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
                            <th>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</th>
                            <th>院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系</th>
                            <th>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</th>
                            <th>入学年份</th>
                            <th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
                        </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${student_lists}" var="i">
                               <tr>
                                   <td>${i['sno']}</td>
                                   <td>${i['name']}</td>
                                   <td>${i['department']}</td>
                                   <td>${i['prefession']}</td>
                                   <td>${i['grade']}</td>
                                   <td>
                                       <div class="btn-group">
                                           <button class="btn btn-sm btn-primary" role="button" onclick="showUpdateModal(${i['id']})">
                                               修改
                                           </button>
                                           <a class="btn btn-sm btn-danger" href="<%=basePath%>student/delete/${i['id']}">删除</a>
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
<!-- 添加 模态框（Modal） -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加
                </h4>
            </div>
            <div class="modal-body">
                <form id="addForm" class="form-horizontal" role="form" action="<%=basePath%>student/add" method="POST">
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>
                        <div class="col-sm-5">
                            <input name="sno" type="text" class="form-control" placeholder="请输入学号">
                            <input name="type" type="hidden" class="form-control" value="1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
                        <div class="col-sm-5">
                            <input type="text" name="name" class="form-control" placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">院系专业</label>
                        <div class="col-sm-5">
                            <select class="form-control" name="departmentId">
                                <c:forEach items="${department_lists}" var="i">
                                    <option value="${i.id}">${i.department}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">初始密码</label>
                        <div class="col-sm-5">
                            <input type="text" name="password" class="form-control" placeholder="请输入密码" value="123456">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="sumbitForm()">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>
<!-- 更新 模态框（Modal） -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    更新
                </h4>
            </div>
            <div class="modal-body">
                <form id="updateForm" class="form-horizontal" role="form" action="<%=basePath%>student/update" method="POST">
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>
                        <div class="col-sm-5">
                            <input name="sno" type="text" class="form-control" placeholder="请输入学号" id = "sno">
                            <input name="id" type="hidden" class="form-control" id="id">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
                        <div class="col-sm-5">
                            <input type="text" name="name" class="form-control" placeholder="请输入名字" id="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">院系专业</label>
                        <div class="col-sm-5">
                            <select class="form-control" name="departmentId" id="departmentId">
                                <c:forEach items="${department_lists}" var="i">
                                    <option value="${i.id}">${i.department}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">初始密码</label>
                        <div class="col-sm-5">
                            <input type="text" name="password" class="form-control" placeholder="请输入密码" id="password" disabled>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="sumbitUpdateForm()">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>
<script>
     // 提交表单
     function sumbitForm() {
         $("#addForm").submit();
     }
     // 显示更新 模态框
     function showUpdateModal(id) {
         $.ajax({
             type : "get",
             url : baseUrl+"student/info/"+id,
             dataType:"json",
             success : function(data) {
                 $('#id').val(data.id);
                 $('#sno').val(data.sno);
                 $('#name').val(data.name);
                 $('#departmentId').val(data.departmentId);
                 $('#password').val(data.password);
                 $('#updateModal').modal('show');
             }
         });
     }
    // 向后台提交数据 （更新）
    function sumbitUpdateForm() {
        $.ajax({
            type: "post",
            url: baseUrl + "student/update",
            data:{
                id: $('#id').val(),
                sno: $('#sno').val(),
                name: $('#name').val(),
                departmentId: $('#departmentId').val(),
                password: $('#password').val()
            },
            dataType: "json",
            success: function (data) {
                $('#updateModal').modal('hide');
                setTimeout(function () {
                    location.reload();
                }, 200);

            }
        });
    }
</script>
</body>
</html>
