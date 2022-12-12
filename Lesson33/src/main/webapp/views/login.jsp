<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <link rel="stylesheet" href="login.css" />--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form class="decor" method="post">--%>
<%--    <div class="form-left-decoration"></div>--%>
<%--    <div class="form-right-decoration"></div>--%>
<%--    <div class="circle"></div>--%>
<%--    <div class="form-inner">--%>
<%--    <h3>Login</h3>--%>
<%--    <label>Login</label><br>--%>
<%--    <input type="text" name="login"/><br><br>--%>
<%--    <label>Password</label><br>--%>
<%--    <input type="password" name="password" /><br><br>--%>
<%--    <input type="submit" value="Login" />--%>
<%--    </div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<%--<%@ page import="com.teachmeskills.model.User" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 25px">
        <div class="card">
            <div class="card-body">
                <div class="card-title">
                    <h3>Login Page</h3>
                </div>
                <div class="card-text">
                    <form action="login" method="POST">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label" for="login">Login</label>
                            <div class="col-sm-7">
                                <input class="col-form-label form-control" id="login" name="login" placeholder="Login">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label" for="password">Password</label>
                            <div class="col-sm-7">
                                <input class="col-form-label form-control" type="password"
                                       id="password" name="password"
                                       placeholder="password">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
