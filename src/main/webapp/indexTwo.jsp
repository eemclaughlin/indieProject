<%@include file="head.jsp"%>

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

</body>
</html>