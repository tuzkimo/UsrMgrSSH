<%--
  Created by IntelliJ IDEA.
  User: tuzkimo
  Date: 2017-03-24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Edit User</title>
    <link href="<s:url value="/style/main.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">
    <h2 class="title"><span>Edit User</span></h2>
    <s:form action="editSave">
        <s:hidden name="user.id" value="%{id}"/>
        <s:textfield label="Name" name="user.name" value="%{user.name}"/>
        <s:password label="Password" name="user.password" value="%{user.password}"/>
        <s:textarea label="Description" name="user.description" value="%{user.description}"/>
        <s:submit class="btn out"/>
    </s:form>
    <p>
        <a class="abtn out" href="<s:url action="index"/>">Return</a>
    </p>
    <s:debug/>
</div>
</body>
</html>
