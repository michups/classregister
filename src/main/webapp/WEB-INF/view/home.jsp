<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class Register</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

<div id="container">
    <div id="content">
        <h1>Class Register</h1>
        <hr>

        <input type="button" value="Student List"
               onclick="window.location.href='student';
               return false;"
               class="add-button">
        <hr>

        <input type="button" value="Grade List"
               onclick="window.location.href='grade';
               return false;"
               class="add-button">
        <hr>

        <input type="button" value="Teacher List"
               onclick="window.location.href='teacher';
               return false;"
               class="add-button">
    </div>
</div>
</body>
</html>