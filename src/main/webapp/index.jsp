<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
        <form action="searchRecipe" class="form-inline">
            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Recipes</button>
        </form>

    </c:otherwise>
</c:choose>
</body>
</html>