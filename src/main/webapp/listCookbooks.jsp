<%--
  User: eemclaughlin
  Date: 11/24/22
  Page for users to see all the cookbooks that they have available.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="List Cookbooks" />
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
                    Cookbooks: <small>A listing of all your cookbooks.</small>
                </h1>
            </div>

            <!-- Call to add more cookbooks -->
            <div class="row">
                <div class="jumbotron bg-secondary mb-4 d-flex">
                    <h5 class="pt-4">
                        Add another cookbook to your collection?
                    </h5>
                    <p class="ps-2 pt-3">
                        <a class="btn btn-warning btn-large text-dark" href="addCookbook.jsp"><strong>Add a Cookbook</strong></a>
                    </p>
                </div>
            </div>

            <!-- Dropdown to allow user to sort the cookbooks -->
            <!-- Reference: https://stackoverflow.com/questions/6847089/how-to-reload-a-page-based-on-a-dropdown-box -->
            <div class="row">
                <div class="d-flex col-12 col-md-4 my-3-md my-1 mb-4">
                    <label for="sortByList" class="form-label d-flex col-2 me-2 align-items-end justify-content-end">Sort By</label>
                    <select id="sortByList" name="sortByItem" class="form-select col col-md-10" onchange="window.location = 'listCookbooks?sortBy=' + this.options[this.selectedIndex].value;">
                        <option value="cookbookName" <c:if test="${sortBy == 'recipeName'}"> onclick="window.location = 'listCookbooks?sortBy=' + this.value;" selected</c:if>>Cookbook Name</option>
                        <option value="cookbookAuthor" <c:if test="${sortBy == 'cookbookName'}"> onclick="window.location = 'listCookbooks?sortBy=' + this.value;" selected</c:if>>Cookbook Author</option>
                        <option value="cookbookPublisher" <c:if test="${sortBy == 'cookbookAuthor'}"> onclick="window.location = 'listCookbooks?sortBy=' + this.value;" selected</c:if>>Cookbook Publisher</option>
                    </select>
                </div>

                <div class="d-xs-none col-md-1 d-flex my-3-md my-1 mb-4">
                </div>

                <!-- Search bar to allow user to search -->
                <div class="col d-flex my-3-md my-1 mb-4">
                    <label for="search" class="form-label d-flex col-2 me-2 align-items-end justify-content-end">Search</label>
                    <!-- Search for a cookbook once enter is pressed -->
                    <input type="text" class="form-control" name="search"
                           aria-describedby="searchHelp" id="search" placeholder="Search for a Recipe"
                           onkeyup="if (event.keyCode === 13) {window.location = 'searchCookbook?search=' + this.value;}">
                </div>
            </div>

            <!-- If there are no cookbooks, display a message -->
            <c:if test="${cookbooks.size() == 0}">
                <div class="row">
                    <div class="jumbotron text-dark m-2 d-flex">
                        <h5 class="p-2"><strong>You don't have any cookbooks yet!</strong></h5>
                    </div>
                </div>
            </c:if>
            <!-- Bring in each cookbook and display it in a row -->
            <c:if test="${cookbooks.size() != 0}">
                <c:forEach var="cookbook" items="${cookbooks}">
                    <div class="row my-2 border border-secondary">
                        <div class="col-md-2 bg-light d-flex align-items-center">
                            <img id="cookbookCover" alt="Cookbook Cover" src="${cookbook.smallImageLink}">
                        </div>
                        <div class="col-md-4 bg-light">
                            <h3>${cookbook.title}</h3>
                            <p>
                                <strong>Author: </strong>${cookbook.author}<br>
                                <strong>Publisher: </strong>${cookbook.publisher}
                            </p>
                            <p>
                                <a class="btn btn-dark btn-sm" href="detailCookbook?cookbookId=${cookbook.cookbookId}">View details</a>
                            </p>
                        </div>
                        <div class="col-md-6 bg-light">
                            <h2>
                                Notes
                            </h2>
                            <p>${cookbook.notes}</p>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

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
