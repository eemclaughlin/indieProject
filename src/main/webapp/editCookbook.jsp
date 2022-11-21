<%--
  User: eemclaughlin
  Date: 11/20/22
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Edit a Cookbook" />
<%@include file="head.jsp"%>
<html>
<body>

<h2>Edit a Cookbook</h2>

<form action="editCookbook" class="form-inline" method="post">
    <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" name="title"
               aria-describedby="titleHelp" placeholder="title"
               value="${editCookbook.title}">

        <label for="author">Author</label>
        <input type="text" class="form-control" id="author" name="author"
               aria-describedby="authorHelp" placeholder="author"
               value="${editCookbook.author}">

        <label for="publisher">Publisher</label>
        <input type="text" class="form-control" id="publisher" name="publisher"
               aria-describedby="publisherHelp" placeholder="publisher"
               value="${editCookbook.publisher}">

        <label for="publishedDate">Published Date</label>
        <input type="text" class="form-control" id="publishedDate" name="publishedDate"
               aria-describedby="publishedDateHelp" placeholder="publishedDate"
               value="${editCookbook.publishedDate}">

        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" name="description"
               aria-describedby="descriptionHelp" placeholder="description"
               value="${editCookbook.description}">

        <label for="isbnTen">Short ISBN</label>
        <input type="text" class="form-control" id="isbnTen" name="isbnTen"
               aria-describedby="isbnTenHelp" placeholder="isbnTen"
               value="${editCookbook.isdnTen}">

        <label for="isbnThirteen">Long ISBN</label>
        <input type="text" class="form-control" id="isbnThirteen" name="isbnThirteen"
               aria-describedby="isbnThirteenHelp" placeholder="isbnThirteen"
               value="${editCookbook.isdnThirteen}">

        <label for="pageCount">Total Page Count</label>
        <input type="text" class="form-control" id="pageCount" name="pageCount"
               aria-describedby="pageCountHelp" placeholder="pageCount"
               value="${editCookbook.pageCount}">

        <label for="language">Language</label>
        <input type="text" class="form-control" id="language" name="language"
               aria-describedby="languageHelp" placeholder="language"
               value="${editCookbook.language}">

        <label for="smallImageLink">Web Link to Small Image</label>
        <input type="text" class="form-control" id="smallImageLink" name="smallImageLink"
               aria-describedby="smallImageLinkHelp" placeholder="smallImageLink"
               value="${editCookbook.smallImageLink}">

        <label for="mediumImageLink">Web Link to Medium Image</label>
        <input type="text" class="form-control" id="mediumImageLink" name="mediumImageLink"
               aria-describedby="mediumImageLinkHelp" placeholder="mediumImageLink"
               value="${editCookbook.mediumImageLink}">

        <label for="notes">Notes</label>
        <input type="text" class="form-control" id="notes" name="notes"
               aria-describedby="notesHelp" placeholder="notes"
               value="${editCookbook.notes}">
    </div>
    <button type="submit" name="submit" value="editCookbook" class="btn btn-primary">Save Changes</button>
</form>

</body>
</html>
