<%--
  User: eemclaughlin
  Date: 12-11-2022
  Version: 3.0
  No ISBN Found Error Page with options for the user.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="Error" />
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
                    Search Issue: <small>ISBN Not Found</small>
                </h1>
            </div>

            <!-- Status message and links for user to proceed how they like. -->
            <div class="row">
                <p>The entered ISBN was not found. You may need to enter the book manually or try again</p>
                    <table>
                        <tr>
                            <th><strong>Links</strong></th>
                        </tr>
                        <tr>
                            <td><a href="addCookbookManually.jsp">Add Cookbook Manually</a><br></td>
                        </tr>
                        <tr>
                            <td><a href="addCookbook.jsp">Try Another ISBN</a><br></td>
                        </tr>
                        <tr>
                            <td><a href="listCookbooks">Return to Cookbooks List</a><br></td>
                        </tr>
                        <tr>
                            <td><a href="userHomepage">Return Home</a></td>
                        </tr>
                    </table>
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

