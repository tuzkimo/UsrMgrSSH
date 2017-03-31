<%--
  Created by IntelliJ IDEA.
  User: tuzkimo
  Date: 2017-03-21
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>User Manager</title>
    <link href="<s:url value="/style/main.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="main">
        <h2 class="title"><span>User Manager</span></h2>
        <s:if test="users.size > 0">
        <table class="tab">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>operation</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="users">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="description"/></td>
                    <td>
                        <a class="abtn" href="<s:url action="edit"><s:param name="id" value="id"/></s:url>">Edit</a>
                        <a class="abtn" href="<s:url action="delete"><s:param name="id" value="id"/></s:url>">Delete</a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        </s:if>
        <p>
            <a class="abtn" href="<s:url action="add"/>">add</a>
        </p>
        <s:debug/>
    </div>
</body>
</html>
