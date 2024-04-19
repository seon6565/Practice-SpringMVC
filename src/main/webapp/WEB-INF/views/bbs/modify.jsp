<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>modify</h1>
<form name="frmModify" id="frmModify" method="post" action="/bbs/modify">
    <input type="hidden" id="idx" name="idx" value="${bbsDTO.idx}">
    <div>
        <span>아이디: </span> <input type="text" name="user_id" id="user_id" value="${bbsDTO.user_id}">
    </div>
    <div>
        <span>제목: </span> <input type="text" name="title" id="title" value="${bbsDTO.title}">
    </div>
    <div>
        <span>내용: </span> <textarea type="text" name="content" id="content" rows="10" cols="60">${bbsDTO.content}</textarea>
    </div>
    <div>
        <span>출력날짜: </span> <input type="date" name="display_date" id="display_date" value="${bbsDTO.display_date}">
    </div>
    <div>
        <span>관심사항: </span>
        <span>스포츠</span><input type="checkbox" name="interest" id="interest_0" value="스포츠"
        <c:out value="${bbsDTO.interest.contains(\"스포츠\")?'checked':''}"/>>
        <span>여행</span><input type="checkbox" name="interest" id="interest_1" value="여행"
        <c:out value="${bbsDTO.interest.contains(\"여행\")?'checked':''}"/>>
        <span>영화</span><input type="checkbox" name="interest" id="interest_2" value="영화"
        <c:out value="${bbsDTO.interest.contains(\"영화\")?'checked':''}"/>>
        <span>음악</span><input type="checkbox" name="interest" id="interest_3" value="음악"
        <c:out value="${bbsDTO.interest.contains(\"음악\")?'checked':''}"/>>
        <div id="div_err_interest" style="display:none"></div>
    </div>
    <div>
        <button type="submit">글 등록</button>
    </div>
</form>
</body>
</html>
