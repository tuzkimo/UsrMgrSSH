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
                <th>photo</th>
                <th>operation</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="users">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="description"/></td>
                    <td><img src="<s:url value="/photos/%{photo}"/>" title="<s:property value="name"/>" alt="<s:property value="name"/>"/></td>
                    <td>
                        <a class="abtn" href="<s:url action="edit"><s:param name="id" value="id"/></s:url>">Edit</a>
                        <a class="abtn" href="<s:url action="upPhoto"><s:param name="id" value="id"/></s:url>">UpPhoto</a>
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
        <div class="pagination"></div>
        <s:debug/>
    </div>
    <script src="<s:url value="/scripts/jquery-3.1.1.min.js"/>"></script>
    <script>
        var pageNo = <s:property value="pageNo"/>;
        var pages = <s:property value="pages"/>;
        var pagination = $(".pagination");

        $(document).ready(function() {
            pagination.append('<a href="#" class="prev">Prev</a>');
            for (var i=1; i <= pages; i++ ) {
                pagination.append('<a href="/?pageNo=' + i + '" class="numlink">' + i + '</a>');
            }
            pagination.append('<a href="#" class="next">Next</a>');
            pagination.append('<div style="clear: both">');

            if (pageNo == 1) {
                $('.prev').hide();
            } else {
                $('.prev').attr("href","/?pageNo=" + (pageNo-1));
            }

            if (pageNo == pages) {
                $('.next').hide();
            } else {
                $('.next').attr("href","/?pageNo=" + (pageNo+1));
            }

            $('.numlink:eq('+(pageNo-1)+')').addClass('current');
        })
    </script>
</body>
</html>
