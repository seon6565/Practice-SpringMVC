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
<ul class="list-group">
    <c:forEach var="list" items="${responseDTO.dtoList}">
        <div class="card-body">
            <li class="list-group-item list-group-item-action rounded"><a class="text-break text-decoration-none text-muted" href="/bbs/view?idx=${list.idx}">
                <c:out value="${list.idx}${list.title}$"/></a>
            </li>
        </div>
    </c:forEach>
    <button class="btn btn-outline-primary" type="button" onclick="location.href='/bbs/regist'">등록</button>
</ul>
    <nav>
        <ul class="pagination justify-content-center">
            <li class="page-item
            <c:if test="${responseDTO.prev_page_flag ne true}"> disabled</c:if>">
                <!--a class="page-link" data-num="1" href="page=1">Previous</a-->
                <a class="page-link"
                   data-num="
                <c:choose>
                    <c:when test="${responseDTO.prev_page_flag}">
                        ${responseDTO.page_block_start-1}
                    </c:when>
                    <c:otherwise>1</c:otherwise>
                </c:choose>"
                   href="
                <c:choose>
                    <c:when test="${responseDTO.prev_page_flag}">
                        ${responseDTO.linkParams}&page=${responseDTO.page_block_start-1}
                    </c:when>
                    <c:otherwise>#</c:otherwise>
                </c:choose>
                ">Previous</a>
            </li>
            <c:forEach begin="${responseDTO.page_block_start}"
                       end="${responseDTO.page_block_end}"
                       var="page_num">
                <li class="page-item
                        <c:if test="${responseDTO.page == page_num}"> active</c:if> ">
                    <a class="page-link" data-num="${page_num}"
                       href="<c:choose>
                            <c:when test="${responseDTO.page == page_num}">#</c:when>
                            <c:otherwise>
                                ${responseDTO.linkParams}&page=${page_num}
                            </c:otherwise>
                         </c:choose>">${page_num}</a>
                </li>
            </c:forEach>
            <li class="page-item
                    <c:if test="${responseDTO.next_page_flag ne true}"> disabled</c:if>">
                <a class="page-link"
                   data-num="
                    <c:choose>
                        <c:when test="${responseDTO.next_page_flag}">
                            ${responseDTO.page_block_end+1}
                        </c:when>
                        <c:otherwise>
                            ${responseDTO.page_block_end}
                        </c:otherwise>
                    </c:choose>"
                   href="<c:choose>
                        <c:when test="${responseDTO.next_page_flag}">
                            ${responseDTO.linkParams}&page=
                            ${responseDTO.page_block_end+1}
                        </c:when>
                        <c:otherwise>#</c:otherwise>
                    </c:choose>">Next</a>

            </li>
        </ul>
    </nav>
</div>
<%@ include file="../common/footer.jsp"%>
</body>
</html>