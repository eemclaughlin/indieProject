<%--
  User: eemclaughlin
  Date: 11/25/22
  Page used to allow user to edit info about a cookbook.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Edit a Cookbook" />
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
                    Edit Cookbook: <small>Change data about a cookbook.</small>
                </h1>
            </div>

            <div class="row">
                <div class="col-md-5">
                    <form role="form" action="editCookbook" method="post">
                        <div class="form-group mx-3 mb-3">
                            <label for="title" class="mb-1">Title</label>
                            <input type="text" class="form-control" id="title"
                                   name="title" aria-describedby="titleHelp"
                                   placeholder="Ex. Cooking For Dummies" required
                                   value="${editCookbook.title}">
                        </div>
                        <div class="form-group m-3">
                            <label for="author" class="mb-1">Author</label>
                            <input type="text" class="form-control" id="author"
                                   name="author" aria-describedby="authorHelp"
                                   placeholder="Ex. Rachel Ray"
                                   value="${editCookbook.author}">
                        </div>
                        <div class="form-group m-3">
                            <label for="publisher" class="mb-1">Publisher</label>
                            <input type="text" class="form-control" id="publisher"
                                   name="publisher" aria-describedby="publisherHelp"
                                   placeholder="Publisher"
                                   value="${editCookbook.publisher}">
                        </div>
                        <div class="form-group m-3">
                            <label for="publishedDate">Published Date</label>
                            <input type="date" class="form-control" id="publishedDate" name="publishedDate"
                                   aria-describedby="publishedDateHelp" placeholder="Date Published Ex. 2018-11-09"
                                   value="${editCookbook.publishedDate}">
                        </div>
                        <div class="form-group m-3">
                            <label for="description" class="mb-1">Description</label>
                            <textarea type="text" class="form-control" id="description"
                                      name="description" aria-describedby="descriptionHelp"
                                      placeholder="Description of the book or info from the back cover."
                                      rows="4">${editCookbook.description}</textarea>
                        </div>
                        <div class="form-group m-3">
                            <label for="isbnTen" class="mb-1">ISBN-10</label>
                            <input type="text" class="form-control" id="isbnTen"
                                   name="isbnTen" aria-describedby="isbnTenHelp"
                                   placeholder="Ex. 0-672-33795-9"
                                   value="${editCookbook.isdnTen}">
                        </div>
                        <div class="form-group m-3">
                            <label for="isbnThirteen" class="mb-1">ISBN-13</label>
                            <input type="text" class="form-control" id="isbnThirteen"
                                   name="isbnThirteen" aria-describedby="isbnThirteenHelp"
                                   placeholder="Ex. 978-0-672-33795-6"
                                   value="${editCookbook.isdnThirteen}">
                        </div>
                        <div class="form-group m-3">
                            <label for="pageCount" class="mb-1">Page Count</label>
                            <input type="number" class="form-control" id="pageCount"
                                   name="pageCount" aria-describedby="pageCountHelp"
                                   placeholder="Number of pages"
                                   value="${editCookbook.pageCount}">
                            <div class="invalid-feedback">
                                Please enter a number.
                            </div>
                        </div>
                        <div class="form-group m-3">
                            <label for="language" class="mb-1">Language</label>
                            <input type="text" class="form-control" id="language"
                                   name="language" aria-describedby="languageHelp"
                                   placeholder="Enter 2 Letters for Language"
                                   value="${editCookbook.language}">
                        </div>
                        <div class="form-group m-3">
                            <label for="smallImageLink">Web Link to Small Image</label>
                            <input type="text" class="form-control" id="smallImageLink" name="smallImageLink"
                                   aria-describedby="smallImageLinkHelp" placeholder="Link to Small Image"
                                   value="${editCookbook.smallImageLink}">
                        </div>
                        <div class="form-group m-3">
                            <label for="mediumImageLink">Web Link to Medium Image</label>
                            <input type="text" class="form-control" id="mediumImageLink" name="mediumImageLink"
                                   aria-describedby="mediumImageLinkHelp" placeholder="Link to Medium Image"
                                   value="${editCookbook.mediumImageLink}">
                        </div>
                        <div class="form-group m-3">
                            <label for="notes" class="mb-1">Notes</label>
                            <textarea type="text" class="form-control" id="notes"
                                      name="notes" aria-describedby="notesHelp"
                                      placeholder="Personal notes about the cookbook"
                                      rows="4">${editCookbook.notes}</textarea>
                        </div>

                        <button type="submit" name="submit" value="editCookbook"
                                class="btn btn-warning text-dark mx-3 my-2">Submit Change
                        </button>
                    </form>
                </div>
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

