<%@include file="taglib.jsp"%>
<c:set var="title" value="User Homepage" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#recipeTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>User Homepage: </h2>
    <p>Currently always defaults to Johnny Cash's recipes.</p>
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
