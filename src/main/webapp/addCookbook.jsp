<%--
  User: eemclaughlin
  Date: 11/25/22
  Page used to allow user to enter info about a cookbook by entering an ISBN number.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Add a Cookbook" />
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
                    Enter Cookbook ISBN: <small>Add a cookbook with an ISBN number.</small>
                </h1>
            </div>

            <div class="row">
                <div class="col-md-5">
                    <form role="form" action="addCookbook">
                        <div class="form-group mx-3 mb-3">
                            <label for="isbn" class="mb-1">ISBN</label>
                            <input type="text" class="form-control" id="isbn"
                                   name="isbn" aria-describedby="isbnHelp"
                                   placeholder="Ex. 978-0-672-33795-6 or 0-672-33795-9 or 9780672337956" required>
                        </div>
                        <div class="form-group m-3">
                            <label for="notes" class="mb-1">Notes</label>
                            <textarea type="text" class="form-control" id="notes"
                                      name="notes" aria-describedby="notesHelp"
                                      placeholder="Personal notes about the cookbook"
                                      rows="4"></textarea>
                        </div>

                        <button type="submit" name="submit" value="addCookbook"
                                class="btn btn-warning text-dark mx-3 my-2">Add Cookbook
                        </button>
                        <!--TODO Maybe direct to page with info about the cookbook and ask user to confirm -->

                        <div class="mt-3 mx-3">
                            <p><a href="addCookbookManually.jsp"><strong>No ISBN?  Add a Cookbook Manually.</strong></a></p>
                        </div>
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

