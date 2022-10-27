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
            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">Head to Homepage</button>
        </form>

        <div class="container-fluid">
            <h2>Recipe Search Results: </h2>
            <table id="recipeTable" class="display" cellspacing="0" width="100%">
                <thead>
                <th>Recipe Name</th>
                <th>Description Id</th>
                <th>Notes</th>
                <th>User</th>
                </thead>
                <tbody>
                <c:forEach var="recipe" items="${recipes}">
                    <tr>
                        <td>${recipe.recipeName}</td>
                        <td>${recipe.description}</td>
                        <td>${recipe.notes}</td>
                        <td>${recipe.user.firstName} ${recipe.user.lastName}<br/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%
            response.sendRedirect(request.getContextPath() + "/userHomepage");
        %>


    </c:otherwise>
</c:choose>
</body>
</html>