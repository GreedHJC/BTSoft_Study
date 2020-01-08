<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="resources/css/common.css">

</head>
<body>

<div class="login-page">
    <div class="form">
        <form id="userForm" action="/signup" method="post" class="register-form">
            <input type="hidden" name="hidTest"/>
            <input class="regform" id="userId" name="userId" type="text" placeholder="아이디"/>
            <div class="check-form" id="idMsg">
                <span></span>
            </div>
            <input class="regform" id="userPw1" name="userPw" type="password" placeholder="비밀번호"/>
            <div class="check-form" id="pwMsg1">
                <span></span>
            </div>
            <input class="regform" id="userPw2" name="userPw2" type="password" placeholder="비밀번호 확인"/>
            <div class="check-form" id="pwMsg2">
                <span></span>
            </div>
            <input class="regform" id="userName" name="userName" type="text" placeholder="이름"/>
            <div class="check-form" id="nameMsg">
                <span></span>
            </div>
            <input class="regform" id="userHp" name="userHp" type="text" placeholder="전화번호"/>
            <div class="check-form" id="hpMsg">
                <span></span>
            </div>
            <button id="regbtn" type="submit">가입하기</button>
            <p class="message"><a href="#">로그인</a></p>
        </form>

        <form id="loginform" action="login" method="post" class="login-form">
            <img src="resources/img/BTSOFT_logo.png"/>
            <input id="loginId" name="username" type="text" placeholder="아이디"/>
            <input name="password" type="password" placeholder="비밀번호"/>
            <button id="loginbtn" type="submit">로그인</button>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <p class="message"><a href="#">회원가입</a></p>
        </form>

    </div>
</div>
<!-- partial -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="resources/js/common.js"></script>
<script src="resources/js/signup.js"></script>
</body>
</html>