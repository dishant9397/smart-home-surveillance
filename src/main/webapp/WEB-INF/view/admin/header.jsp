<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<div class="topbar">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

                <!-- LOGO -->
                <div class="topbar-left">
                    <a href="/admin/index" class="logo">
                        <span>
                            <img src="<%=request.getContextPath()%>/adminResources/images/SHS-White.png" alt="" height="50">
                        </span>
                        <i>
                            <img src="<%=request.getContextPath()%>/adminResources/images/logo.png" alt="" height="50">
                        </i>
                    </a>
                </div>

                <nav class="navbar-custom">

                    <ul class="list-unstyled topbar-right-menu float-right mb-0">

                        <li class="dropdown notification-list">
                            <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                 <c:choose>
                                      <c:when test="${imagename ne null}">
                                      	<img src="<%=request.getContextPath()%>/documents/profile/${sessionScope.username}/${sessionScope.imagename}" alt="image" class="rounded-circle"/>
                                      </c:when>
                                      <c:otherwise>
                                      	<img src="<%=request.getContextPath()%>/adminResources/images/No Image.png" alt="image" class="rounded-circle"/>
                                      </c:otherwise>
                                 </c:choose>  
                                <span class="ml-1"> ${sessionScope.firstName} ${sessionScope.lastName}<i class="mdi mdi-chevron-down"></i> </span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h6 class="text-overflow m-0">Welcome ${sessionScope.username} !</h6>
                                </div>

                                <!-- item-->
                                <a href="viewProfile" class="dropdown-item notify-item">
                                    <i class="fi-head"></i> <span>My Account</span>
                                </a>

                                <!-- item-->
                                <a href="../logout" class="dropdown-item notify-item">
                                    <i class="fi-power"></i> <span>Logout</span>
                                </a>

                            </div>
                        </li>

                    </ul>

                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left waves-light waves-effect">
                                <i class="dripicons-menu"></i>
                            </button>
                        </li>
                    </ul>

                </nav>

            </div>