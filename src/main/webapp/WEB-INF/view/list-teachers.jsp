<%--
  Created by IntelliJ IDEA.
  User: michups
  Date: 18.07.17
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Teacher List</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2> Teachers</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">

            <input type="button" value="Add Teacher"
                   onclick="window.location.href='showFormAdd'; return false;"
            class="add-button">
            <input type="button" value="Go back"
                   onclick="window.location.href='home'; return false;"
                   class="add-button">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Main class</th>
                    <th>All classes</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="tempTeacher" items="${teachers}">
                    <c:url var="updateLink" value="/teacher/showFormForUpdate">
                        <c:param name="teacherId" value="${tempTeacher.teacherId}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/teacher/delete">
                        <c:param name="teacherId" value="${tempTeacher.teacherId}"/>
                    </c:url>
                    <tr>
                        <td>${tempTeacher.firstName}</td>
                        <td>${tempTeacher.lastName}</td>
                        <td>${tempTeacher.email}</td>
                        <td>${tempTeacher.mainClass}</td>
                        <td>${tempTeacher.grades}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                            onclick="if(!(confirm('Are you sure to delete this teacher?'))) return false">Delete</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>


</body>
</html>
