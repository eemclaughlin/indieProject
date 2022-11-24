<%--
  User: eemclaughlin
  Date: 11/24/22
  Page for users to see all the cookbooks that they have available.
--%>
<%@include file="/imports/taglib.jsp"%>
<c:set var="title" value="List Cookbooks" />
<%@include file="/imports/head.jsp"%>
<html>
<body>

<div class="container-fluid">
<div class="row">
<div class="col-md-12">

    <!-- Brings in the NavBar -->
    <%@include file="/imports/navbar.jsp"%>

    <!-- Page Header -->
    <div class="page-header">
        <h1>
            Cookbooks <small>A listing of all your cookbooks.</small>
        </h1>
    </div>

    <!-- Call to add more cookbooks -->
    <div class="jumbotron">
        <p>
            Use the button below to add another cookbook to your collection.
        </p>
        <p>
            <a class="btn btn-primary btn-large" href="addCookbook.jsp">Add a Cookbook</a>
        </p>
    </div>

    <!-- Bring in each cookbook and display it in a row -->
    <c:forEach var="cookbook" items="${cookbooks}">
    <div class="row">
        <div class="col-md-3">
            <img alt="Cookbook Cover" src="${cookbook.smallImageLink}">
        </div>
        <div class="col-md-4">
            <h2>${cookbook.title}</h2>
            <p>
                <strong>Author: </strong>${cookbook.author}<br>
                <strong>Publisher: </strong>${cookbook.publisher}
            </p>
            <p>
                <a class="btn" href="detailCookbook?cookbookId=${cookbook.cookbookId}">View details »</a>
            </p>
        </div>
        <div class="col-md-5">
            <h2>
                Notes
            </h2>
            <p>${cookbook.notes}</p>
        </div>
    </div>
    </c:forEach>

    <!-- Brings in the Footer -->
    <%@include file="/imports/footer.jsp"%>

</div>
</div>
</div>

</body>
</html>
