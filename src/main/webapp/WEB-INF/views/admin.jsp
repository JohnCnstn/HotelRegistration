<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
            <th><span>User First Name</span></th>
            <th><span>User Second Name</span></th>
            <th><span>Hotel Name</span></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="i">
            <c:if test="${i.id > 1}">
                <tr>
                    <td>
                        ${i.firstName}
                    </td>
                    <td>
                        ${i.lastName}
                    </td>
                    <td>
                        ${i.hotel.name}
                    </td>
                    <td>
                            <spring:url value="/admin/${i.id}/delete" var="deleteUrl" />

                            <button class="btn btn-danger"
                                    onclick="location.href='${deleteUrl}'">Delete</button>
                </tr>
            </c:if>
        </c:forEach>

        </tbody>
    </table>

</div>

</body>
</html>
