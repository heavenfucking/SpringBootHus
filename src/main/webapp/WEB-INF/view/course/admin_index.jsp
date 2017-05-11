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
                <%--<div class="col-sm-3">--%>
                    <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">增加</button>--%>
                <%--</div>--%>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table class="table table-bordered">
                        <caption>&nbsp;</caption>
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
                            <%--<th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>--%>
                        </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${course_lists}" var="i">
                               <tr>
                                   <td>${i['sno']}</td>
                                   <td>${i['name']}</td>
                                   <td>${i['teacherName']}</td>
                                   <td>${i['address']}</td>
                                   <td>${i['studyScore']}</td>
                                   <td>${i['studySlot']}</td>
                                   <td>${i['allQuato']}</td>
                                   <td>${i['choosedQuato']}</td>
                                   <%--<td>--%>
                                       <%--<div class="btn-group">--%>
                                           <%--<button class="btn btn-sm btn-primary" role="button" onclick="showUpdateModal(${i['id']})">修改</button>--%>
                                           <%--<a class="btn btn-sm btn-danger"  href="<%=basePath%>course/delete/${i['id']}">删除</a>--%>
                                       <%--</div>--%>
                                   <%--</td>--%>
                               </tr>
                           </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination pull-right">
                        <li><a href="#">上一页</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">下一页</a></li>
                    </ul>
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
                <h4 class="modal-title">
                    添加
                </h4>
            </div>
            <div class="modal-body">
                <form id="addForm" class="form-horizontal" role="form" action="<%=basePath%>course/add" method="POST">
                    <%--<div class="form-group">--%>
                        <%--<label  class="col-sm-offset-2 col-sm-2 control-label">课程编号</label>--%>
                        <%--<div class="col-sm-5">--%>
                            <%--<input name="sno" type="text" class="form-control" placeholder="课程编号">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">课程名称</label>
                        <div class="col-sm-5">
                            <input name="name" type="text" class="form-control" placeholder="请输入课程名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</label>
                        <div class="col-sm-5">
                            <select class="form-control" name="studyScore">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时</label>
                        <div class="col-sm-5">
                            <input type="number" name="studySlot" class="form-control" placeholder="请输入学时">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">上课地点</label>
                        <div class="col-sm-5">
                            <input type="text" name="address" class="form-control" placeholder="请输入上课地点">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">限定人数</label>
                        <div class="col-sm-5">
                            <input type="number" name="allQuato" class="form-control" placeholder="限定人数">
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
                <h4 class="modal-title" id="myModalLabel">
                    添加
                </h4>
            </div>
            <div class="modal-body">
                <form id="addForm" class="form-horizontal" role="form" action="<%=basePath%>course/add" method="POST">
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-5">
                            <input id="sno"name="sno" type="text" class="form-control" placeholder="课程编号" disabled>
                            <input id="id" name="id" type="hidden" class="form-control" placeholder="课程编号" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">课程名称</label>
                        <div class="col-sm-5">
                            <input id="name" name="name" type="text" class="form-control" placeholder="请输入课程名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</label>
                        <div class="col-sm-5">
                            <select class="form-control" name="studyScore" id="studyScore">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时</label>
                        <div class="col-sm-5">
                            <input type="number" id="studySlot" name="studySlot" class="form-control" placeholder="请输入学时">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">上课地点</label>
                        <div class="col-sm-5">
                            <input type="text" id ="address" name="address" class="form-control" placeholder="请输入上课地点">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-offset-2 col-sm-2 control-label">限定人数</label>
                        <div class="col-sm-5">
                            <input type="number" name="allQuato" id = "allQuato" class="form-control" placeholder="限定人数">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
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
            url : baseUrl+"course/info/"+id,
            dataType:"json",
            success : function(data) {
                $('#id').val(data.id);
                $('#sno').val(data.sno);
                $('#name').val(data.name);
                $('#studySlot').val(data.studySlot);
                $('#studyScore').val(data.studyScore);
                $('#address').val(data.address)
                $('#allQuato').val(data.allQuato);
                $('#updateModal').modal('show');
            }
        });
    }
    // 向后台提交数据 （更新）
    function sumbitUpdateForm() {
        $.ajax({
            type: "post",
            url: baseUrl + "course/update",
            data:{
                id: $('#id').val(),
                sno: $('#sno').val(),
                name: $('#name').val(),
                studySlot: $('#studySlot').val(),
                studyScore: $('#studyScore').val(),
                address: $('#address').val(),
                allQuato: $('#allQuato').val()
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
