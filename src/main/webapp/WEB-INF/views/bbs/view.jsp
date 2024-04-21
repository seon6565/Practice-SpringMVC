<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
<h1>view</h1>
<form name="frmDelete" id="frmDelete" method="post" action="/bbs/delete">
    <input type="hidden" id="idx" name="idx" value="${bbsDTO.idx}">
<div class="mb-3">
    idx
    <span class="form-control">${bbsDTO.idx}</span>
</div>
<div class="mb-3">
    아이디
    <span class="form-control">${bbsDTO.user_id}</span>
</div>
<div class="mb-3">
    제목
    <span class="form-control"> ${bbsDTO.title} </span>
</div>
<div class="mb-3">
    내용
    <span class="form-control">${bbsDTO.content} </span>
</div>
<div class="mb-3">
    출력날짜
    <span class="form-control"> ${bbsDTO.display_date} </span>
</div>
<div class="mb-3">
    관심사항
    <span class="form-control">${bbsDTO.interest} </span>
</div>
<div class="d-grid gap-2 d-md-flex">
    <button class="btn btn-outline-primary" type="button" onclick="location.href='/bbs/list'">목록</button>
    <c:if test="${bbsDTO.user_id==logininfo.user_id}">
        <button class="btn btn-outline-primary" type="button" onclick="location.href='/bbs/modify?idx=${bbsDTO.idx}'">수정</button>
    </c:if>
    <c:if test="${bbsDTO.user_id==logininfo.user_id}">
        <button class="btn btn-outline-primary" type="button" onclick="goDelete()">삭제</button>
    </c:if>
    <button class="btn btn-outline-primary" type="button" onclick="location.href='/login/login'">로그인</button>
</div>
</form>
</div>
<%@ include file="../common/footer.jsp"%>
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
