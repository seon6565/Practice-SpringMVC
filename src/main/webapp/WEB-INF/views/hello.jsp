
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Hello, JSP~~~~~</h1>
<div class="d-grid gap-2 d-md-flex">
    <button class="btn btn-outline-primary" type="button" onclick="location.href='/bbs/list'">목록</button>
    <button class="btn btn-outline-primary" type="button" onclick="location.href='/bbs/modify?idx=${bbsDTO.idx}'">수정</button>
    <button class="btn btn-outline-primary" type="button" onclick="location.href='/login/login'">로그인</button>
    <button class="btn btn-outline-primary" type="button" onclick="location.href='/member/view'">멤버뷰</button>
</div>
</body>
</html>
