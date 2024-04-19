<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오후 4:25
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
<h1>login</h1>
<p style="color: red">${errors}</p>
<form id="frmLogin" name="frmLogin" method="post" action="/login/login">
    <input type="hidden" name="acc_url" id="acc_url" value="${acc_url}">
    <div><span>아이디: </span> <input type="text" name="user_id" id="user_id" value=""></div>
    <div><span>비밀번호: </span> <input type="text" name="pwd" id="pwd" value=""></div>
    <div><span>아이디저장: </span> <input type="checkbox" name="save_id" id="save_id" value="${Checked}">
    <span>자동로그인: </span> <input type="checkbox" name="auto_login" id="auto_login" value="${Checked}"></div>
    <div>
        <button id="btnLogin">로그인</button>
    </div>
</form>
<script>
    const btnLogin = document.getElementById("btnLogin");
    const frm = document.getElementById("frmLogin");
    btnLogin.addEventListener("click",function (e){
        e.preventDefault();
        e.stopPropagation();

        frm.method="post";
        frm.submit();
    },false)
</script>
</body>
</html>
