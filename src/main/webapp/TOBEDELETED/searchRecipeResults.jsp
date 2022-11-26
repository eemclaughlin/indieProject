<%@include file="taglib.jsp"%>
<c:set var="title" value="Recipe Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#recipeTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>Recipe Search Results: </h2>
    <table id="recipeTable" class="display" cellspacing="0" width="100%">
        <thead>
            <th>Recipe Name</th>
            <th>Description Id</th>
            <th>Notes</th>
            <th>Page Number</th>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${recipes}">
            <tr>
                <td>${recipe.recipeName}</td>
                <td>${recipe.description}</td>
                <td>${recipe.notes}</td>
                <td>${recipe.pageNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
