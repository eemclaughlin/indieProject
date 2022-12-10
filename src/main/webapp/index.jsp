<%--
  User: eemclaughlin
  Date: 12-10-22
  Version: 3.0
  Main landing page for the site
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="RecipeWhere?" />
<%@include file="/includes/head.jsp"%>
<html>
<body>

<c:choose>
<c:when test="${empty userName}">
<div class="container-fluid" id="wrapper">
<div class="row">
<div class="col-12">

    <!-- Custom navbar with only one option to log in -->
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

    <div class="container px-4 px-lg-5">
        <!-- Heading Row-->
        <div class="row gx-4 gx-lg-5 align-items-center my-5">
            <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0" src="images/FeatureImage1.png" alt="..." /></div>
            <div class="col-lg-5">
                <h1 class="font-weight-light">RecipeWhere?</h1>
                <p>Welcome to "RecipeWhere?".  This is a great and simple place to keep track of all your physical recipes and cookbooks.</p>
                <a class="btn btn-primary" href="logIn">Sign In/Sign Up</a>
            </div>
        </div>
        <!-- Call to Action-->
        <div class="card text-white bg-warning my-5 py-4 text-center">
            <div class="card-body"><p class="text-dark m-0"><strong>Never lose a recipe again!  Track your favorite recipes by cookbook and page number and you'll always know where it is.</strong></p></div>
        </div>
        <!-- Content Row/Cards -->
        <div class="row gx-4 gx-lg-5n ">
            <div class="col-md-4 mb-5">
                <div class="card h-100">
                    <div class="card-body bg-light">
                        <h2 class="card-title">Recipes</h2>
                        <p class="card-text">Enter your recipe name and description and any personal notes about the recipe.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-5">
                <div class="card h-100">
                    <div class="card-body bg-light">
                        <h2 class="card-title">Cookbooks</h2>
                        <p class="card-text">Enter a cookbook by ISBN number or  manually. Also, add any personal notes about a cookbook.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-5">
                <div class="card h-100">
                    <div class="card-body bg-light">
                        <h2 class="card-title">Recipe Tracking</h2>
                        <p class="card-text">Associate your recipe with a cookbook and note the page number.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class ="row mb-5">
        <div class="col mb-2"></div>
    </div>

    <!-- Brings in the Footer -->
    <%@include file="/includes/footer.jsp"%>

</div>
</div>
</div>

</c:when>
<c:otherwise>

    <!-- redirect page to userHomepage -->
    <c:redirect url="/userHomepage" />

</c:otherwise>
</c:choose>

    <!-- Reference to JavaScript Sources -->
    <%@include file="/includes/javascript.jsp"%>

</body>
</html>

