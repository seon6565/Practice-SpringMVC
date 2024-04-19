<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:31
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
<h1>regist</h1>
<form name="frmRegist" id="frmRegist" method="post" action="/bbs/regist">
    <div>
        <span>아이디: </span> <input type="text" name="user_id" id="user_id" value="${bbsDTO.user_id}">
        <div id="div_err_user_id" style="display:none"></div>
    </div>
    <div>
        <span>제목: </span> <input type="text" name="title" id="title" value="${bbsDTO.title}">
        <div id="div_err_title" style="display:none"></div>
    </div>
    <div>
        <span>내용: </span> <textarea type="text" name="content" id="content" rows="10" cols="60">${bbsDTO.content}</textarea>
        <div id="div_err_content" style="display:none"></div>
    </div>
    <div>
        <span>출력날짜: </span> <input type="date" name="display_date" id="display_date" value="${bbsDTO.display_date}">
        <div id="div_err_display_date" style="display:none"></div>
    </div>
    <div>
        <span>관심사항: </span>
        <span>스포츠</span><input type="checkbox" name="interest" id="interest_0" value="스포츠"/>
        <span>여행</span><input type="checkbox" name="interest" id="interest_1" value="여행"/>
        <span>영화</span><input type="checkbox" name="interest" id="interest_2" value="영화"/>
        <span>음악</span><input type="checkbox" name="interest" id="interest_3" value="음악"/>
        <div id="div_err_interest" style="display:none"></div>
    </div>
    <div>
        <button type="submit">글 등록</button>
    </div>
</form>
<script>
    const result = {};
    <c:forEach items="${errors}" var="err">
        if(document.getElementById("div_err_${err.getField()}") != null){
            document.getElementById("div_err_${err.getField()}").innerHTML = "<span style='color:red'>${err.defaultMessage}"
            document.getElementById("div_err_${err.getField()}").style.display= "block"
        }
        result['${err.getField()}'] = '${err.defaultMessage}';
    </c:forEach>

    console.log(result);
</script>
</body>
</html>
