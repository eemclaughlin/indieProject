<%--
  User: eemclaughlin
  Date: 10/28/22
  Notes: Landing page after user logs out.
--%>
<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="row">
        <c:if test="${userName == null}">
            <h2>You are logged out</h2>
            <a href="index.jsp">Log Back In</a>
        </c:if>
    </div>
</body>
</html>
