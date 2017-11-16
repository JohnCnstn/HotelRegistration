<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Practice application</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/admin.css">

    <script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.tablesorter.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.tablesorter.min.js"></script>

</head>
<body>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Practice application</a>
        </div>

        <form:form action="logout" method="get">
            <button type="submit" class="btn navbar-btn navbar-right" id="header-btn">
                Logout
            </button>
        </form:form>

    </div>
</div>


<div class="form-group" id="wrapper">

    <table class="tablesorter" id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th><span>First Name</span></th>
            <th><span>Second Name</span></th>
        </tr>
        </thead>
        <tbody>

            <c:forEach items="${listOfStudents}" var="i">
                <tr>
                    <td>${i.firstName}</td>
                    <td>${i.lastName}</td>
                </tr>
            </c:forEach>

        </tbody>
    </table>

</div>

</body>
</html>
