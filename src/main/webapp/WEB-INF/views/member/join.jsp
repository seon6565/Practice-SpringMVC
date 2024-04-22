<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/valueCheck.js"></script>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container">
<h1>Regist</h1>
<form name="frmRegist" id="frmRegist" method="post" action="/member/join" onsubmit="checklast('user_id','div_err_user_id','pwd','div_err_pwd','name','div_err_name','email','div_err_email','brithday','div_err_brithday','okflagid')">
    <div class="mb-3">
        <label for="user_id" class="form-label">아이디</label>
        <input type="text" class="form-control col-auto" name="user_id" id="user_id" value="${memberDTO.user_id}" onkeyup="checkInputId('user_id','div_err_user_id','okflagid')">
        <button class="btn btn-primary col-auto" type="button" class="btn" id="idcheck" onclick="idduplecheck('user_id','div_err_duple_id','okflagid','/member/duplecheck')" >중복확인</button>
        <input type="hidden" value="0" id="okflagid" name="okflagid">
        <div class="form-text" id="div_err_duple_id" style="display:none; color:red">중복된 아이디가 존재합니다.</div>
        <div class="form-text" id="div_err_user_id" style="display:none; color:red">5~15자내의 숫자,영어만 입력하세요.</div>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호</label>
        <input type="text" class="form-control" name="pwd" id="pwd" value="${memberDTO.pwd}" onkeyup="checkInputPw('pwd','div_err_pwd')">
        <div class="form-text" id="div_err_pwd" style="display:none; color:red">영문+숫자+특수문자 10~16자리로만 입력하세요.</div>
    </div>
    <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input type="text" class="form-control" name="name" id="name" value="${memberDTO.name}" onkeyup="checkInputName('name','div_err_name')">
        <div class="form-text" id="div_err_name" style="display:none; color:red">한글 5자이내, 영문10자이내 로만 입력하세요</div>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">이메일</label>
        <input type="email" class="form-control" name="email" id="email" value="${memberDTO.email}" onkeyup="checkInputEmail('email','div_err_email')">
        <div class="form-text" id="div_err_email" style="display:none; color:red">OOO@OOO0.0OOO형태로 입력해주세요.</div>
    </div>
    <div class="mb-3">
        <label for="brithday" class="form-label">생년월일</label>
        <input type="date" class="form-control" name="brithday" id="brithday" value="${memberDTO.brithday}" onchange="checkInputBirth('brithday','div_err_brithday')">
        <div class="form-text" id="div_err_brithday" style="display:none; color:red">오늘까지의 날짜로만 입력 가능합니다.</div>
    </div>
    <label for="interests" class="form-label">관심사항</label>
    <div id="interests" class="mb-3 form-control">
        <div class="form-check form-switch form-check-inline" >
            <label class="form-check-label" for="interest_0">스포츠</label>
            <input class="form-check-input" type="checkbox" role="switch" name="interest" id="interest_0" value="스포츠"
            <c:out value="${memberDTO.interest.contains(\"스포츠\")?'checked':''}"/>>
        </div>
        <div class="form-check form-switch form-check-inline">
            <label class="form-check-label" for="interest_1">여행</label>
            <input class="form-check-input" type="checkbox" role="switch" name="interest" id="interest_1" value="여행"
            <c:out value="${memberDTO.interest.contains(\"여행\")?'checked':''}"/>>
        </div>
        <div class="form-check form-switch form-check-inline">
            <label class="form-check-label" for="interest_2">영화</label>
            <input class="form-check-input" type="checkbox" role="switch" name="interest" id="interest_2" value="영화"
            <c:out value="${memberDTO.interest.contains(\"영화\")?'checked':''}"/>>
        </div>
        <div class="form-check form-switch form-check-inline">
            <label class="form-check-label" for="interest_3">음악</label>
            <input class="form-check-input" type="checkbox" role="switch" name="interest" id="interest_3" value="음악"
            <c:out value="${memberDTO.interest.contains(\"음악\")?'checked':''}"/>>
        </div>
        <div class="form-text" id="div_err_interest" style="display:none"></div>
    </div>
    <div class="mb-3">
        <label for="addr1" class="form-label">주소1</label>
        <input type="text" class="form-control" name="addr1" id="addr1" value="${memberDTO.addr1}">
        <div class="form-text" id="div_err_addr1" style="display:none; color:red"></div>
    </div>
    <div class="mb-3">
        <label for="addr2" class="form-label">주소2</label>
        <input type="text" class="form-control" name="addr2" id="addr2" value="${memberDTO.addr2}">
        <div class="form-text" id="div_err_addr2" style="display:none; color:red"></div>
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" type="submit">회원가입</button>
    </div>
</form>
</div>
<%@ include file="../common/footer.jsp"%>
<script>
    const result = {};
    <c:forEach items="${errors}" var="err">
    if(document.getElementById("div_err_${err.getField()}") != null){
        document.getElementById("div_err_${err.getField()}").innerHTML = "<span style='color:red'>해당 영역은 필수입니다."
        document.getElementById("div_err_${err.getField()}").style.display= "block"
    }
    result['${err.getField()}'] = '${err.defaultMessage}';
    </c:forEach>

    console.log(result);
    <%--console.log(${errors});--%>
    <%--errorMessage(${errors});--%>
</script>

</body>
</html>
