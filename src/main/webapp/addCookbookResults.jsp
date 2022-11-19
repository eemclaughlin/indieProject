<%--
  User: eemclaughlin
  Date: 11/1/22
  Displays info on the cookbook that was just added.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Add Cookbook Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#recipeTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>This Cookbook was Just Added: </h2>
    <p>Currently always defaults to Johnny Cash's recipes.</p>
    <table id="recipeTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th></th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Published Date</th>
        <th>Description</th>
        <th>Short ISBN</th>
        <th>Long ISBN</th>
        <th>Page Count</th>
        <th>Notes</th>
        </thead>
        <tbody>
            <tr>
                <td><img src="${newCookbookParts['cbSmallImageLink']}" alt="Image of Cookbook"></img></td>
                <td>${newCookbookParts['cbTitle']}</td>
                <td>${newCookbookParts['cbAuthor']}</td>
                <td>${newCookbookParts['cbPublisher']}</td>
                <td>${newCookbookParts['cbPublishedDate']}</td>
                <td>${newCookbookParts['cbDescription']}</td>
                <td>${newCookbookParts['cbIsdnTen']}</td>
                <td>${newCookbookParts['cbIsdnThirteen']}</td>
                <td>${newCookbookParts['cbPageCount']}</td>
                <td>${newCookbookParts['cbNotes']}</td>
            </tr>

        <div>
            <p>Links</p>
            <a href="userHomepage">Home</a><br>
            <a href="listCookbooks">List of Cookbooks</a><br>
            <a href="searchRecipe.jsp">Search Page</a><br>
            <a href="addRecipe">Add a New Recipe</a><br>
            <a href="addCookbook.jsp">Add another Cookbook</a><br>
            <a href="logout">LogOut</a><br>
        </div>
        </tbody>
    </table>
</div>

</body>
</html>
