<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <!-- TODO Find alternate method to redirect to homepage. -->
        <%
            response.sendRedirect(request.getContextPath() + "/userHomepage");
        %>
    </c:otherwise>
</c:choose>
</body>
</html>