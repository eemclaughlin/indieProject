<%--
  User: eemclaughlin
  Date: 11/20/22
  JSP for getting a recipe from database and allowing user to edit it.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Edit a Recipe" />
<%@include file="head.jsp"%>
<html>
<body>

<h2>Edit a Recipe</h2>

<form action="editRecipe" class="form-inline" method="post">
    <div class="form-group">
        <label for="recipeName">Recipe Name</label>
        <input type="text" class="form-control" id="recipeName" name="recipeName"
               aria-describedby="recipeNameHelp" placeholder="recipeName"
               value="${editRecipe.recipeName}">

        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" name="description"
               aria-describedby="descriptionHelp" placeholder="description"
               value="${editRecipe.description}">

        <label for="notes">Additional Notes</label>
        <input type="text" class="form-control" id="notes" name="notes"
               aria-describedby="notesHelp" placeholder="notes"
               value="${editRecipe.notes}">

        <label for="pageNumber">Page Number</label>
        <input type="text" class="form-control" id="pageNumber" name="pageNumber"
               aria-describedby="pageNumberHelp" placeholder="pageNumber"
               value="${editRecipe.pageNumber}">

        <select name="cookbook">
            <c:forEach items="${cookbookList}" var="cookbook">
                <option value="${cookbook.cookbookId}"
                        <c:if test="${cookbook.cookbookId eq selectedCookbookId}">selected="selected"</c:if>>
                        ${cookbook.title}
                </option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" name="submit" value="editRecipe" class="btn btn-primary">Save Changes</button>
</form>

</body>
</html>
