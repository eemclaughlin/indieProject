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

            <!-- Bring in each recipe and display -->
            <c:forEach var="recipe" items="${recipes}">
                <div class="row my-2 border border-secondary">

                    <div class="col-md-7 bg-light">
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
                    <div class="col-md-2 bg-light">
                        <img alt="Cookbook Cover" src="${recipe.cookbooks.smallImageLink}">
                    </div>
                </div>
            </c:forEach>

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

