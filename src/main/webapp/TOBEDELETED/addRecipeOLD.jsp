<%--
  User: eemclaughlin
  Date: 10/29/22
  Page with form for users to fill out to add a recipe to database.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Add a Recipe" />
<%@include file="head.jsp"%>
<html>
<body>

<h2>Add a Recipe</h2>

<form action="addRecipe" class="form-inline" method="post">
  <div class="form-group">
    <label for="recipeName">Recipe Name</label>
    <input type="text" class="form-control" id="recipeName" name="recipeName"
           aria-describedby="recipeNameHelp" placeholder="recipeName">

    <label for="description">Description</label>
    <input type="text" class="form-control" id="description" name="description"
           aria-describedby="descriptionHelp" placeholder="description">

    <label for="notes">Additional Notes</label>
    <input type="text" class="form-control" id="notes" name="notes"
           aria-describedby="notesHelp" placeholder="notes">

    <label for="pageNumber">Page Number</label>
    <input type="text" class="form-control" id="pageNumber" name="pageNumber"
           aria-describedby="pageNumberHelp" placeholder="pageNumber">

    <select name="cookbook">
      <c:forEach items="${cookbookList}" var="cookbook">
        <option value="${cookbook.cookbookId}"
                <c:if test="${cookbook.cookbookId eq selectedCookbookId}">selected="selected"</c:if>>
            ${cookbook.title}
        </option>
      </c:forEach>
    </select>
  </div>
  <button type="submit" name="submit" value="addRecipe" class="btn btn-primary">Add Recipe</button>
</form>

</body>
</html>