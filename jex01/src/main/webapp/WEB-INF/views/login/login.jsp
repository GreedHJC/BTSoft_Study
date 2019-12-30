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
        <form action="/signup" method="post" class="register-form">
            <input name="userId" type="text" placeholder="아이디"/>
            <input name="userPw" type="password" placeholder="비밀번호"/>
            <input name="userName" type="text" placeholder="이름"/>
            <button type="submit">가입하기</button>
            <p class="message"><a href="#">로그인</a></p>
        </form>
        <form action="login" method="post" class="login-form">
            <img src="resources/img/BTSOFT_logo.png"/>
            <input name="username" type="text" placeholder="아이디"/>
            <input name="password" type="password" placeholder="비밀번호"/>
            <button type="submit">로그인</button>
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
</body>
</html>