<%--
  User: eemclaughlin
  Date: 12-10-22
  Version: 3.0
  Page used to output all the details of a single cookbook and ask for editing/deleting.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Cookbook Details" />
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
                    Cookbook Details: <small>A detailed view of a cookbook</small>
                </h1>
            </div>

            <!-- Table to output the details of the cookbook -->
            <div class="row py-2 my-2 border border-secondary">
                <div>
                    <table class="col-3 table table-striped table-hover">
                        <thead>
                        <tr class="table-secondary">
                            <th scope="row"><u>Label</u></th>
                            <th scope="col"><u>Value</u></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="table-secondary">
                            <th scope="row">Image</th>
                            <td><img id="cookbookCover" src="${detailCookbook.smallImageLink}" alt="Image of Cookbook"></td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Title</th>
                            <td>${detailCookbook.title}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Author</th>
                            <td>${detailCookbook.author}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Publisher</th>
                            <td>${detailCookbook.publisher}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Published Date</th>
                            <td>${detailCookbook.publishedDate}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Description</th>
                            <td>${detailCookbook.description}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">ISBN-10</th>
                            <td>${detailCookbook.isdnTen}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">ISBN-13</th>
                            <td>${detailCookbook.isdnThirteen}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Page Count</th>

                            <c:if test="${detailCookbook.pageCount == null}">
                                <td>N/A</td>
                            </c:if>
                            <c:if test="${detailCookbook.pageCount != null}">
                                <td>${detailCookbook.pageCount}</td>
                            </c:if>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Language</th>
                            <td>${detailCookbook.language}</td>
                        </tr>
                        <tr class="table-secondary">
                            <th scope="row">Notes</th>
                            <td>${detailCookbook.notes}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Warning message to user about deleting. -->
            <p class="text-danger"><strong>Important!  Deleting a cookbook will also remove the recipes associated with it!</strong></p>

            <!-- Buttons to return to list, edit the cookbook, or delete it -->
            <div class="row mb-4">
                <div class="col-12 col-md-2 m-1">
                    <a class="btn btn-warning btn-large text-dark" href="listCookbooks"><strong>Return To List</strong></a>
                </div>
                <div class="col-12 col-md-2 m-1">
                    <a class="btn btn-warning btn-large text-dark" href="editCookbook?cookbookId=${detailCookbook.cookbookId}"><strong>Edit Cookbook</strong></a>
                </div>
                <div class="col-12 col-md-2 m-1">
                    <a class="btn btn-danger btn-large text-light" href="deleteCookbook?cookbookId=${detailCookbook.cookbookId}"><strong>Delete Cookbook</strong></a>
                </div>
            </div>

            <div class="row mb-5">
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

