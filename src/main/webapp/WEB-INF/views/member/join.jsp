<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오후 4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>회원가입</h1>
<form name="frmRegist" id="frmRegist" method="post" action="/bbs/regist">
    <div>
        <span>아이디: </span> <input type="text" name="user_id" id="user_id" value="">
    </div>
    <div>
        <span>비밀번호: </span> <input type="password" name="title" id="title" value="">
    </div>
    <div>
        <span>내용: </span> <textarea type="text" name="content" id="content" rows="10" cols="60"></textarea>
    </div>
    <div>
        <span>출력날짜: </span> <input type="date" name="display_date" id="display_date" value="">
    </div>
    <div>
        <button type="submit">회원 가입</button>
    </div>
</form>
</body>
</html>
