<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
            <th>Name</th>
            <th>Login Id</th>
            <th>Password</th>
            <th>Recipe</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.loginId}</td>
                <td>${user.password}</td>
                <td>
                    <c:forEach var="recipe" items="${user.recipes}">
                        ${recipe.recipeId} ${recipe.recipeName}<br/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
