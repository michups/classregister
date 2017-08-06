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
    <title>Save Teacher</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/add-customer-style.css" />" rel="stylesheet">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Teacher manager</h2>
        </div>
    </div>


    <div id="container">
        <form:form action="saveTeacher" modelAttribute="teacher" method="POST">

            <form:hidden path="teacherId"/>

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
                        <td><label>Main class:</label></td>
                        <td><form:select path="mainClass">
                            <form:options items="${grades}"
                                          itemValue="gradeId"/>
                        </form:select></td>
                    </tr>

                    <tr>
                        <td><label>Grades:</label></td>
                        <td><form:checkboxes path="grades" items="${grades}"
                            itemValue="gradeId"/></td>

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
            <a href="${pageContext.request.contextPath}/teacher/list">Back to List</a>
        </p>
    </div>

</body>
</html>
