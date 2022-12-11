<%--
  User: eemclaughlin
  Date: 12-11-2022
  Version: 3.0
  No ISBN Found Error Page with options for the user.
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
                    Error: <small>ISBN Not Found</small>
                </h1>
            </div>

            <!-- Error Message and links to locations, if user is logged in still -->
            <div class="row">
                <p>The entered ISBN was not found. You may need to enter the book manually or try again</p>
                    <table>
                        <tr>
                            <th><strong>Links</strong></th>
                        </tr>
                        <tr>
                            <td><a href="addCookbookManually.jsp">Add Cookbook Manually</a><br></td>
                        </tr>
                        <tr>
                            <td><a href="addCookbook.jsp">Try Another ISBN</a><br></td>
                        </tr>
                        <tr>
                            <td><a href="listCookbooks">Return to Cookbooks List</a><br></td>
                        </tr>
                        <tr>
                            <td><a href="userHomepage">Return Home</a></td>
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

