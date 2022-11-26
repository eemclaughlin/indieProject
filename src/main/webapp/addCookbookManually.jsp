<%--
  User: eemclaughlin
  Date: 11/25/22
  Page used to allow user to enter info about a cookbook manually.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Manual Cookbook Addition" />
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
                    Enter Cookbook Data: <small>Enter a cookbook manually.</small>
                </h1>
            </div>

            <div class="row">
                <div class="col-md-5">
                    <form role="form" action="addCookbookManually">
                        <div class="form-group mx-3 mb-3">
                            <label for="title" class="mb-1">Title</label>
                            <input type="text" class="form-control" id="title"
                                   name="title" aria-describedby="titleHelp"
                                   placeholder="Ex. Cooking For Dummies" required>
                        </div>
                        <div class="form-group m-3">
                            <label for="author" class="mb-1">Author</label>
                            <input type="text" class="form-control" id="author"
                                   name="author" aria-describedby="authorHelp"
                                   placeholder="Ex. Rachel Ray">
                        </div>
                        <div class="form-group m-3">
                            <label for="publisher" class="mb-1">Publisher</label>
                            <input type="text" class="form-control" id="publisher"
                                   name="publisher" aria-describedby="publisherHelp"
                                   placeholder="Publisher">
                        </div>
                        <div class="form-group m-3">
                            <label for="description" class="mb-1">Description</label>
                            <textarea type="text" class="form-control" id="description"
                                      name="description" aria-describedby="descriptionHelp"
                                      placeholder="Description of the book or info from the back cover."
                                      rows="4"></textarea>
                        </div>
                        <div class="form-group m-3">
                            <label for="isbnTen" class="mb-1">ISBN-10</label>
                            <input type="text" class="form-control" id="isbnTen"
                                   name="isbnTen" aria-describedby="isbnTenHelp"
                                   placeholder="Ex. 0-672-33795-9">
                        </div>
                        <div class="form-group m-3">
                            <label for="isbnThirteen" class="mb-1">ISBN-13</label>
                            <input type="text" class="form-control" id="isbnThirteen"
                                   name="isbnThirteen" aria-describedby="isbnThirteenHelp"
                                   placeholder="Ex. 978-0-672-33795-6">
                        </div>
                        <div class="form-group m-3">
                            <label for="pageCount" class="mb-1">Page Count</label>
                            <input type="number" class="form-control" id="pageCount"
                                   name="pageCount" aria-describedby="pageCountHelp"
                                   placeholder="Number of pages">
                            <div class="invalid-feedback">
                                Please enter a number.
                            </div>
                        </div>
                        <div class="form-group m-3">
                            <label for="language" class="mb-1">Language</label>
                            <input type="text" class="form-control" id="language"
                                   name="language" aria-describedby="languageHelp"
                                   placeholder="Enter 2 Letters for Language">
                        </div>
                        <div class="form-group m-3">
                            <label for="notes" class="mb-1">Notes</label>
                            <textarea type="text" class="form-control" id="notes"
                                      name="notes" aria-describedby="notesHelp"
                                      placeholder="Personal notes about the cookbook"
                                      rows="4"></textarea>
                        </div>

                        <button type="submit" name="submit" value="addCookbookManually"
                                class="btn btn-warning text-dark mx-3 my-2">Add Cookbook
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

