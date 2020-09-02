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

        <!-- App css -->
        <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/style.css" rel="stylesheet" type="text/css" />

        <script src="<%=request.getContextPath()%>/adminResources/js/modernizr.min.js"></script>

    </head>


    <body class="bg-accpunt-pages">

        <!-- HOME -->
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">

                        <div class="wrapper-page">

                            <div class="account-pages">
                                <div class="account-box">
                                    <div class="account-logo-box">
                                        <h2 class="text-uppercase text-center">
                                            <a href="index.jsp" class="text-success">
                                                <span><img src="<%=request.getContextPath()%>/adminResources/images/SHS-Black.png" alt="" height="80"></span>
                                            </a>
                                        </h2>
                                        <h6 class="text-uppercase text-center font-bold mt-4">Register</h6>
                                    </div>
                                    <div class="account-content">
                                    <f:form action="registerInsert" role="form" method="post" modelAttribute="registerVO">
											
											<div align="center" style="color: red; font-weight: bold;">${sessionScope.reloadMessage}</div></br>	
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label>First Name<span class="text-danger">*</span></label>
                                                    <f:input path="firstname" required="required" parsley-type="email" class="form-control"/>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label>Last Name<span class="text-danger">*</span></label>
                                                    <f:input path="lastname" required="required" parsley-type="email" class="form-control"/>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label>E-Mail<span class="text-danger">*</span></label>
                                                    <f:input path="email" required="required" parsley-type="email" class="form-control"/>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label>Mobile Number<span class="text-danger">*</span></label>
                                                    <f:input path="phonenumber" required="required" parsley-type="email" class="form-control"/>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label>Username<span class="text-danger">*</span></label>
                                                    <f:input path="loginVO.username" required="required" parsley-type="email" class="form-control"/>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label>Password<span class="text-danger">*</span></label>
                                                    <f:input path="loginVO.password" parsley-type="email" name="password" id="password" class="form-control"/>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label>Re-Type Password<span class="text-danger">*</span></label>
                                                    <input type="text" name="confirmpassword" id="confirmpassword" class="form-control">
                                                </div>
                                            </div>
                                            
                                            <span id="pwdSpn"></span>
											<span id="con_pwdSpn"></span>
											
											</br></br>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">

                                                    <div class="checkbox checkbox-success">
                                                        <input id="remember" type="checkbox" checked>
                                                        <label for="remember">
                                                            I accept Terms and Conditions
                                                        </label>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="form-group row text-center m-t-10">
                                                <div class="col-12">
                                                    <button class="btn btn-block btn-gradient waves-effect waves-light" id="SubmitButton" type="submit">Sign Up</button>
                                                </div>
                                            </div>

                                        </f:form>

                                        <div class="row m-t-50">
                                            <div class="col-sm-12 text-center">
                                                <p class="text-muted">Already have an account?  <a href="/" class="text-dark m-l-5"><b>Sign In</b></a></p>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- end card-box-->


                        </div>
                        <!-- end wrapper -->

                    </div>
                </div>
            </div>
        </section>
        <!-- END HOME -->


        <!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/waves.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.slimscroll.js"></script>

        <!-- App js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>
        
        <!-- Parsley js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/parsley.min.js"></script>

		<script type="text/javascript">
        $(document).ready(function() {
            $('form').parsley();
            document.getElementById("SubmitButton").disabled=true;
        });
        </script>
        
		<script type="text/javascript">
		$("#confirmpassword").keyup(function()
				{
					if($("#password").val() == $("#confirmpassword").val()){
						$("#con_pwdSpn").html("Passwords are Matched");
						$("#con_pwdSpn").css("color" , "green");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , false);
						document.getElementById("SubmitButton").disabled=false;
					}
					else{
						$("#con_pwdSpn").html("Passwords didn't Match");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , true);
						document.getElementById("SubmitButton").disabled=true;
						}
				});
		</script>
    </body>
</html>