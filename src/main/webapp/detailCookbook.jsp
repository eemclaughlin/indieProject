<%--
  User: eemclaughlin
  Date: 11/22/22
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Cookbook Details" />
<%@include file="head.jsp"%>
<html>
<body>

<h2>Cookbook Details</h2>

<p><img src="${detailCookbook.mediumImageLink}" alt="Image of Cookbook"></img></p>
<p>${detailCookbook.title}"</p>
<p>${detailCookbook.author}"</p>
<p>${detailCookbook.publisher}"</p>
<p>${detailCookbook.publishedDate}"</p>
<p>${detailCookbook.description}"</p>
<p>${detailCookbook.isdnTen}"</p>
<p>${detailCookbook.isdnThirteen}"</p>
<c:if test="${detailCookbook.pageCount == null}">
    <p>Page Count: N/A</p>
</c:if>
<c:if test="${detailCookbook.pageCount != null}">
    <p>Page Count: ${detailCookbook.pageCount}</p>
</c:if>
<p>${detailCookbook.pageCount}"</p>
<p>${detailCookbook.language}"</p>
<p>${detailCookbook.notes}"</p>

<p><a href="editCookbook?cookbookId=${detailCookbook.cookbookId}">Edit ${detailCookbook.cookbookId}</a></p>
<p><a href="deleteRecipe.jsp?recipeId=${recipe.recipeId}">Delete ${recipe.recipeId}</a></p>


</body>
</html>
