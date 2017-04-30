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
    <title>Upload Photo</title>
    <link href="<s:url value="/style/main.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">
    <h2 class="title"><span>Upload Photo</span></h2>
    <form action="<s:url value="/upPhotoSave"/>" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Photo</legend>
            <s:hidden name="id" value="%{id}"/>
            <p>
                <label>Name: </label><s:property value="user.name"/>
            </p>
            <p>
                <label>Description: </label><s:property value="user.description"/>
            </p>
            <p>
                <label for="photo">Photo: </label>
                <input type="file" name="photo" id="photo">
            </p>
            <p>
                <input class="btn out" type="submit" value="upload"/>
            </p>
        </fieldset>
    </form>
    <p class="error"><s:property value="message"/></p>
    <p>
        <a class="abtn out" href="<s:url action="index"/>">Return</a>
    </p>
    <s:debug/>
</div>
</body>
</html>
