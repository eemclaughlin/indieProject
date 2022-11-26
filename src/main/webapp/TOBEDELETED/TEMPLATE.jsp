<%--
  User: eemclaughlin
  Date: 11/25/22
  Page used to output all the details of a single cookbook and ask for editing/deleting.
--%>
<%@include file="/includes/taglib.jsp"%>
<c:set var="title" value="List Cookbooks" />
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
                    Cookbooks: <small>A listing of all your cookbooks.</small>
                </h1>
            </div>
            <!-- START INDIVIDUAL PAGE CODE HERE -->


            <!-- END OF INDIVIDUAL PAGE CODE -->
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

