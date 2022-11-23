<%@include file="taglib.jsp"%>
<c:set var="title" value="List Cookbooks" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#recipeTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>List of User's Cookbooks: </h2>
    <table id="recipeTable" class="display" cellspacing="0" width="100%">
        <thead>
            <th></th>
            <th>Title</th>
            <th>Author</th>
            <th>Publisher</th>
            <th>Description</th>
            <th>Notes</th>
            <th>Details</th>
            <th>Edit?</th>
            <th>Delete?</th>
        </thead>
        <tbody>
        <c:forEach var="cookbook" items="${cookbooks}">
            <tr>
                <td><img src="${cookbook.smallImageLink}" alt="Image of Cookbook"></img></td>
                <td>${cookbook.title}</td>
                <td>${cookbook.author}</td>
                <td>${cookbook.publisher}</td>
                <td>${cookbook.description}</td>
                <td>${cookbook.notes}</td>
                <td><a href="detailCookbook?cookbookId=${cookbook.cookbookId}">Details</a></td>
                <td><a href="editCookbook?cookbookId=${cookbook.cookbookId}">Edit ${cookbook.cookbookId}</a></td>
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
