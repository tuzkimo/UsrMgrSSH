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
    <s:form action="editSave" method="POST" validate="true" theme="simple">
        <fieldset>
            <legend>user</legend>
            <s:hidden name="user.id" value="%{id}"/>
            <p>
                <label for="name">Name: </label>
                <s:textfield key="user.name" value="%{user.name}" id="name"/>
                <span><s:fielderror cssClass="error"><s:param>user.name</s:param></s:fielderror></span>
            </p>
            <p>
                <label for="password">Password: </label>
                <s:password key="user.password" value="%{user.password}" id="password"/>
                <span><s:fielderror cssClass="error"><s:param>user.password</s:param></s:fielderror></span>
            </p>
            <p>
                <label for="description">Description: </label>
                <s:textarea key="user.description" value="%{user.description}" id="description"/>
                <span><s:fielderror cssClass="error"><s:param>user.description</s:param></s:fielderror></span>
            </p>
            <p>
                <input class="btn out" type="submit" value="save">
            </p>
        </fieldset>
    </s:form>
    <p>
        <a class="abtn out" href="<s:url action="index"/>">Return</a>
    </p>
    <script src="<s:url value="/scripts/jquery-3.1.1.min.js"/>"></script>
    <script src="<s:url value="/scripts/validator.js"/>"></script>
</div>
</body>
</html>
