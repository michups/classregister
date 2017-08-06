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
    <title>Save Grade</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2> Grades</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">

            <input type="button" value="Add Grade"
                   onclick="window.location.href='showFormAdd'; return false;"
            class="add-button">
            <input type="button" value="Go back"
                   onclick="window.location.href='home'; return false;"
                   class="add-button">
            <table>
                <tr>
                    <th>Number</th>
                    <th>Alphabet digit</th>
                    <th>Year</th>
                    <th>Teachers</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="tempGrade" items="${grades}">
                    <c:url var="updateLink" value="/grade/showFormForUpdate">
                        <c:param name="gradeId" value="${tempGrade.gradeId}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/grade/delete">
                        <c:param name="gradeId" value="${tempGrade.gradeId}"/>
                    </c:url>
                    <tr>
                        <td>${tempGrade.number}</td>
                        <td>${tempGrade.alfabetDigit}</td>
                        <td>${tempGrade.year}</td>
                        <td>${tempGrade.teachers}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                            onclick="if(!(confirm('Are you sure to delete this grade? \n' +
                             'Grade wont be deleted if student is assign to it!'))) return false">Delete</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>


</body>
</html>
