<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <title>Smart Home Surveillance</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <!-- App favicon -->
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/fonts/Website-Favicon.ico">

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
                                    <h4 class="page-title float-left">Dashboard</h4>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            
                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-head float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Family Members</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${totalFamilyMemberList}</h4>
                                </div>
                            </div>
                            
                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-mail float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Complains</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${totalComplainList}</h4>
                                </div>
                            </div>

                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-mail float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Pending Complains</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${pendingComplainList}</h4>
                                </div>
                            </div>
                            
                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-air-play float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Detected People</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${detectionList}</h4>
                                </div>
                            </div>
                        </div>

						<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
								
							<c:forEach items="${graphList}" var="i">
							
								<c:forEach items="${i}" var="k" varStatus="j">
									<c:if test="${j.count eq 1}">
										<input type="hidden" name="yvalue" value="${k}" />
									</c:if>
									
									<c:if test="${j.count eq 2}">
										<input type="hidden" name="xvalue" value="${k}" />
									</c:if>
								</c:forEach>
							</c:forEach>
						
						<div class="row">	
							<div class="col-lg-12">
	                        	<div class="card-box">
	                            	<h4 class="header-title">Unauthorized People detected in last 10 Days</h4>
	                            	<canvas id="lineChart" height="450" class="mt-4"></canvas>
	                        	</div>
                        	</div>
                        </div>
                        
                        
   <!-- end row -->



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
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.waypoints.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.counterup.min.js"></script>

        <!-- Chart JS -->
        <script src="<%=request.getContextPath()%>/adminResources/js/chart.bundle.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.chartjs.init.js"></script>

        <!-- init dashboard -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.dashboard.init.js"></script>
		
        <!-- App js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>

</body>
</html>