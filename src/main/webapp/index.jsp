<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <%
            response.sendRedirect(request.getContextPath() + "/userHomepage");
        %>
    </c:otherwise>
</c:choose>
</body>
</html>