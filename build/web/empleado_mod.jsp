<%@page import="logica.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es"> 
<head>
    <title>Modificacion - Empleado</title>
    
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="description" content="Portal - Bootstrap 5 Admin Dashboard Template For Developers">
    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">    
    <link rel="shortcut icon" href="favicon.ico"> 
    
    <!-- FontAwesome JS-->
    <script defer src="assets/plugins/fontawesome/js/all.min.js"></script>
    
    <!-- App CSS -->  
    <link id="theme-style" rel="stylesheet" href="assets/css/portal.css">

</head> 

<body class="app">   	
        <header class="app-header fixed-top">	   	            
        <div class="app-header-inner">  
	        <div class="container-fluid py-2">
		        <div class="app-header-content"> 
		            <div class="row justify-content-between align-items-center">
			        
				    <div class="col-auto">
					    <a id="sidepanel-toggler" class="sidepanel-toggler d-inline-block d-xl-none" href="#">
						    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30" role="img"><title>Menu</title><path stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="2" d="M4 7h22M4 15h22M4 23h22"></path></svg>
					    </a>
				    </div><!--//col-->
		            <div class="search-mobile-trigger d-sm-none col">
			            <i class="search-mobile-trigger-icon fas fa-search"></i>
			        </div><!--//col-->
		            <div class="app-search-box col">
		                <form class="app-search-form">   
							<input type="text" placeholder="Buscar..." name="search" class="form-control search-input">
							<button type="submit" class="btn search-btn btn-primary" value="Search"><i class="fas fa-search"></i></button> 
				        </form>
		            </div><!--//app-search-box-->
		            
		            <div class="app-utilities col-auto">
			            <div class="app-utility-item app-notifications-dropdown dropdown">    
				            <a class="dropdown-toggle no-toggle-arrow" id="notifications-dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false" title="Notifications">
                                                <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bell icon" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2z"/>
                                                    <path fill-rule="evenodd" d="M8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"/>
                                                </svg>
					            
                                            </a><!--//dropdown-toggle-->
					        
					        <div class="dropdown-menu p-0" aria-labelledby="notifications-dropdown-toggle">
					            <div class="dropdown-menu-header p-3">
						            <h5 class="dropdown-menu-title mb-0">Notifications</h5>
						        </div><!--//dropdown-menu-title-->
						        <div class="dropdown-menu-content">
							       <div class="item p-3">
								        <div class="row gx-2 justify-content-between align-items-center">
									        <div class="col-auto">
										       <img class="profile-image" src="assets/images/profiles/profile-1.png" alt="">
									        </div><!--//col-->
									        <div class="col">
										        <div class="info"> 
											        <div class="desc">Amy shared a file with you. Lorem ipsum dolor sit amet, consectetur adipiscing elit. </div>
											        <div class="meta"> 2 hrs ago</div>
										        </div>
									        </div><!--//col--> 
								        </div><!--//row-->
								        <a class="link-mask" href="notifications.html"></a>
							       </div><!--//item-->
							       <div class="item p-3">
								        <div class="row gx-2 justify-content-between align-items-center">
									        <div class="col-auto">
										        <div class="app-icon-holder">
											        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-receipt" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                                                                <path fill-rule="evenodd" d="M1.92.506a.5.5 0 0 1 .434.14L3 1.293l.646-.647a.5.5 0 0 1 .708 0L5 1.293l.646-.647a.5.5 0 0 1 .708 0L7 1.293l.646-.647a.5.5 0 0 1 .708 0L9 1.293l.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .801.13l.5 1A.5.5 0 0 1 15 2v12a.5.5 0 0 1-.053.224l-.5 1a.5.5 0 0 1-.8.13L13 14.707l-.646.647a.5.5 0 0 1-.708 0L11 14.707l-.646.647a.5.5 0 0 1-.708 0L9 14.707l-.646.647a.5.5 0 0 1-.708 0L7 14.707l-.646.647a.5.5 0 0 1-.708 0L5 14.707l-.646.647a.5.5 0 0 1-.708 0L3 14.707l-.646.647a.5.5 0 0 1-.801-.13l-.5-1A.5.5 0 0 1 1 14V2a.5.5 0 0 1 .053-.224l.5-1a.5.5 0 0 1 .367-.27zm.217 1.338L2 2.118v11.764l.137.274.51-.51a.5.5 0 0 1 .707 0l.646.647.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.646.646.646-.646a.5.5 0 0 1 .708 0l.509.509.137-.274V2.118l-.137-.274-.51.51a.5.5 0 0 1-.707 0L12 1.707l-.646.647a.5.5 0 0 1-.708 0L10 1.707l-.646.647a.5.5 0 0 1-.708 0L8 1.707l-.646.647a.5.5 0 0 1-.708 0L6 1.707l-.646.647a.5.5 0 0 1-.708 0L4 1.707l-.646.647a.5.5 0 0 1-.708 0l-.509-.51z"/>
                                                                                                <path fill-rule="evenodd" d="M3 4.5a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm8-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5z"/>
                                                                                              </svg>
										        </div>
									        </div><!--//col-->
									        <div class="col">
										        <div class="info"> 
											        <div class="desc">You have a new invoice. Proin venenatis interdum est.</div>
											        <div class="meta"> 1 day ago</div>
										        </div>
									        </div><!--//col-->
								        </div><!--//row-->
								        <a class="link-mask" href="notifications.html"></a>
							       </div><!--//item-->
							       <div class="item p-3">
								        <div class="row gx-2 justify-content-between align-items-center">
									        <div class="col-auto">
										        <div class="app-icon-holder icon-holder-mono">
											        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bar-chart-line" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                                                                <path fill-rule="evenodd" d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1V2zm1 12h2V2h-2v12zm-3 0V7H7v7h2zm-5 0v-3H2v3h2z"/>
                                                                                              </svg>
										        </div>
									        </div><!--//col-->
									        <div class="col">
										        <div class="info"> 
											        <div class="desc">Your report is ready. Proin venenatis interdum est.</div>
											        <div class="meta"> 3 days ago</div>
										        </div>
									        </div><!--//col-->
								        </div><!--//row-->
								        <a class="link-mask" href="notifications.html"></a>
							       </div><!--//item-->
							       <div class="item p-3">
								        <div class="row gx-2 justify-content-between align-items-center">
									        <div class="col-auto">
										       <img class="profile-image" src="assets/images/profiles/profile-2.png" alt="">
									        </div><!--//col-->
									        <div class="col">
										        <div class="info"> 
											        <div class="desc">James sent you a new message.</div>
											        <div class="meta"> 7 days ago</div>
										        </div>
									        </div><!--//col--> 
								        </div><!--//row-->
								        <a class="link-mask" href="notifications.html"></a>
							       </div><!--//item-->
						        </div><!--//dropdown-menu-content-->
						        
						        <div class="dropdown-menu-footer p-2 text-center">
							        <a href="notifications.html">View all</a>
						        </div>
															
							</div><!--//dropdown-menu-->					        
				        </div><!--//app-utility-item-->
			            <div class="app-utility-item">
				            <a href="settings.html" title="Settings">
					            <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-gear icon" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd" d="M8.837 1.626c-.246-.835-1.428-.835-1.674 0l-.094.319A1.873 1.873 0 0 1 4.377 3.06l-.292-.16c-.764-.415-1.6.42-1.184 1.185l.159.292a1.873 1.873 0 0 1-1.115 2.692l-.319.094c-.835.246-.835 1.428 0 1.674l.319.094a1.873 1.873 0 0 1 1.115 2.693l-.16.291c-.415.764.42 1.6 1.185 1.184l.292-.159a1.873 1.873 0 0 1 2.692 1.116l.094.318c.246.835 1.428.835 1.674 0l.094-.319a1.873 1.873 0 0 1 2.693-1.115l.291.16c.764.415 1.6-.42 1.184-1.185l-.159-.291a1.873 1.873 0 0 1 1.116-2.693l.318-.094c.835-.246.835-1.428 0-1.674l-.319-.094a1.873 1.873 0 0 1-1.115-2.692l.16-.292c.415-.764-.42-1.6-1.185-1.184l-.291.159A1.873 1.873 0 0 1 8.93 1.945l-.094-.319zm-2.633-.283c.527-1.79 3.065-1.79 3.592 0l.094.319a.873.873 0 0 0 1.255.52l.292-.16c1.64-.892 3.434.901 2.54 2.541l-.159.292a.873.873 0 0 0 .52 1.255l.319.094c1.79.527 1.79 3.065 0 3.592l-.319.094a.873.873 0 0 0-.52 1.255l.16.292c.893 1.64-.902 3.434-2.541 2.54l-.292-.159a.873.873 0 0 0-1.255.52l-.094.319c-.527 1.79-3.065 1.79-3.592 0l-.094-.319a.873.873 0 0 0-1.255-.52l-.292.16c-1.64.893-3.433-.902-2.54-2.541l.159-.292a.873.873 0 0 0-.52-1.255l-.319-.094c-1.79-.527-1.79-3.065 0-3.592l.319-.094a.873.873 0 0 0 .52-1.255l-.16-.292c-.892-1.64.902-3.433 2.541-2.54l.292.159a.873.873 0 0 0 1.255-.52l.094-.319z"/>
                                                    <path fill-rule="evenodd" d="M8 5.754a2.246 2.246 0 1 0 0 4.492 2.246 2.246 0 0 0 0-4.492zM4.754 8a3.246 3.246 0 1 1 6.492 0 3.246 3.246 0 0 1-6.492 0z"/>
                                                  </svg>
					        </a>
					    </div><!--//app-utility-item-->
			            
			            <div class="app-utility-item app-user-dropdown dropdown">
				            <a class="dropdown-toggle" id="user-dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false"><img src="assets/images/user.png" alt="user profile"></a>
				            <ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
                                                <li><a class="dropdown-item" href="account.html">Cuenta</a></li>
                                                <li><a class="dropdown-item" href="settings.html">Ajustes</a></li>
                                                <li><hr class="dropdown-divider"></li>
                                                <li>
                                                    <form action="SvLogin" method="GET">
                                                        <button class="dropdown-item" type="submit" style="background-color: #fff0;border: none;">Cerrar Sesion</button>
                                                    </form>
                                                </li>
                                            </ul>
			            </div><!--//app-user-dropdown--> 
		            </div><!--//app-utilities-->
		        </div><!--//row-->
	            </div><!--//app-header-content-->
	        </div><!--//container-fluid-->
        </div><!--//app-header-inner-->
        <div id="app-sidepanel" class="app-sidepanel"> 
	        <div id="sidepanel-drop" class="sidepanel-drop"></div>
	        <div class="sidepanel-inner d-flex flex-column">
		        <a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>
		        <div class="app-branding">
		            <a class="app-logo" href="index.jsp"><img class="logo-icon me-2" src="assets/images/app-logo.svg" alt="logo"><span class="logo-text">Agencia de Turismo</span></a>
	
		        </div><!--//app-branding-->  
		        
			    <nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
				    <ul class="app-menu list-unstyled accordion" id="menu-accordion">
					    <li class="nav-item">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link active" href="index.jsp">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                            <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
                                                            <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                                                          </svg>
						         </span>
		                         <span class="nav-link-text">Home</span>
					        </a><!--//nav-link-->
					    </li><!--//nav-item-->
					    
                                            <li class="nav-item">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                                                <form action="SvVentaAlta" method="GET">
                                                    <button class="nav-link" type="submit" style="background-color: #fff0;border: none;">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-card-list" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                            <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                                            <path fill-rule="evenodd" d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z"/>
                                                            <circle cx="3.5" cy="5.5" r=".5"/>
                                                            <circle cx="3.5" cy="8" r=".5"/>
                                                            <circle cx="3.5" cy="10.5" r=".5"/>
                                                        </svg>
						        </span>
                                                        <span class="nav-link-text">Realizar Venta</span>
					        </button></form><!--//nav-link-->
					    </li><!--//nav-item-->
					    
                                            <li class="nav-item has-submenu">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse" data-bs-target="#submenu-3" aria-expanded="false" aria-controls="submenu-3">
						        <span class="nav-icon">
						        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
						        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-credit-card-2-front" viewBox="0 0 16 16">
                                                            <path d="M14 3a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h12zM2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2z"/>
                                                            <path d="M2 5.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5z"/>
                                                          </svg>
						         </span>
                                                        <span class="nav-link-text">Empleados</span>
                                                        <span class="submenu-arrow">
                                                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                               <path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                                             </svg>
                                                    </span><!--//submenu-arrow-->
					        </a><!--//nav-link-->
					        <div id="submenu-3" class="collapse submenu submenu-3" data-bs-parent="#menu-accordion">
						        <ul class="submenu-list list-unstyled">
							        <li class="submenu-item"><a class="submenu-link" href="empleado_alta.jsp">Ingresar un empleado nuevo</a></li>
							        <li class="submenu-item">
                                                                    <form action="SvEmpleadoAlta" method="GET">
                                                                        <button class="submenu-link" type="submit" style="background-color: #fff0;border: none;">Lista de empleados</button>
                                                                    </form>
                                                                </li>
						        </ul>
					        </div>
					    </li><!--//nav-item-->
                                            <li class="nav-item has-submenu">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse" data-bs-target="#submenu-4" aria-expanded="false" aria-controls="submenu-4">
						        <span class="nav-icon">
						        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
						        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-video" viewBox="0 0 16 16">
                                                            <path d="M8 9.05a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"/>
                                                            <path d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2Zm10.798 11c-.453-1.27-1.76-3-4.798-3-3.037 0-4.345 1.73-4.798 3H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-1.202Z"/>
                                                          </svg>
						         </span>
                                                    <span class="nav-link-text">Clientes</span>
                                                    <span class="submenu-arrow">
                                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                                    </svg>
                                                    </span><!--//submenu-arrow-->
					        </a><!--//nav-link-->
					        <div id="submenu-4" class="collapse submenu submenu-4" data-bs-parent="#menu-accordion">
						        <ul class="submenu-list list-unstyled">
							        <li class="submenu-item"><a class="submenu-link" href="cliente_alta.jsp">Ingresar un cliente nuevo</a></li>
							        <li class="submenu-item">
                                                                    <form action="SvClienteAlta" method="GET">
                                                                        <button class="submenu-link" type="submit" style="background-color: #fff0;border: none;">Lista de clientes</button>
                                                                    </form>
                                                                </li>
						        </ul>
					        </div>
					    </li><!--//nav-item-->
					    <li class="nav-item has-submenu">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse" data-bs-target="#submenu-2" aria-expanded="false" aria-controls="submenu-2">
						        <span class="nav-icon">
						        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-columns-gap" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                            <path fill-rule="evenodd" d="M6 1H1v3h5V1zM1 0a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm14 12h-5v3h5v-3zm-5-1a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1h-5zM6 8H1v7h5V8zM1 7a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V8a1 1 0 0 0-1-1H1zm14-6h-5v7h5V1zm-5-1a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1h-5z"/>
                                                          </svg>
						         </span>
                                                    <span class="nav-link-text">Servicios, Medios de Pago y Paquetes</span>
                                                    <span class="submenu-arrow">
                                                       <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                           <path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                                       </svg>
                                                    </span><!--//submenu-arrow-->
					        </a><!--//nav-link-->
					        <div id="submenu-2" class="collapse submenu submenu-2" data-bs-parent="#menu-accordion">
						        <ul class="submenu-list list-unstyled">
                                                                <li class="submenu-item"><a class="submenu-link" href="servicio_alta.jsp">Agregar Servicio</a></li>
                                                                <li class="submenu-item"><a class="submenu-link" href="paquete_alta.jsp">Agregar Paquetes Turisticos</a></li>
                                                                <li class="submenu-item"><a class="submenu-link" href="mediosPago_alta.jsp">Agregar Medios de Pago</a></li>
                                                                
						        </ul>
					        </div>
					    </li><!--//nav-item-->
                                            <li class="nav-item has-submenu">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse" data-bs-target="#submenu-1" aria-expanded="false" aria-controls="submenu-1">
						        <span class="nav-icon">
						        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                            <path fill-rule="evenodd" d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                                            <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                                          </svg>
						         </span>
                                                    <span class="nav-link-text">Ver Tablas</span>
                                                    <span class="submenu-arrow">
                                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                            <path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                                        </svg>
                                                    </span><!--//submenu-arrow-->
					        </a><!--//nav-link-->
					        <div id="submenu-1" class="collapse submenu submenu-1" data-bs-parent="#menu-accordion">
						        <ul class="submenu-list list-unstyled">
                                                            <li class="submenu-item">
                                                                <form action="SvVentaEliminar" method="GET">
                                                                    <button class="submenu-link" type="submit" style="background-color: #fff0;border: none;">Lista de ventas</button>
                                                                </form>
                                                            </li>
                                                            <li class="submenu-item">
                                                                <form action="SvServicioAlta" method="GET">
                                                                    <button class="submenu-link" type="submit" style="background-color: #fff0;border: none;">Listar Servicios</button>
                                                                </form>
                                                            </li>
                                                            <li class="submenu-item">
                                                                <form action="SvPaqueteAlta" method="GET">
                                                                    <button class="submenu-link" type="submit" style="background-color: #fff0;border: none;">Listar Paquetes Turisticos</button>
                                                                </form>
                                                            </li>
                                                            <li class="submenu-item">
                                                                <form action="SvMediosPagoAlta" method="GET">
                                                                    <button class="submenu-link" type="submit" style="background-color: #fff0;border: none;">Listar Medios de Pago</button>
                                                                </form>
                                                            </li>
						        </ul>
					        </div>
					    </li><!--//nav-item-->
					   
					    <li class="nav-item">
                                                <form action="SvReporte" method="GET">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <button class="nav-link" type="submit" style="background-color: #fff0;border: none;">
                                                    <span class="nav-icon">
                                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bar-chart-line" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                            <path fill-rule="evenodd" d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1V2zm1 12h2V2h-2v12zm-3 0V7H7v7h2zm-5 0v-3H2v3h2z"/>
                                                        </svg>
                                                    </span>
                                                    <span class="nav-link-text">Reportes</span>
					        
                                                </button></form><!--//nav-link-->
					    </li><!--//nav-item-->
					    
				    </ul><!--//app-menu-->
			    </nav><!--//app-nav-->
			    <div class="app-sidepanel-footer">
				    <nav class="app-nav app-nav-footer">
					    <ul class="app-menu footer-menu list-unstyled">
						    <li class="nav-item">
						        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                                                        <form action="SvLogin" method="GET">
                                                            <button class="nav-link" type="submit" style="background-color: #fff0;border: none;">
							        <span class="nav-icon">
							            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                                                                    <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
                                                                    <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
                                                                </svg>
							        </span>
                                                            <span class="nav-link-text">Cerrar Sesion</span>
                                                            </button><!--//nav-link-->
                                                        </form>
						    </li><!--//nav-item-->
						    
					    </ul><!--//footer-menu-->
				    </nav>
			    </div><!--//app-sidepanel-footer-->
		       
	        </div><!--//sidepanel-inner-->
	    </div><!--//app-sidepanel-->
    </header><!--//app-header-->
    
    <div class="app-wrapper">
	    
	    <div class="app-content pt-3 p-md-3 p-lg-4">
		    <div class="container-xl">			    
			    <h1 class="app-page-title">Registro de Nuevo Empleado</h1>
			    <hr class="mb-4">
                <div class="row g-4 settings-section">
	                <div class="col-12 col-md-4">
		                <h3 class="section-title">Datos y privacidad</h3>
		                <div class="section-intro">Formulario para ingresar un nuevo empleado. Cada grupo de formulario requerido tiene un estado de validaci??n que se puede activar al intentar enviar el formulario sin completarlo. <a href="help.html">Learn more</a></div>
	                </div>
                    <div class="col-12 col-md-8">
		                <div class="app-card app-card-settings shadow-sm p-4">
						    <%
                                                        HttpSession miSession = request.getSession();
                                                        Usuario datos_usuario = (Usuario) miSession.getAttribute("Datos_usuario");
                                                        Empleado emple = (Empleado) miSession.getAttribute("Empleado");
                                                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                                        String fecha_nac = formatter.format(emple.getFecha_nac());
                                                        
                                                    %>
						    <div class="app-card-body">
                                                        <form class="settings-form row" action="SvEmpleadoModificar" method="GET">
                                                            <input type="hidden" name="id" value="<%=emple.getId_persona()%>" required>
								    <div class="col-md-6 mb-3">
                                                                        <label for="setting-input-1" class="form-label">Nombre<span class="ms-2" data-container="body" data-bs-toggle="popover" data-trigger="hover" data-placement="top" data-content="This is a Bootstrap popover example. You can use popover to provide extra info."><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-info-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                                                            <path d="M8.93 6.588l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588z"/>
                                                                            <circle cx="8" cy="4.5" r="1"/>
                                                                            </svg></span>
                                                                        </label>
                                                                        <input type="text" class="form-control" id="setting-input-1" name="nombre" value="<%=emple.getNombre()%>" required>
                                                                    </div>
                                                                    <div class="col-md-6 mb-3">
                                                                        <label for="setting-input-2" class="form-label">Apellido</label>
                                                                        <input type="text" class="form-control" id="setting-input-2" name="apellido" value="<%=emple.getApellido()%>" required>
                                                                    </div>
								    <div class="mb-3">
                                                                        <label for="setting-input-3" class="form-label">Email</label>
                                                                        <input type="email" class="form-control" id="setting-input-3" name="email" value="<%=emple.getEmail()%>" required>
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="setting-input-11" class="form-label">Celular</label>
                                                                        <input type="text" class="form-control" id="setting-input-11" name="celular" value="<%=emple.getCelular()%>" required>
                                                                    </div>
                                                                    <div class="col-md-6 mb-3">
                                                                        <label for="setting-input-4" class="form-label">Nacionalidad</label>
                                                                        <input type="text" class="form-control" id="setting-input-4" name="nacionalidad" value="<%=emple.getNacionalidad()%>" required>
                                                                    </div>
                                                                    <div class="col-md-6 mb-3">
                                                                        <label for="setting-input-5" class="form-label">Direcci??n</label>
                                                                        <input type="text" class="form-control" id="setting-input-5" name="direccion" value="<%=emple.getDireccion()%>" required>
                                                                    </div>
                                                                    <div class="col-md-6 mb-3">
                                                                        <label for="setting-input-6" class="form-label">Fecha de Nacimiento</label>
                                                                        <input type="date" class="form-control" id="setting-input-6" name="fecha_nac" value="<%= fecha_nac%>" required>
                                                                    </div>
                                                                    <div class="col-md-6 mb-3">
                                                                        <label for="setting-input-7" class="form-label">DNI</label>
                                                                        <input type="text" class="form-control" id="setting-input-7" name="dni" value="<%=emple.getDni()%>" required>
                                                                    </div>
                                                                
                                                                <div class="col-12 col-lg-6">
		                
						    <div class="app-card-header my-2 py-2 border-top">
						        <div class="row align-items-center gx-3">
							        <div class="col-auto">
								        <div class="app-icon-holder">
                                                                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-shield-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                                                    <path fill-rule="evenodd" d="M5.443 1.991a60.17 60.17 0 0 0-2.725.802.454.454 0 0 0-.315.366C1.87 7.056 3.1 9.9 4.567 11.773c.736.94 1.533 1.636 2.197 2.093.333.228.626.394.857.5.116.053.21.089.282.11A.73.73 0 0 0 8 14.5c.007-.001.038-.005.097-.023.072-.022.166-.058.282-.111.23-.106.525-.272.857-.5a10.197 10.197 0 0 0 2.197-2.093C12.9 9.9 14.13 7.056 13.597 3.159a.454.454 0 0 0-.315-.366c-.626-.2-1.682-.526-2.725-.802C9.491 1.71 8.51 1.5 8 1.5c-.51 0-1.49.21-2.557.491zm-.256-.966C6.23.749 7.337.5 8 .5c.662 0 1.77.249 2.813.525a61.09 61.09 0 0 1 2.772.815c.528.168.926.623 1.003 1.184.573 4.197-.756 7.307-2.367 9.365a11.191 11.191 0 0 1-2.418 2.3 6.942 6.942 0 0 1-1.007.586c-.27.124-.558.225-.796.225s-.526-.101-.796-.225a6.908 6.908 0 0 1-1.007-.586 11.192 11.192 0 0 1-2.417-2.3C2.167 10.331.839 7.221 1.412 3.024A1.454 1.454 0 0 1 2.415 1.84a61.11 61.11 0 0 1 2.772-.815z"/>
                                                                                    <path fill-rule="evenodd" d="M10.854 6.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 8.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                                                                                </svg>
									    </div><!--//icon-holder-->
						                
							        </div><!--//col-->
							        <div class="col-auto">
								        <h4 class="app-card-title">Seguridad</h4>
							        </div><!--//col-->
						        </div><!--//row-->
						    </div><!--//app-card-header-->
						    <div class="app-card-body w-100 ">

							    <div class="item py-3">
								    <div class="row justify-content-between align-items-center">
                                                                        <input type="text" name="id_usuario" value="<%= datos_usuario.getId_usuario()%>" required hidden>
                                                                        <div class="col-auto">
                                                                            <label for="setting-input-8" class="form-label">Username</label>
                                                                            <input type="text" class="form-control" id="setting-input-8" name="user" value="<%= datos_usuario.getNombre_usuario()%>" required>
                                                                        </div><!--//col-->
								    </div><!--//row-->
							    </div><!--//item-->
							    <div class="item border-bottom py-3">
								    <div class="row justify-content-between align-items-center">
									    <div class="col-auto">
                                                                                <label for="setting-input-9" class="form-label">Password</label>
                                                                                <input type="password" class="form-control" id="setting-input-9" name="pass" placeholder="***">
                                                                                <small class="section-intro">Si no modifica este campo conservara el mismo password</small>
									    </div><!--//col-->
								    </div><!--//row-->
							    </div><!--//item-->
						    </div><!--//app-card-body-->
						
                                            </div>
                                            <div class="col-12 col-lg-6">
		                
						    <div class="app-card-header my-2 py-2 border-top">
						        <div class="row align-items-center gx-3">
							        <div class="col-auto">
								        <div class="app-icon-holder">
										    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-credit-card" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                                                        <path fill-rule="evenodd" d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4zm2-1a1 1 0 0 0-1 1v1h14V4a1 1 0 0 0-1-1H2zm13 4H1v5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V7z"/>
                                                                                        <path d="M2 10a1 1 0 0 1 1-1h1a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1v-1z"/>
                                                                                    </svg>
									    </div><!--//icon-holder-->
						                
							        </div><!--//col-->
							        <div class="col-auto">
								        <h4 class="app-card-title">Datos Empleado</h4>
							        </div><!--//col-->
						        </div><!--//row-->
						    </div><!--//app-card-header-->
						    <div class="app-card-body w-100 ">
							    
							    <div class="item py-3">
								    <div class="row justify-content-between align-items-center">
									    <div class="col-auto">
                                                                                <label for="setting-input-10" class="form-label">Cargo</label>
                                                                                <input type="text" class="form-control" id="setting-input-10" name="cargo" value="<%=emple.getCargo()%>" required>
									    </div><!--//col-->
								    </div><!--//row-->
							    </div><!--//item-->
							    <div class="item border-bottom py-3">
								    <div class="row justify-content-between align-items-center">
									    <div class="col-auto">
                                                                                <label for="setting-input-11" class="form-label">Sueldo</label>
                                                                                <input type="text" class="form-control" id="setting-input-11" name="sueldo" value="<%=emple.getSueldo()%>" required>
									    </div><!--//col-->
								    </div><!--//row-->
							    </div><!--//item-->
						    </div><!--//app-card-body-->
                                            </div>
                                            <button type="submit" class="btn app-btn-primary" >Guardar Empleado</button>
                                        </form>
                                    </div><!--//app-card-body-->

                                </div><!--//app-card-->
	                </div>
	                
                </div><!--//row-->
                
                
                
			    <hr class="my-4">
		    </div><!--//container-fluid-->
	    </div><!--//app-content-->
	    
	    <footer class="app-footer">
		    <div class="container text-center py-3">
		         <!--/* This template is free as long as you keep the footer attribution link. If you'd like to use the template without the attribution link, you can buy the commercial license via our website: themes.3rdwavemedia.com Thank you for your support. :) */-->
            <small class="copyright">Designed with <i class="fas fa-heart" style="color: #fb866a;"></i> by <a class="app-link" href="http://themes.3rdwavemedia.com" target="_blank">Xiaoying Riley</a> for developers</small>
		       
		    </div>
	    </footer><!--//app-footer-->
	    
    </div><!--//app-wrapper-->    					

 
    <!-- Javascript -->          
    <script src="assets/plugins/popper.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>  
    
    <!-- Page Specific JS -->
    <script src="assets/js/app.js"></script> 

</body>
</html> 