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

<h2>Add a Cookbook Manually</h2>

<form action="addCookbookManually" class="form-inline">
    <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" name="title"
               aria-describedby="titleHelp" placeholder="title">
        <label for="author">Author</label>
        <input type="text" class="form-control" id="author" name="author"
               aria-describedby="authorHelp" placeholder="Author">
        <label for="publisher">Publisher</label>
        <input type="text" class="form-control" id="publisher" name="publisher"
               aria-describedby="publisherHelp" placeholder="Publisher">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" name="description"
               aria-describedby="descriptionHelp" placeholder="Description">
        <label for="isbnTen">ISBN-10</label>
        <input type="text" class="form-control" id="isbnTen" name="isbnTen"
               aria-describedby="isbnTenHelp" placeholder="ISBN-10">
        <label for="isbnThirteen">ISBN-13</label>
        <input type="text" class="form-control" id="isbnThirteen" name="isbnThirteen"
               aria-describedby="isbnThirteenHelp" placeholder="ISBN-13">
        <label for="pageCount">Page Count</label>
        <input type="text" class="form-control" id="pageCount" name="pageCount"
               aria-describedby="pageCountHelp" placeholder="Page Count">
        <label for="language">Language</label>
        <input type="text" class="form-control" id="language" name="language"
               aria-describedby="languageHelp" placeholder="Enter 2 Letters for Language">
        <label for="notes">Notes</label>
        <input type="text" class="form-control" id="notes" name="notes"
               aria-describedby="notesHelp" placeholder="Notes">

    </div>
    <button type="submit" name="submit" value="addCookbookManually" class="btn btn-primary">Add Cookbook</button>
    <!-- TODO Maybe direct to page with info about the cookbook and ask user to confirm -->
</form>

</body>
</html>
