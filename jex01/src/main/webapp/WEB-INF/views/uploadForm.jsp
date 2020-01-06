<%--
  Created by IntelliJ IDEA.
  User: Qweqw
  Date: 2020-01-03
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>


<form action="uploadFormAction" method="post" enctype="multipart/form-data">

    <input type='file' name='uploadFile' multiple>

    <button>Submit</button>

</form>

</body>
</html>
