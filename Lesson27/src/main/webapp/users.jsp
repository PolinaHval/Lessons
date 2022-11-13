<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/loginUser">loginUser</a></li>
                <li class="breadcrumb-item"><a href="/users">users</a></li>
            </ol>
        </nav>
    </div>
</nav>
<div class="container">
    <div class="row" style="margin-top: 25px">
        <div class="card">
            <div class="card-body">
                <div class="card-title">
                    <h3>Users</h3>
                </div>
                <div class="card-text">
                    <table class="table">
                        <tr>
                            <th>Name</th>
                            <th>Password</th>
                        </tr>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>
                                    <c:out value="${user.login}" />
                                </td>
                                <td>
                                    <c:out value="${user.password}" />
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

