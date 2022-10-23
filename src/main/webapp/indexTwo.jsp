<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#recipeTable').DataTable();
    });
</script>

<html>
<body>

<h2>Test Recipe Tracker Setup</h2>

<form action="searchUser" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm"
               aria-describedby="searchTermHelp" placeholder="Search">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</button>
</form>

<form action="searchRecipe" class="form-inline">
    <div class="form-group">
        <label for="searchTermRecipe">Search</label>
        <input type="text" class="form-control" id="searchTermRecipe" name="searchTermRecipe"
               aria-describedby="searchTermHelp" placeholder="Search">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Recipes</button>
</form>

<div class="container-fluid">
<h2>HomePage: </h2>
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

</body>
</html>