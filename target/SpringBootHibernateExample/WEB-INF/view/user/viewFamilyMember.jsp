<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <title>Smart Home Surveillance</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Expires" content="-1">

        <!-- App favicon -->
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/fonts/Website-Favicon.ico">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/font-awesome.min.css">

        <!-- DataTables -->
        <link href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <!-- Responsive datatable examples -->
        <link href="<%=request.getContextPath()%>/adminResources/css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />

        <!-- App css -->
        <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/style.css" rel="stylesheet" type="text/css" />

        <script src="<%=request.getContextPath()%>/adminResources/js/modernizr.min.js"></script>

</head>
<body>

<!-- Begin page -->
        <div id="wrapper">

            <!-- Top Bar Start -->
            
            <jsp:include page="header.jsp"></jsp:include>
            
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->
            <div class="left side-menu">
                <div class="slimscroll-menu" id="remove-scroll">

                    <!--- Sidemenu -->
                    
					<jsp:include page="menu.jsp"></jsp:include>

                    <!-- Sidebar -->
                    <div class="clearfix"></div>

                </div>
                <!-- Sidebar -left -->

            </div>
            <!-- Left Sidebar End -->



            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <h4 class="page-title float-left">Family Member</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item">Manage Family Member</li>
                                        <li class="breadcrumb-item active">View Family Member</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-12">
                                <div class="card-box table-responsive">
                                    

																
									<table id="datatable" class="table table-bordered">
                                        <thead>
                                    	    <tr>
                                        		<th>ID</th>
                                            	<th>First Name</th>
                                            	<th>Last Name</th>
                                            	<th>Phone Number</th>
                                            	<th>E-Mail</th>
                                            	<th>Image1</th>
                                            	<th>Image2</th>
                                            	<th>Image3</th>
                                            	<th>Image4</th>
                                            	<th>Image5</th>
                                        	</tr>
                                        </thead>

                                        <tbody>
                                        	<c:set var="a" value="1"></c:set>
                                        	<c:forEach items="${familymemberList}" var="i">
                                        	<tr>
        	                                    <td>${a}</td><c:set value="${a+1}" var="a"></c:set>
	                                            <td>${i.familymemberFirstName}</td>
    	                                        <td>${i.familymemberLastName}</td>
            	                                <td>${i.familymemberPhoneNumber}</td>
                    	                        <td>${i.familymemberEmail}</td>
                    	                        <c:forEach items="${familymemberimageList}" var="j">
                    	                          <c:if test="${j.familyMemberVO.familymemberId eq i.familymemberId}">
                    	                                 <td><a href="<%=request.getContextPath()%>/documents/familymemberimages/${username}/${j.familymemberImageName}" target="_blank"><img src="<%=request.getContextPath()%>/documents/familymemberimages/${username}/${j.familymemberImageName}" style="max-height: 100px; max-width: 100px"></a></td>   
                    	                          </c:if>
                    	                      </c:forEach>
                            	            </tr>
                                        </c:forEach>
                                       </tbody>
                                    
                                    </table>			
                                </div>
                            </div>
                        </div> <!-- end row -->

                    </div> <!-- container -->

                </div> <!-- content -->

                <jsp:include page="footer.jsp"></jsp:include>

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/waves.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.slimscroll.js"></script>

        <!-- Required datatable js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.dataTables.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap4.min.js"></script>
        <!-- Buttons examples -->
        <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.buttons.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/buttons.bootstrap4.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jszip.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/pdfmake.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/vfs_fonts.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/buttons.html5.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/buttons.print.min.js"></script>
        <!-- Responsive examples -->
        <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.responsive.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/responsive.bootstrap4.min.js"></script>

        <!-- App js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#datatable').DataTable();

                //Buttons examples
                var table = $('#datatable-buttons').DataTable({
                    lengthChange: false,
                    buttons: ['copy', 'excel', 'pdf']
                });

                table.buttons().container()
                        .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
            } );

        </script>

</body>
</html>