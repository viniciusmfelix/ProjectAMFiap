<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Sniper Contractor - Recruiter Page</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="favicon.ico" type="image/x-icon" />

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700,800" rel="stylesheet">

    <link rel="stylesheet" href="plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="plugins/icon-kit/dist/css/iconkit.min.css">
    <link rel="stylesheet" href="plugins/ionicons/dist/css/ionicons.min.css">
    <link rel="stylesheet" href="plugins/perfect-scrollbar/css/perfect-scrollbar.css">
    <link rel="stylesheet" href="plugins/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap.css">
    <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/build/css/tempusdominus-bootstrap-4.min.css">
    <link rel="stylesheet" href="plugins/weather-icons/css/weather-icons.min.css">
    <link rel="stylesheet" href="plugins/c3/c3.min.css">
    <link rel="stylesheet" href="plugins/owl.carousel/dist/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="plugins/owl.carousel/dist/assets/owl.theme.default.min.css">
    <link rel="stylesheet" href="dist/css/theme.min.css">
    <script src="src/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

    <div class="wrapper">
        <header class="header-top" header-theme="dark">
            <div class="container-fluid">
                <div class="d-flex justify-content-between">
                    <div class="top-menu d-flex align-items-center">
                        <button type="button" class="btn-icon mobile-nav-toggle d-lg-none"><span></span></button>
                        <div class="header-search">
                            <div class="input-group">
                                <span class="input-group-addon search-close"><i class="ik ik-x"></i></span>
                                <input type="text" class="form-control">
                                <span class="input-group-addon search-btn"><i class="ik ik-search"></i></span>
                            </div>
                        </div>
                        <button type="button" id="navbar-fullscreen" class="nav-link"><i
                                class="ik ik-maximize"></i></button>
                    </div>
                    <div class="top-menu d-flex align-items-center">
                        <div class="dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="notiDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
                                    class="ik ik-bell"></i><span class="badge bg-danger">3</span></a>
                            <div class="dropdown-menu dropdown-menu-right notification-dropdown"
                                aria-labelledby="notiDropdown">
                                <h4 class="header">Notifications</h4>
                                <div class="notifications-wrap">
                                    <a href="#" class="media">
                                        <span class="d-flex">
                                            <i class="ik ik-check"></i>
                                        </span>
                                        <span class="media-body">
                                            <span class="heading-font-family media-heading">Invitation accepted</span>
                                            <span class="media-content">Your have been Invited ...</span>
                                        </span>
                                    </a>
                                    <a href="#" class="media">
                                        <span class="d-flex">
                                            <img src="img/users/1.jpg" class="rounded-circle" alt="">
                                        </span>
                                        <span class="media-body">
                                            <span class="heading-font-family media-heading">Steve Smith</span>
                                            <span class="media-content">I slowly updated projects</span>
                                        </span>
                                    </a>
                                    <a href="#" class="media">
                                        <span class="d-flex">
                                            <i class="ik ik-calendar"></i>
                                        </span>
                                        <span class="media-body">
                                            <span class="heading-font-family media-heading">To Do</span>
                                            <span class="media-content">Meeting with Nathan on Friday 8 AM ...</span>
                                        </span>
                                    </a>
                                </div>
                                <div class="footer"><a href="javascript:void(0);">See all activity</a></div>
                            </div>
                        </div>
                        <div class="dropdown">
                            <a class="dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false"><img class="avatar" src="img/user.jpg"
                                    alt=""></a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="profile.html"><i class="ik ik-user dropdown-icon"></i>
                                    Profile</a>
                                <a class="dropdown-item" href="#"><i class="ik ik-settings dropdown-icon"></i>
                                    Settings</a>
                                <a class="dropdown-item" href="../HomenRegister/RecruiterLogin.jsp"><i class="ik ik-power dropdown-icon"></i>
                                    Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="page-wrap">
            <div class="app-sidebar colored">
                <div class="sidebar-header">
                    <a class="header-brand" href="RecruiterPage.jsp">
                        <div class="logo-img">
                            <i class="fas fa-crosshairs"></i>
                        </div>
                        <span class="text">Sniper Contractor</span>
                    </a>
                    <button type="button" class="nav-toggle"><i data-toggle="expanded"
                            class="ik ik-toggle-right toggle-icon"></i></button>
                    <button id="sidebarClose" class="nav-close"><i class="ik ik-x"></i></button>
                </div>

                <div class="sidebar-content">
                    <div class="nav-container">
                        <nav id="main-menu-navigation" class="navigation-main">
                            <div class="nav-lavel">General</div>
                            <div class="nav-item active">
                                <a href="RecruiterPage.jsp"><i class="ik ik-bar-chart-2"></i><span>Start</span></a>
                            </div>
                            <div class="nav-lavel">Users Applied</div>
                            <div class="nav-item">
                                <a href="pages/UsersApplied.jsp"><i class="ik ik-users"></i><span>Profiles</span></a>
                            </div>
                            <div class="nav-item">
                                <a href="pages/"><i class="ik ik-award"></i><span>Analytics</span></a>
                            </div>
                            <div class="nav-lavel">Job Openings</div>
                            <div class="nav-item">
                                <a href="pages/JobOpeningPortalRecruiter.jsp"><i class="ik ik-book-open"></i><span>All Job Openings</span></a>
                            </div>
                            <div class="nav-item">
                                <a href="pages/JobOpeningsAdd.jsp"><i class="ik ik-file-plus"></i><span>Add +</span></a>
                            </div>
                            <div class="nav-lavel">Sorting</div>
                            <div class="nav-item">
                                <a href="pages/Picks.jsp"><i
                                        class="ik ik-arrow-right-circle"></i><span>Picks</span></a>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>

            <footer class="footer">
                <div class="w-100 clearfix">
                    <span class="text-center text-sm-left d-md-inline-block">Copyright © 2018 ThemeKit v2.0. All Rights
                        Reserved.</span>
                    <span class="float-none float-sm-right mt-1 mt-sm-0 text-center">Crafted with <i
                            class="fa fa-heart text-danger"></i> by <a href="http://lavalite.org/" class="text-dark"
                            target="_blank">Lavalite</a></span>
                </div>
            </footer>

        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>window.jQuery || document.write('<script src="src/js/vendor/jquery-3.3.1.min.js"><\/script>')</script>
    <script src="plugins/popper.js/dist/umd/popper.min.js"></script>
    <script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="plugins/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
    <script src="plugins/screenfull/dist/screenfull.js"></script>
    <script src="plugins/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script src="plugins/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="plugins/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
    <script src="plugins/jvectormap/jquery-jvectormap.min.js"></script>
    <script src="plugins/jvectormap/tests/assets/jquery-jvectormap-world-mill-en.js"></script>
    <script src="plugins/moment/moment.js"></script>
    <script src="plugins/tempusdominus-bootstrap-4/build/js/tempusdominus-bootstrap-4.min.js"></script>
    <script src="plugins/d3/dist/d3.min.js"></script>
    <script src="plugins/c3/c3.min.js"></script>
    <script src="js/tables.js"></script>
    <script src="js/widgets.js"></script>
    <script src="js/charts.js"></script>
    <script src="dist/js/theme.min.js"></script>
    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
    <script>
            (function (b, o, i, l, e, r) {
                b.GoogleAnalyticsObject = l; b[l] || (b[l] =
                    function () { (b[l].q = b[l].q || []).push(arguments) }); b[l].l = +new Date;
                e = o.createElement(i); r = o.getElementsByTagName(i)[0];
                e.src = 'https://www.google-analytics.com/analytics.js';
                r.parentNode.insertBefore(e, r)
            }(window, document, 'script', 'ga'));
        ga('create', 'UA-XXXXX-X', 'auto'); ga('send', 'pageview');
    </script>
</body>

</html>