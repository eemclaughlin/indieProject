<%--
  User: eemclaughlin
  Date: 10/31/22
  Page to allow users to enter an ISBN and add a cookbook to their listing.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Add a Cookbook" />
<%@include file="head.jsp"%>
<html>
<body>

<h2>Add a Cookbook</h2>

<form action="addCookbook" class="form-inline">
    <div class="form-group">
        <label for="isbn">ISBN</label>
        <input type="text" class="form-control" id="isbn" name="isbn"
               aria-describedby="isbnHelp" placeholder="isbn">
        <label for="cookbookNotes">Notes</label>
        <input type="text" class="form-control" id="cookbookNotes" name="cookbookNotes"
               aria-describedby="cookbookNotes" placeholder="Any notes about this cookbook">
    </div>
    <button type="submit" name="submit" value="addCookbook" class="btn btn-primary">Add Cookbook</button>
    <!--TODO Maybe direct to page with info about the cookbook and ask user to confirm -->
</form>

<p><a href="addCookbookManually.jsp">Add a Cookbook Manually</a></p>

</body>
</html>
