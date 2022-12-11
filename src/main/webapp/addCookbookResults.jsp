<%--
  User: eemclaughlin
  Date: 12-10-22
  Page used to output the details of a newly added cookbook.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Add Cookbook Results" />
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
                    Added Cookbook: <small>This is the cookbook that was added.</small>
                </h1>
            </div>

            <!-- Table to display the details of a cookbook -->
            <div class="row py-2 my-2 border border-secondary">
                <table class="col-3 table table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Label</th>
                        <th scope="col">Value</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="table-secondary">
                        <th scope="row">Image</th>
                        <td><img id="cookbookCover" src="${newCookbookParts['cbSmallImageLink']}" alt="Image of Cookbook"></td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Title</th>
                        <td>${newCookbookParts['cbTitle']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Author</th>
                        <td>${newCookbookParts['cbAuthor']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Publisher</th>
                        <td>${newCookbookParts['cbPublisher']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Published Date</th>
                        <td>${newCookbookParts['cbPublishedDate']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Description</th>
                        <td>${newCookbookParts['cbDescription']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">ISBN-10</th>
                        <td>${newCookbookParts['cbIsdnTen']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">ISBN-13</th>
                        <td>${newCookbookParts['cbIsdnThirteen']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Page Count</th>

                        <c:if test="${newCookbookParts['cbPageCount'] == null}">
                            <td>N/A</td>
                        </c:if>
                        <c:if test="${newCookbookParts['cbPageCount'] != null}">
                            <td>${newCookbookParts['cbPageCount']}</td>
                        </c:if>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Language</th>
                        <td>${newCookbookParts['cbLanguage']}</td>
                    </tr>
                    <tr class="table-secondary">
                        <th scope="row">Notes</th>
                        <td>${newCookbookParts['cbNotes']}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <!-- Buttons to return to cookbook list, to edit the cookbook info, or to delete the cookbook -->
            <div class="row mb-4 ">
                <div class="col-2">
                    <a class="btn btn-warning btn-large text-dark" href="listCookbooks"><strong>Complete Add</strong></a>
                </div>
                <div class="col-2">
                    <a class="btn btn-warning btn-large text-dark" href="editCookbook?cookbookId=${newCookbookParts['cbId']}"><strong>Edit Information</strong></a>
                </div>
                <div class="col-auto">
                    <a class="btn btn-danger btn-large text-light" href="deleteCookbook?cookbookId=${newCookbookParts['cbId']}"><strong>Do Not Add</strong></a>
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

