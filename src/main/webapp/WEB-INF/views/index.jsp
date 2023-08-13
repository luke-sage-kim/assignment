<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> SQL 구문 Parser 구현</title>

</head>
<body>
<header>
</header>

<main>
    <h1>SQL 구문 Parser 구현</h1>
    <form action="/v3/parser" method="post">
        <label for="assign">SQL을 입력해주세요</label>
        <br>
        <textarea id="assign" name="assign" rows="4" cols="50"></textarea>
        <br>
        <button type="submit">제출</button>
    </form>

    <h2>================= 실행 결과 =================</h2>
    <ul>
        <%--
            채택하지않은이유: 대소문자인식문제 주석,멀티주석처리문제
            <c:forEach var="word" items="${words}">
                    <c:choose>
                        <c:when test="${word eq 'SELECT' or word eq 'FROM' or word eq 'WHERE' or word eq 'AND' or word eq 'LIKE'}">
                            <li>${word} → Keyword</li>
                        </c:when>
                        <c:when test="${word eq 'MAX' or word eq 'SUM' or word eq 'WHERE'}">
                            <li>${word} → Function</li>
                        </c:when>
                        <c:when test="${word.startsWith(':')}">
                            <li>${word} → Binding 변수</li>
                        </c:when>
                        <c:when test="${word.startsWith('‘')}">
                            <li>${word} → 문자열</li>
                        </c:when>
                        <c:otherwise>
                            <li>${word} → ETC</li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach> --%>

    <c:forEach var="arr" items="${resultList}">
        <li>${arr[0]} → ${arr[1]}</li>
    </c:forEach>
    </ul>
</main>

<footer>
</footer>


</body>
</html>