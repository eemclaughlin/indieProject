<%--
  User: eemclaughlin
  Date: 12-10-22
  Version: 3.0
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

            <!-- Form to allow user to enter an ISBN number and notes on a cookbook -->
            <div class="row">
                <div class="col-lg-5">
                    <form role="form" action="addCookbook">
                        <div class="form-group mx-3 mb-3">
                            <label for="isbn" class="mb-1">ISBN</label>
                            <input type="text" class="form-control" id="isbn"
                                   name="isbn" aria-describedby="isbnHelp"
                                   placeholder="Ex. 978-0-672-33795-6 or 0-672-33795-9 or 9780672337956" required>
                        </div>
                        <div class="form-group m-3">
                            <label for="cookbookNotes" class="mb-1">Notes</label>
                            <textarea type="text" class="form-control" id="cookbookNotes"
                                      name="cookbookNotes" aria-describedby="notesHelp"
                                      placeholder="Personal notes about the cookbook"
                                      rows="4"></textarea>
                        </div>

                        <!-- Button to return to the cookbook list -->
                        <a class="btn btn-warning btn-large text-dark ms-3 me-1" href="listCookbooks"><strong>Return To List</strong></a>

                        <!-- Button to submit the form -->
                        <button type="submit" name="submit" value="addCookbook"
                                class="btn btn-warning text-dark mx-3 my-2"><strong>Add Cookbook</strong>
                        </button>

                        <!-- Link for user to use if the ISBN data is not available -->
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

