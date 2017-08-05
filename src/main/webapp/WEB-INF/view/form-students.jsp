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
    <title>Save Student</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/add-customer-style.css" />" rel="stylesheet">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Student manager</h2>
    </div>
</div>


<div id="container">
    <h3>Save Student</h3>
    <form:form action="saveStudent" modelAttribute="student" method="POST">

        <form:hidden path="studentId"/>

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label>Birth Date:</label></td>
                <td><form:input path="birthDate"/></td>
            </tr>
            <tr>
                <td><label>Grade:</label></td>
                <td><form:select path="gradeId">
                    <form:options items="${grades}" itemLabel="number"
                        itemValue="gradeId"/>
                </form:select></td>
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
        <a href="${pageContext.request.contextPath}/student/list">Back to List</a>
    </p>
</div>

</body>
</html>
