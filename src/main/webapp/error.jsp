<%--
  User: eemclaughlin
  Date: 12-04-2022
  Version: 3.0
  General error page
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Error" />
<%@include file="/includes/head.jsp"%>
<html>
<body>

<div class="container-fluid" id="wrapper">
<div class="row">
<div class="col-12">

    <!-- Custom navbar with only one option to log back in -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
        <!-- Main Title Button on NavBar -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="navbar-toggler-icon"></span>
        </button> <a class="navbar-brand ms-3" href="index.jsp">RecipeWhere?</a>

        <!-- Additional Left Side Buttons on NavBar -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="navbar-nav d-flex ms-auto pe-3">
                <li class="nav-item active">
                    <a class="nav-link" href="logIn">Login</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container align-items-center">
        <div class="col-12">

            <!-- Page Header -->
            <div class="page-header my-3 py-2">
                <h1>
                    Error: <small>There has been an error.</small>
                </h1>
            </div>

            <!-- Error Message and links to locations, if user is logged in still -->
            <div class="row">
                <c:if test="${userName == null}">
                    <h2>You are logged out</h2>
                    <h3><a href="logIn">Log Back In</a></h3>
                </c:if>
                <c:if test="${userName != null}">
                    <table>
                        <tr>
                            <th><strong>Links</strong></th>
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
                </c:if>
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

