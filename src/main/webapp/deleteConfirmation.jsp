<%--
  User: eemclaughlin
  Date: 11/25/22
  Page used to output a confirmation that an item is deleted.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Confirm Deleted" />
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
                    Delete Confirmed: <small>Confirmation of Deletion</small>
                </h1>
            </div>

            <h1 class="my-5">Your item was successfully deleted!</h1>

            <div class="row ms-4">
                <table>
                    <tr>
                        <th><strong>Links</strong>
                        </th>
                    </tr>
                    <tr>
                        <td><a href="listCookbooks">Return to Cookbooks List</a><br></td>
                    </tr>
                    <tr>
                        <td><a href="userHomepage">Return to Recipes List</a></td>
                    </tr>
                    <tr>
                        <td><a href="addRecipe">Add a New Recipe</a><br></td>
                    </tr>
                    <tr>
                        <td><a href="addCookbook.jsp">Add a New Cookbook</a><br></td>
                    </tr>
                </table>
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

