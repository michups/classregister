<%--
  Created by IntelliJ IDEA.
  User: michups
  Date: 18.07.17
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Grade manager</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/add-element-style.css" />" rel="stylesheet">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Grade manager</h2>
        </div>
    </div>


    <div id="container">
        <form:form action="saveGrade" modelAttribute="grade" method="POST">

            <form:hidden path="gradeId"/>

            <table>
                <tbody>
                <tr>
                    <td><label>Grade number:</label></td>
                    <td><form:input path="number"/></td>
                </tr>
                <tr>
                    <td><label>Alphabet digit:</label></td>
                    <td><form:input path="alfabetDigit"/></td>
                </tr>
                <tr>
                    <td><label>Year:</label></td>
                    <td><form:input path="year"/></td>
                </tr>
                <tr>
                    <td><label>Teachers:</label></td>

                    <td><form:checkboxes element="li" path="teachers" items="${teachers}"
                                                         itemValue="teacherId"/></td>

                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear; border;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/grade/list">Back to list</a>
        </p>
    </div>

</body>
</html>
