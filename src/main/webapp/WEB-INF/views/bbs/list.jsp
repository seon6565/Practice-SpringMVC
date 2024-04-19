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
<h1>list</h1>
${loginInfo}
<ul>
    <c:forEach var="list" items="${bbsList}">
        <li><a href="/bbs/view?idx=${list.idx}"><c:out value="${list}"/></a></li>
    </c:forEach>
</ul>
</body>
</html>
