<%--
  Created by IntelliJ IDEA.
  User: love_
  Date: 2019-12-12
  Time: 오전 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>sign in/up page with double sliding animation</title>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.7.2/css/all.min.css'><link rel="stylesheet" href="/resources/css/login.css">
    <script src="/resources/js/dist/jquery/jquery.js"></script>

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form name="signup_form" action="/signup" method="post">
            <h1>Create Account</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your email for registration</span>
            <input type="text" name="userId" id="userId" placeholder="아이디" />
            <input type="text" name="userPw" id="userPw" placeholder="비밀번호" />
            <input type="text" name="userName" id="userName" placeholder="이름" />
            <input type="text" name="userBirth" id="userBirth" placeholder="생년월일" />
            <input type="text" name="userAddr" id="userAddr" placeholder="주소" />
            <input type="text" name="userHp" id="userHp" placeholder="핸드폰" />
            <input type="text" name="officeTel" id="officeTel" placeholder="내선번호" />
            <input type="text" name="joinDay" id="joinDay" placeholder="입사일" />
            <input type="text" name="outDay" id="outDay" placeholder="퇴사일" />
            <input type="text" name="grade" id="grade" placeholder="직책" />
            <input type="text" name="depart" id="depart" placeholder="소속부서" />
            <input type="submit">Sign Up</input>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="#">
            <h1>Sign in</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your account</span>
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <a href="#" class="forgot-password">Forgot your password?</a>
            <button>Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
<!-- partial -->
<script  src="/resources/js/login.js"></script>

</body>
</html>