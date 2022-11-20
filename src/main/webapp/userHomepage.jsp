<%@include file="taglib.jsp"%>
<c:set var="title" value="User Homepage" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#recipeTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>User Homepage: </h2>
    <table id="recipeTable" class="display" cellspacing="0" width="100%">
        <thead>
            <th>Recipe Name</th>
            <th>Description Id</th>
            <th>Notes</th>
            <th>Cookbook</th>
            <th>Page Number</th>
            <th>Edit?</th>
            <th>Delete?</th>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${recipes}">
            <tr>
                <td>${recipe.recipeName}</td>
                <td>${recipe.description}</td>
                <td>${recipe.notes}</td>
                <td>${recipe.cookbooks.title}</td>
                <td>${recipe.pageNumber}<br/></td>
                <td><a href="editRecipe?recipeId=${recipe.recipeId}">Edit ${recipe.recipeId}</a></td>
                <td><a href="deleteRecipe.jsp?recipeId=${recipe.recipeId}">Delete ${recipe.recipeId}</a></td>
            </tr>
        </c:forEach>

        <div>
            <p>Links</p>
            <a href="userHomepage">Home</a><br>
            <a href="listCookbooks">List of Cookbooks</a><br>
            <a href="searchRecipe.jsp">Search Page</a><br>
            <a href="addRecipe">Add a New Recipe</a><br>
            <a href="addCookbook.jsp">Add a New Cookbook</a><br>
            <a href="logout">LogOut</a><br>
        </div>
        </tbody>
    </table>
</div>

</body>
</html>
