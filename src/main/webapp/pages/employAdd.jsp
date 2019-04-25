<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>employAdd</title>
</head>
<body>
    <s:debug></s:debug>
    <s:form action="employeeAdd" method="POST">
        <s:if test="id != null">
            <s:hidden name="id"></s:hidden>
        </s:if>
        <s:textfield name="lastName" label="lastName" ></s:textfield>
        <s:textfield name="email" label="email" ></s:textfield>
        <s:textfield name="birth" label="birth" ></s:textfield>
        <s:hidden name="createTime"></s:hidden>
        <s:select list="#request.departments" name="departmentByDept.id" label="Department" listValue="departmentName" listKey="id"></s:select>
        <s:submit value="提交"></s:submit>
    </s:form>
</body>
</html>
