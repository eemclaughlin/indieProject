<%--
  User: eemclaughlin
  Date: 11/25/22
  Page used to output all the details of a single cookbook and ask for editing/deleting.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Hompage/Recipes" />
<%@include file="/includes/head.jsp"%>
<html>
<body>

<div class="container-fluid" id="wrapper">
<div class="row">
<div class="col-12">

    <!-- Brings in the NavBar -->
    <%@include file="/includes/navbar.jsp"%>

    <div class="container align-items-center">
        <div class="col-12">

            <!-- Page Header -->
            <div class="page-header my-3 py-2">
                <h1>
                    Homepage: <small>A listing of all your recipes.</small>
                </h1>
            </div>

            <!-- Call to add more recipes -->
            <div class="row">
                <div class="jumbotron bg-secondary mb-4 d-flex">
                    <h5 class="pt-4">
                        Add another recipe to your collection?
                    </h5>
                    <p class="ps-2 pt-3">
                        <a class="btn btn-warning btn-large text-dark" href="addRecipe"><strong>Add a Recipe</strong></a>
                    </p>
                </div>
            </div>

            <!-- Dropdown to allow user to sort the recipes -->
            <!-- Reference: https://stackoverflow.com/questions/6847089/how-to-reload-a-page-based-on-a-dropdown-box -->
            <div class="row">
                <div class="d-flex col-12 col-md-4 my-3-md my-1 mb-4">
                    <label for="sortByList" class="form-label d-flex col-2 me-2 align-items-end justify-content-end">Sort By</label>
                    <select id="sortByList" name="sortByItem" class="form-select col col-md-10" onchange="window.location = 'userHomepage?sortBy=' + this.options[this.selectedIndex].value;">
                        <option value="recipeName" <c:if test="${sortBy == 'recipeName'}"> onclick="window.location = 'userHomepage?sortBy=' + this.value;" selected</c:if>>Recipe Name</option>
                        <option value="cookbookName" <c:if test="${sortBy == 'cookbookName'}"> onclick="window.location = 'userHomepage?sortBy=' + this.value;" selected</c:if>>Cookbook Name</option>
                        <option value="cookbookAuthor" <c:if test="${sortBy == 'cookbookAuthor'}"> onclick="window.location = 'userHomepage?sortBy=' + this.value;" selected</c:if>>Cookbook Author</option>
                    </select>
                </div>

                <div class="d-xs-none col-md-1 d-flex my-3-md my-1 mb-4">
                </div>

                <!-- Search bar to allow user to search -->
                <div class="col d-flex my-3-md my-1 mb-4">
                    <label for="search" class="form-label d-flex col-2 me-2 align-items-end justify-content-end">Search</label>
                    <!-- Search for a recipe once enter is pressed -->
                    <input type="text" class="form-control" name="search"
                           aria-describedby="searchHelp" id="search" placeholder="Search for a Recipe"
                           onkeyup="if (event.keyCode === 13) {window.location = 'searchRecipe?search=' + this.value;}">
                </div>
            </div>

            <!-- If there are no recipes, display a message -->
            <c:if test="${recipes.size() == 0}">
                <div class="row">
                    <div class="jumbotron text-dark m-2 d-flex">
                        <h5 class="p-2"><strong>You don't have any recipes yet!</strong></h5>
                    </div>
                </div>
            </c:if>
            <!-- Bring in each recipe and display -->
            <c:if test="${recipes.size() != 0}">
                <c:forEach var="recipe" items="${recipes}">
                    <div class="row my-2 border border-secondary">
                        <div class="col-md-6 bg-light">
                            <h3><a class="link-dark" href="editRecipe?recipeId=${recipe.recipeId}">${recipe.recipeName}</a></h3>
                            <p>
                                <strong>Description: </strong>${recipe.description}

                            </p>
                            <p>
                                <strong>Notes: </strong>${recipe.notes}
                            </p>
                        </div>
                        <div class="col-md-3 bg-warning">
                            <h4 class="text-dark">
                                <a class="link-dark" href="detailCookbook?cookbookId=${recipe.cookbooks.cookbookId}">${recipe.cookbooks.title}</a>
                            </h4>
                            <p class="text-dark">
                                <strong>Author: </strong>${recipe.cookbooks.author}<br/>
                                <strong>Page Number: ${recipe.pageNumber}</strong>

                            </p>
                        </div>
                        <div class="d-none d-md-grid col-md-2 bg-warning d-flex justify-content-end align-items-center">
                            <img id="listCover" class="border border-dark" alt="Cookbook Cover" src="${recipe.cookbooks.smallImageLink}">
                        </div>
                        <div class="col-md-1 bg-warning d-flex align-items-center justify-content-center">
                            <a class="btn btn-dark btn-sm text-secondary border" href="deleteRecipe?recipeId=${recipe.recipeId}"><strong>X</strong></a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <div class ="row mb-5">
                <div class="col mb-5"></div>
            </div>

        </div>
    </div>

    <div class ="row mb-5">
                <div class="col mb-5"></div>
            </div>

        </div>
    </div>

    <!-- Brings in the Footer -->
    <%@include file="/includes/footer.jsp"%>

</div>
</div>
</div>

    <!-- Reference to JavaScript Sources -->
    <%@include file="/includes/javascript.jsp"%>

</body>
</html>

