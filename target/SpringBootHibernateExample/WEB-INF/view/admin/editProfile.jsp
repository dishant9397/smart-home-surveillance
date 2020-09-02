<%@page import="com.project.model.RegisterVO"%>
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
                                    <h4 class="page-title float-left">Profile</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item active">Update Profile</li>
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
                                    
                                    
                                    <%-- <form role="form"> --%>
                                    <f:form role="form" action="updateProfile" method="post" modelAttribute="RegisterVO" enctype="multipart/form-data">
                                        <f:hidden path="registerId"/>
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">First Name<span class="text-danger">*</span></label>
                                            <div class="col-4">
                                                <f:input path="firstname" required="required" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Last Name<span class="text-danger">*</span></label>
                                            <div class="col-4">
                                            <f:input path="lastname" required="required" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>

                                   		 <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Username<span class="text-danger">*</span></label>
                                            <div class="col-4">
                                            <f:hidden path="loginVO.username"/>
                                            <f:input path="loginVO.username" disabled="true" required="required" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Password<span class="text-danger">*</span></label>
                                            <div class="col-4">
                                            <f:input path="loginVO.password" required="required" disabled="true" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Phone Number<span class="text-danger">*</span></label>
                                            <div class="col-4">
                                            <f:input path="phonenumber" required="required" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">E-Mail<span class="text-danger">*</span></label>
                                            <div class="col-4">
                                            <f:input path="email" required="required" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Home Name</label>
                                            <div class="col-4">
                                            <f:input path="homename" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-4 col-form-label">Home Address</label>
                                            <div class="col-4">
                                            <f:input path="address" parsley-type="email" class="form-control"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label class="col-4 col-form-label">Upload Image</label>
                                            <div class="col-6">
                                                <div class="fileupload fileupload-new" data-provides="fileupload">
                                                    <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                                        <c:choose>
                                                        <c:when test="${image ne null}">
                                                        	<img src="<%=request.getContextPath()%>/documents/profile/${username}/${image}" alt="image"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                        	<img src="<%=request.getContextPath()%>/adminResources/images/No Image.png" alt="image"/>
                                                        </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                    <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                                    <div>
                                                        <button type="button" class="btn btn-gradient btn-file">
                                                            <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Select image</span>
                                                            <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                                                            <input type="file" class="btn-secondary" name="profileImage" />
                                                        </button>
                                                        <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash"></i> Remove</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <f:hidden path="loginVO.password"/>
                                        <f:hidden path="imagepath"/>
                                     	<f:hidden path="imagename"/>
                                        <f:hidden path="loginVO.loginId"/>
                                        <f:hidden path="loginVO.enabled"/>	
                                        <f:hidden path="loginVO.role"/>
                                        <f:hidden path="loginVO.packageStatus"/>        
                                        
                                        <div class="form-group row">
                                            <div class="col-8 offset-4">
                                                <button type="submit" class="btn btn-gradient waves-effect waves-light">
                                                    Update Profile
                                                </button>
                                                <button type="reset"
                                                        class="btn btn-light waves-effect m-l-5">
                                                    Cancel
                                                </button>
                                            </div>
                                        </div>
                                    <%-- </form> --%>
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
            
            function clearImage()
            {
            	var image = document.getElementById("image");
            	var selectbutton = document.getElementById("selectbutton");
            	if()
            }
        </script>

    </body>
</html>