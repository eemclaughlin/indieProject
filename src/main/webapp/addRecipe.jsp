<%--
  User: eemclaughlin
  Date: 11/25/22
  Page used to allow user to enter a new recipe.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Add a Recipe" />
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
                    Enter a Recipe: <small>Enter in a new recipe.</small>
                </h1>
            </div>

            <div class="row">
                <div class="col-lg-5">
                    <form role="form" action="addRecipe" method="post">
                        <div class="form-group mx-3 mb-3">
                            <label for="recipeName" class="mb-1">Recipe Name</label>
                            <input type="text" class="form-control" id="recipeName"
                                   name="recipeName" aria-describedby="recipeNameHelp"
                                   placeholder="Ex. Carrot Cake" required>
                        </div>
                        <div class="form-group m-3">
                            <label for="description" class="mb-1">Description</label>
                            <input type="text" class="form-control" id="description"
                                   name="description" aria-describedby="descriptionHelp"
                                   placeholder="Ex. A delicious cake with frosting.">
                        </div>
                        <div class="form-group m-3">
                            <label for="notes" class="mb-1">Personal Notes</label>
                            <textarea type="text" class="form-control" id="notes"
                                   name="notes" aria-describedby="notesHelp"
                                   placeholder="Recipe notes or cooking tips"
                                   rows="4"></textarea>
                        </div>
                        <div class="form-group m-3">
                            <label for="pageNumber" class="mb-1">Page Number</label>
                            <input type="number" class="form-control" id="pageNumber"
                                      name="pageNumber" aria-describedby="pageNumberHelp"
                                      placeholder="Ex. 123" required>
                        </div>
                        <div class="form-group m-3">
                            <label for="cookbookList" class="form-label mt-2 mb-1">Select The Cookbook</label>
                            <select id="cookbookList" name="cookbook" class="form-select">
                                <c:forEach items="${cookbookList}" var="cookbook">
                                    <option value="${cookbook.cookbookId}"
                                            <c:if test="${cookbook.cookbookId eq selectedCookbookId}">selected="selected"</c:if>>
                                            ${cookbook.title}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <a class="btn btn-warning btn-large text-dark ms-3 me-1" href="userHomepage"><strong>Return To List</strong></a>

                        <button type="submit" name="submit" value="addRecipe"
                                class="btn btn-warning text-dark mx-3 my-2"><strong>Add Recipe</strong>
                        </button>
                    </form>
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

