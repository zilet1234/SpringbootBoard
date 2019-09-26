<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kwak
  Date: 2019-02-05
  Time: 오후 6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@ include file="/WEB-INF/views/reference/head.jsp" %>
    <title>SB Admin - Login</title>
    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js" />--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/base.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.js"></script>
    <script type="text/javascript">
        var _contextPath = '${pageContext.request.contextPath}';
        var _port = '${pageContext.request.serverPort}';
        var _serverName = '${pageContext.request.serverName}';
    </script>
</head>

<body class="bg-dark">
    <div class="container">
        <div class="card card-login mx-auto mt-5">
            <div class="card-header">Login</div>
            <div class="card-body">
                <form method="post" id="FormLogin" action="/loginProcess">
                    <div class="form-group">
                        <div class="form-label-group">
                            <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
                            <label for="inputEmail">Email address</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-label-group">
                            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                            <label for="inputPassword">Password</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="remember-me">
                                Remember Password
                            </label>
                        </div>
                    </div>
                    <a class="btn btn-primary btn-block" id="BtnLogin" >Login</a>
                </form>
                <div class="text-center">
                    <a class="d-block small mt-3" href="register">Register an Account</a>
                    <a class="d-block small" href="forgot-password">Forgot Password?</a>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        $(document).ready(function () {

            // VARIABLE DEFINE
            $form = $('#FormLogin');
            $btnLogin = $('#BtnLogin');

            // FUNCTION DEFINE

            // INITIALIZE
            // $form.submit(function (event) {
            //     alert(event);
            //     return true;
            // });

            $btnLogin.on('click', function () {
                $form.submit();
            });

        });
    </script>
</body>

</html>
