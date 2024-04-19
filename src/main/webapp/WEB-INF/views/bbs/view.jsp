<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:30
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
<h1>view</h1>
<form name="frmDelete" id="frmDelete" method="post" action="/bbs/delete">
    <input type="hidden" id="idx" name="idx" value="${bbsDTO.idx}">
<div>
    <span>idx: ${bbsDTO.idx}</span>
</div>
<div>
    <span>아이디: ${bbsDTO.user_id}</span>
</div>
<div>
    <span>제목: ${bbsDTO.title} </span>
</div>
<div>
    <span>내용: ${bbsDTO.content} </span>
</div>

<div>
    <span>출력날짜: ${bbsDTO.display_date} </span>
</div>
<div>
    <span>관심사항: ${bbsDTO.interest} </span>
</div>
<div>
    <button type="button" onclick="location.href='/bbs/list'">목록</button>
    <button type="button" onclick="location.href='/bbs/modify?idx=${bbsDTO.idx}'">수정</button>
    <button type="button" onclick="location.href='/login/login'">로그인</button>
    <button type="button" onclick="goDelete()">삭제</button>
</div>
</form>
<script>
    function goDelete(){
        const frm = document.getElementById("frmDelete");
        if(confirm("해당 게시글을 삭제하시겠습니까?")){
            frm.submit();
        }
    }
</script>
</body>
</html>
