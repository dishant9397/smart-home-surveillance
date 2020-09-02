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
                                            <a href="/" class="text-success">
                                                <span><img src="<%=request.getContextPath()%>/adminResources/images/SHS-Black.png" alt="" height="80"></span>
                                            </a>
                                        </h2>
                                        <h6 class="text-uppercase text-center font-bold mt-4">Change Password</h6>
                                    </div>
                                    <div class="account-content">
                                    
                                        <form class="form-horizontal" action="verifyPassword" method="post">

                                            <span id="otpSpn"></span>
                                            <div class="form-group m-b-20 row">
                                                <div class="col-12">
                                                    <label for="OTP">OTP<span class="text-danger">*</span></label>
                                                    <input data-parsley-type="digits" class="form-control" type="text" name="otp" id="otp" required="required" placeholder="Enter your OTP">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group m-b-20 row">
                                                <div class="col-12">
                                                    <label for="emailaddress">New Password<span class="text-danger">*</span></label>
                                                    <input class="form-control" type="password" name="password" id="password" required="required" placeholder="Enter your New Password">
                                                </div>
                                            </div>	
                                            
                                            <div class="form-group m-b-20 row">
                                                <div class="col-12">
                                                    <label for="emailaddress">Confirm Password<span class="text-danger">*</span></label>
                                                    <input class="form-control" type="password" name="confirmpassword" id="confirmpassword" required="required" placeholder="Enter your Confirm Password">
                                                </div>
                                            </div>
			
											<span id="pwdSpn"></span>
											<span id="con_pwdSpn"></span>
											
											</br></br>
                                            
                                            <div class="form-group row text-center m-t-10">
                                                <div class="col-12">
                                                    <button class="btn btn-block btn-gradient waves-effect waves-light" onclick="resendotp()">Resend OTP</button>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row text-center m-t-10">
                                                <div class="col-12">
                                                    <button class="btn btn-block btn-gradient waves-effect waves-light" type="submit">Change Password</button>
                                                </div>
                                            </div>
                                        </form>

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
		<script type="text/javascript">
		
		var generatedOTP = <%=session.getAttribute("generatedOTP")%>;
		
		$("#otp").keyup(function(){
			
			
			
			if(generatedOTP == $("#otp").val()){
				$("#otpSpn").html("Correct OTP");
				$("#otpSpn").css("color" , "green");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , false);
			}
			else{
				$("#otpSpn").html("Incorrect OTP");
				$("#otpSpn").css("color" , "red");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , true);
			}
			
		});
		
		
		$("#confirmpassword").keyup(function()
				{
					if($("#password").val() == $("#confirmpassword").val()){
						$("#con_pwdSpn").html("Password Matched");
						$("#con_pwdSpn").css("color" , "green");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , false);
					}
					else{
						$("#con_pwdSpn").html("Passwords didn't Match");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , true);
						}
				});
		 
		  function resendotp()
		  {
			  location.reload();
		  }
		
		</script>
  
    </body>
</html>