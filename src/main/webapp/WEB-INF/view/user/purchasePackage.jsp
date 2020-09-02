<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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

		<!-- Bootstrap fileupload css -->
        <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap-fileupload.css" rel="stylesheet" />
        
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
                                    <h4 class="page-title float-left">Package</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item">Manage Package</li>
                                        <li class="breadcrumb-item active">Purchase Package</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">

                            <!-- end col -->

							<div class="col-md-12">
                                <div class="card-box">
                                <div class="alert alert-info alert-white"><strong>Note!</strong> It will take almost 24 hours to activate the Package. In case of any issue please send us a mail on <a href="mailto:smarthomesurveillance0925@gmail.com" target="_blank">smarthomesurveillance0925@gmail.com</a> with the complete payment details.</div>

                                    <ul class="nav nav-tabs tabs-bordered nav-justified">
                                        <li class="nav-item">
                                            <a href="#Bank Transfer" data-toggle="tab" aria-expanded="true" class="nav-link active">
                                                Bank Transfer
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="#Paytm" data-toggle="tab" aria-expanded="false" class="nav-link">
                                                Paytm
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="#UPI" data-toggle="tab" aria-expanded="false" class="nav-link">
                                                UPI
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="Bank Transfer">
                                            <c:forEach items="${packageList}" var="i">
                                            <f:form role="form" action="purchasePackage?paymentType=Bank%20Transfer&packageId=${i.packageId}" method="post" modelAttribute="PaymentVO">
		                                    	<h5 style="font-weight: bolder;">Package Details</h5>	
		                                    	<div class="form-group row">
		                                    		<label class="col-10 col-form-label">Package Name :  ${i.packageName}</label></br>
		                                    		<label class="col-10 col-form-label">Validity : ${i.packageDuration} ${i.packageDurationType}</label></br>
		                                    		<label class="col-10 col-form-label">Amount : &#8377; ${i.packageAmount}</label></br>
		                                    	</div>	
		                                    	<h5 style="font-weight: bolder;">Payment Details</h5>
		                                    	<div class="form-group row">
		                                    		<label class="col-10 col-form-label">Account Holder's Name : Dishant Patel</label></br>
		                                    		<label class="col-10 col-form-label">Bank Account Number : 20281868249</label></br>
		                                    		<label class="col-10 col-form-label">IFSC Code : SBIN0011788</label></br>
		                                    		<label class="col-10 col-form-label">Branch Name : Station Road, Maninagar</label></br>
		                                            <label class="col-3 col-form-label">Payment Reference Number<span class="text-danger">*</span></label>
		                                            <div class="col-5">
		                                                <f:input path="paymentTransactionId" required="required" parsley-type="email" class="form-control"/>
		                                            </div>
		                                            <div class="col-auto">
		                                           		<button type="submit" class="btn btn-gradient waves-effect waves-light">Purchase</button>
		                                           	</div>
		                                        </div>
		                                    </f:form>
		                                    </c:forEach>
                                        </div>
                                        
                                        <div class="tab-pane" id="Paytm">
                                            <c:forEach items="${packageList}" var="i">
                                            <f:form role="form" action="purchasePackage?paymentType=Paytm&packageId=${i.packageId}" method="post" modelAttribute="PaymentVO">
                                            <h5 style="font-weight: bolder;">Package Details</h5>	
		                                    	<div class="form-group row">
		                                    		<label class="col-10 col-form-label">Package Name :  ${i.packageName}</label></br>
		                                    		<label class="col-10 col-form-label">Validity : ${i.packageDuration} ${i.packageDurationType}</label></br>
		                                    		<label class="col-10 col-form-label">Amount : &#8377; ${i.packageAmount}</label></br>
		                                    	</div>
		                                    	<h5 style="font-weight: bolder;">Payment Details</h5>
		                                    	<div class="form-group row">
		                                    		<label class="col-10 col-form-label">Paytm Name :  Dishant J Patel</label></br>
		                                    		<img alt="image" height="250px" width="250px" src="<%=request.getContextPath()%>/adminResources/images/Paytm.jpg">
		                                    	</div>
		                                    	<div class="form-group row">	
		                                            <label class="col-3 col-form-label">Payment Reference Number<span class="text-danger">*</span></label>
		                                            <div class="col-5">
		                                                <f:input path="paymentTransactionId" required="required" parsley-type="email" class="form-control"/>
		                                            </div>
		                                            <div class="col-auto">
		                                           		<button type="submit" class="btn btn-gradient waves-effect waves-light">Purchase</button>
		                                           	</div>
		                                        </div>
		                                    </f:form>
		                                    </c:forEach>
                                        </div>
                                        <div class="tab-pane" id="UPI">
                                            <c:forEach items="${packageList}" var="i">
                                            <f:form role="form" action="purchasePackage?paymentType=UPI&packageId=${i.packageId}" method="post" modelAttribute="PaymentVO">
                                            <h5 style="font-weight: bolder;">Package Details</h5>	
		                                    	<div class="form-group row">
		                                    		<label class="col-10 col-form-label">Package Name :  ${i.packageName}</label></br>
		                                    		<label class="col-10 col-form-label">Validity : ${i.packageDuration} ${i.packageDurationType}</label></br>
		                                    		<label class="col-10 col-form-label">Amount : &#8377; ${i.packageAmount}</label></br>
		                                    	</div>
		                                    	<h5 style="font-weight: bolder;">Payment Details</h5>
		                                    	<div class="form-group row">
		                                    		<label class="col-10 col-form-label">PhonePe UPI :  9898222603@ybl</label></br>
		                                    		<img alt="image" height="250px" width="250px" src="<%=request.getContextPath()%>/adminResources/images/UPI.jpg">
		                                    	</div>
		                                    	<div class="form-group row">	
		                                            <label class="col-3 col-form-label">Payment Reference Number<span class="text-danger">*</span></label>
		                                            <div class="col-5">
		                                                <f:input path="paymentTransactionId" required="required" parsley-type="email" class="form-control"/>
		                                            </div>
		                                            <div class="col-auto">
		                                           		<button type="submit" class="btn btn-gradient waves-effect waves-light">Purchase</button>
		                                           	</div>
		                                        </div>
		                                    </f:form>
		                                    </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->

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

        <!-- Parsley js -->
        <script type="text/javascript" src="<%=request.getContextPath()%>/adminResources/js/parsley.min.js"></script>

		<!-- Bootstrap fileupload js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap-fileupload.js"></script>
        
        <!-- App js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('form').parsley();
            });
            
            $("button[type='submit']").click(function(){
    			var $fileUpload = $("input[type='file']");
    			if (parseInt($fileUpload.get(0).files.length) != 1){
     				alert("Upload Image");
     				$('#complainImage').val('');
     				$('#fileUploadPreviewId').HTML('');
    			}
			});
        </script>

    </body>
</html>