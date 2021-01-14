<%--
  Created by IntelliJ IDEA.
  User: kwak
  Date: 2019-02-06
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>--%>

<html>
<head>

    <%@ include file="/WEB-INF/views/reference/head.jsp" %>

    <title>SB Admin - register</title>

</head>

<body class="bg-dark">

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Register an Account</div>
        <div class="card-body">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="firstName" name="firstName" class="form-control" placeholder="First name" required="required" autofocus="autofocus">
                                <label for="firstName">First name</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last name" required="required">
                                <label for="lastName">Last name</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required="required">
                        <label for="email">Email address</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required="required">
                                <label for="inputPassword">Password</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                                <label for="confirmPassword">Confirm password</label>
                            </div>
                        </div>
                    </div>
                </div>
                <button id="btnRegister" style="width: 100%; background-color: #007bff;" >등록</button>
            <div class="text-center">
                <a class="d-block small mt-3" href="login">Login Page</a>
                <a class="d-block small" href="forgot-password">Forgot Password?</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        // ******** 정의 ********

        // ******** 함수 ********

        // 동기식 Ajax 사용
        $.ajaxNotUseASync = function(url, reqData){
            if(typeof url === 'undefined') {
                return;
            }

            var result = {};

            $.ajax({
                url: "${pageContext.request.contextPath}" + url,
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=UTF-8",
                data: JSON.stringify(reqData),
                async: false,
                error:      function (jqXHR, textStatus, errorThrown) {
                    if (jqXHR.status == 401 || jqXHR.status == 403) {
                        alert('세션이 만료되었습니다.\n\n로그인 페이지로 이동합니다.\n로그인 유지가 설정된 경우 자동 로그인됩니다.');
                        location.href = location.href;
                    } else {
                        console.error(jqXHR.status + ' : ' + jqXHR.responseText);
                    }
                },
                success: function (data) {
                    result = data;
                    console.log(result);
                }
            });

            return result;
        };

        // 비동기식 Ajax 사용
        $.ajaxASync = function(url, reqData, succCallback){
            if(typeof data === 'undefined') {
                return;
            }

            $.ajax({
                url: url,
                type: 'post',
                contentType: "application/json; charset=UTF-8",
                dataType: 'json',
                data: JSON.stringify(reqData),
                // async: false,            // 기본값은 true 임
                success: function (data) {
                    var result = data;
                    succCallback(result);
                }
            });

        };

        var goLogin = function () {
            location.href = location.protocol + "//" + location.host + "/login";
        }

        var checkPassword = function() {
            var $password = $.trim($('#inputPassword').val());
            var confirm = $.trim($('#confirmPassword').val());

            if ( $password != confirm) {
                alert("패스워드가 확인 패스워트 와 일치하지 않습니다. \n" + confirm + " ::: " + $password + " => " + confirm.length + " ::: " + $password.length);
                return false;
            }

            return true;
        };

        var register = function() {
            var url = '/user/register';
            var user = {};

            user.email = $.trim($('#email').val());
            user.password = $.trim($('#inputPassword').val());

            // var member = {};
            // member.name = $.trim($('#firstName').val()) + $.trim($('#lastName').val());
            // user.member = member;

            var result = $.ajaxNotUseASync(url, user);

            if ( result != null ) {
                alert('등록 하였습니다.');
                goLogin();
            } else {
                alert('등록 실패 하였습니다.');
            }
        };

        // ******** 이벤트 ********

        // 이벤트 - 사용자 등록
        $('#btnRegister').on('click', function () {

            if ( !checkPassword()) {
                return;
            }

            register();
        });

        // ******** 로딩 ********

    });
</script>

</body>

</html>

