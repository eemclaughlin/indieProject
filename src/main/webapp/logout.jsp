<%--
  User: eemclaughlin
  Date: 12-10-22
  Version: 3.0
  Page used to confirm user is logged out and offer links to log back in.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Logout" />
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
                    Logged Out: <small>You have been logged out.</small>
                </h1>
            </div>

            <div class="row">
                <c:if test="${userName == null}">
                    <h2>You are logged out</h2>
                    <h3><a href="logIn">Log Back In</a></h3>
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

