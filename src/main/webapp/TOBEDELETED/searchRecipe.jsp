<%@include file="head.jsp"%>

<html>
<body>

<h2>Test Recipe Tracker Search Screen</h2>

<form action="searchRecipe" class="form-inline">
    <div class="form-group">
        <label for="searchTermRecipe">Search</label>
        <input type="text" class="form-control" id="searchTermRecipe" name="searchTermRecipe"
               aria-describedby="searchTermHelp" placeholder="Search">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Recipes</button>
</form>

</body>
</html>