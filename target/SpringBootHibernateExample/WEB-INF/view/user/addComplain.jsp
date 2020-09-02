<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
                                    <h4 class="page-title float-left">Complain</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item">Manage Complain</li>
                                        <li class="breadcrumb-item active">Add Complain</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">

                            <!-- end col -->

                            <div class="col-lg-12">
                                <div class="card-box">
                                
                                <f:form role="form" action="addComplain" method="post" modelAttribute="ComplainVO" enctype="multipart/form-data">
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Subject<span class="text-danger">*</span></label>
                                            <div class="col-7">
                                                <f:input path="complainSubject" required="required" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Description<span class="text-danger">*</span></label>
                                            <div class="col-7">
                                                <f:textarea path="complainDescription" rows="5" class="form-control" required="required" parsley-type="email"/>
                                            </div>
                                        </div>
                                       
                                        <div class="form-group row">
                                            <label for="hori-pass1" class="col-4 col-form-label">Upload Image<span class="text-danger">*</span></label>
                                            <div class="col-4">
                                                <div class="fileupload fileupload-new" data-provides="fileupload">
                                                    <div class="fileupload-new thumbnail">
                                                    </div>
                                                    <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 100px; max-height: 100px; line-height: 20px;"></div>
                                                    <div>
                                                        <button type="button" class="btn btn-gradient btn-file">
                                                            <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Select image</span>
                                                            <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                                                            <input type="file" class="btn-secondary" name="complainImage" id="complainImage" accept="image/*">
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <div class="col-8 offset-4">
                                                <button type="submit" class="btn btn-gradient waves-effect waves-light">
                                                    Add Complain
                                                </button>
                                                <button type="reset"
                                                        class="btn btn-light waves-effect m-l-5">
                                                    Cancel
                                                </button>
                                            </div>
                                        </div>
                                    <!-- </form> -->
                                    </f:form>
                                    
                                    
                                </div>

                            </div> <!-- end col -->
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