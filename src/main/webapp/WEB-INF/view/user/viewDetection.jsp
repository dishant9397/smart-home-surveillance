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

		<!-- Plugins css -->
        <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap-timepicker.min.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap-colorpicker.min.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap-clockpicker.min.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/adminResources/css/daterangepicker.css" rel="stylesheet" type="text/css">
        
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
                                    <h4 class="page-title float-left">Detection</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item">Manage Detection</li>
                                        <li class="breadcrumb-item active">View Detection</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->
						
                        <form action="searchDetection" method="post">
                        <div class="row">
                            <div class="col-12">
                                <div class="card-box table-responsive">
                                   <div class="form-group row">
	                        			<input type="hidden" value="${username}" id="username">
					                        
											<label class="col-0.5 col-form-label" style="padding-left: 30px">Date</label>
	                        				
	                        				<div class="col-3">
					                            		<input class="form-control input-daterange-datepicker" required="required" type="text" name="detectedDate"/>
					                       	</div>
					                       	
					                       	<div class="col-auto">
                                           		<button type="submit" class="btn btn-gradient waves-effect waves-light">Search</button>
                                           	</div>
                                           	
                                           	<div class="col-auto">
                                           		<button type="button" onclick="fn1()" class="btn btn-gradient waves-effect waves-light">Detection</button>
                                           	</div>
					                    </div>
					                </form>
					                
									<table id="datatable" class="table table-bordered">
                                        <thead>
                                    	    <tr>
                                        		<th>ID</th>
                                            	<th>Detected Date</th>
                                            	<th>Detected Time</th>
                                            	<th>Detected Image of the Person</th>
                                        	</tr>
                                        </thead>

                                        <tbody>
                                        	<c:set var="a" value="1"></c:set>
                                        	<c:forEach items="${detectionList}" var="i">
                                        	<tr>
        	                                    <td>${a}</td><c:set value="${a+1}" var="a"></c:set>
	                                            <td>${i.indiandate}</td>
    	                                        <td>${i.time}</td>
            	                                <td><a href="<%=request.getContextPath()%>/documents/familymemberimages/${i.username}/Unauthorized Images/${i.imageName}" target="_blank"><img src="<%=request.getContextPath()%>/documents/familymemberimages/${i.username}/Unauthorized Images/${i.imageName}" style="max-height: 100px; max-width: 100px"></a></td>
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

        <!-- plugin js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/moment.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap-timepicker.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap-colorpicker.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap-clockpicker.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/daterangepicker.js"></script>

        <!-- Init js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.form-pickers.init.js"></script>
        
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
        
        <script type="text/javascript" >
		function fn1()
		{					
			var username = document.getElementById("username").value;
			var htp=new XMLHttpRequest();
			htp.onreadystatechange=function()
			{
				if(htp.readyState==4)
				{
					alert(htp.responseText);
				}
			}
			htp.open("get"," http://127.0.0.1:5011/?userName="+username+"",true);
			htp.send();
		}
		</script>

</body>
</html>