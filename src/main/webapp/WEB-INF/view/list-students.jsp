<%--
  Created by IntelliJ IDEA.
  User: michups
  Date: 18.07.17
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Students</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2> Students</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">

            <input type="button" value="Add Student"
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
                    <th>Grade</th>
                    <th>Birth Date</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="tempStudent" items="${students}">
                    <c:url var="updateLink" value="/student/showFormForUpdate">
                        <c:param name="studentId" value="${tempStudent.studentId}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/student/delete">
                        <c:param name="studentId" value="${tempStudent.studentId}"/>
                    </c:url>
                    <tr>
                        <td>${tempStudent.firstName}</td>
                        <td>${tempStudent.lastName}</td>
                        <td>${tempStudent.email}</td>
                        <td>${tempStudent.gradeId}</td>
                        <td><fmt:formatDate value="${tempStudent.birthDate}" pattern="yyyy-MM-dd" /></td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                            onclick="if(!(confirm('Are you sure to delete this customer?'))) return false">Delete</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>


</body>
</html>
