<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>EmployList</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js" ></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <table class="table table-striped table-hover">
        <tr>
            <th>ID</th>
            <th>LASTNAME</th>
            <th>EMAIL</th>
            <th>BIRTH</th>
            <th>CREATETIME</th>
            <th>DEPARTMENTNAME</th>
            <th>操作<a href="toAdd">新增</a></th>
        </tr>

        <s:iterator value="#request.employList">
            <tr>
                <td>${id}</td>
                <td>${lastName}</td>
                <td>${email}</td>
                <td>${birth}</td>
                <td>${createTime}</td>
                <td>${departmentByDept.departmentName}</td>
                <td><a href="employDelete?id=${id}">刪除</a> <a href="toUpdate?id=${id}">修改</a></td>
            </tr>
        </s:iterator>

    </table>

</body>
</html>
