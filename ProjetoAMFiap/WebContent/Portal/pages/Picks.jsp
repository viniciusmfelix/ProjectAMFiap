<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Sniper Contractor - Picks</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="../favicon.ico" type="image/x-icon" />

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700,800" rel="stylesheet">

    <link rel="stylesheet" href="../plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/dist/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/icon-kit/dist/css/iconkit.min.css">
    <link rel="stylesheet" href="../plugins/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="../dist/css/theme.min.css">
    <script src="../src/js/vendor/modernizr-2.8.3.min.js"></script>
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
                                            <img src="../img/users/1.jpg" class="rounded-circle" alt="">
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
                                aria-haspopup="true" aria-expanded="false"><img class="avatar" src="../img/user.jpg"
                                    alt=""></a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="profile.html"><i class="ik ik-user dropdown-icon"></i>
                                    Profile</a>
                                <a class="dropdown-item" href="#"><i class="ik ik-settings dropdown-icon"></i>
                                    Settings</a>
                                <a class="dropdown-item" href="./../HomenRegister/RecruiterLogin.jsp"><i class="ik ik-power dropdown-icon"></i>
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
                    <a class="header-brand" href="../RecruiterPage.jsp">
                        <div class="logo-img">
                            <i class="fas fa-crosshairs"></i>
                        </div>
                        <span class="text">Sniper Contractor	</span>
                    </a>
                    <button type="button" class="nav-toggle"><i data-toggle="expanded"
                            class="ik ik-toggle-right toggle-icon"></i></button>
                    <button id="sidebarClose" class="nav-close"><i class="ik ik-x"></i></button>
                </div>

                <div class="sidebar-content">
                    <div class="nav-container">
                        <nav id="main-menu-navigation" class="navigation-main">
                            <div class="nav-lavel">General</div>
                            <div class="nav-item">
                                <a href="../RecruiterPage.jsp"><i class="ik ik-bar-chart-2"></i><span>Start</span></a>
                            </div>
                            <div class="nav-lavel">UsersApplied</div>
                            <div class="nav-item  active">
                                <a href="UsersApplied.jsp"><i class="ik ik-users"></i><span>Profiles</span></a>
                            </div>
                            <div class="nav-item">
                                <a href="pages/"><i class="ik ik-award"></i><span>Analytics</span></a>
                            </div>
                            <div class="nav-lavel">Job Openings</div>
                            <div class="nav-item">
                                <a href="JobOpeningPortalRecruiter.jsp"><i class="ik ik-book-open"></i><span>All Job Openings</span></a>
                            </div>
                            <div class="nav-item">
                                <a href="JobOpeningsAdd.jsp"><i class="ik ik-file-plus"></i><span>Add+</span></a>
                            </div>
                            <div class="nav-lavel">Sorting</div>
                            <div class="nav-item">
                                <a href="Picks.jsp"><i
                                        class="ik ik-arrow-right-circle"></i><span>Picks</span></a>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>

            <div class="main-content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h3>User Applied Selection</h3>
                                </div>
                                <div class="card-body">
                                    <table id="data_table" class="table">
                                    
                                        <thead>
                                            <tr>
                                                <th>Code</th>
                                                <th>Job Title</th>
                                                <th>Open</th>
                                                <th>Submissions</th>
                                                <th>Status</th>
                                                <th class="nosort">&nbsp;</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>#EX001</td>
                                                <td>erich@example.com</td>
                                                <td>01</td>
                                                <td>120</td>
                                                <td></td>
                                                <td>
                                                    <div class="table-actions text-center">
                                                        <a href="#editLayoutItem" data-toggle="modal"
                                                            data-target="#editLayoutItem"><i class="ik ik-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                       
                                        </tbody>
                                    </table>
                                </div>
                                
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h3>Data Table</h3>
                                </div>
                                <div class="card-body">
                                    <table id="data_table" class="table">
                                        <thead>
                                            <tr>
                                                <th>Resume</th>
                                                <th>Tags Skills</th>
                                                <th>Tags Languages</th>
                                                <th>Rating</th>
                                                <th>Email</th>
                                                <th class="nosort">&nbsp;</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="d-inline-block align-middle">
                                                        <img src="../img/users/4.jpg" alt="user image"
                                                            class="rounded-circle img-40 align-top mr-15">
                                                        <div class="d-inline-block">
                                                            <h6>Shirley Hoe</h6>
                                                            <p class="text-muted mb-0">Sales executive , NY</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Portuguese</label>
                                                    <label class="badge badge-primary">English</label>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Sketch</label>
                                                    <label class="badge badge-primary">Ui</label>
                                                </td>
                                                <td>erich@example.com</td>
                                                <td>
                                                    <div class="table-actions text-center">
                                                        <a href="#editLayoutItem" data-toggle="modal"
                                                            data-target="#editLayoutItem"><i class="ik ik-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-inline-block align-middle">
                                                        <img src="../img/users/2.jpg" alt="user image"
                                                            class="rounded-circle img-40 align-top mr-15">
                                                        <div class="d-inline-block">
                                                            <h6>James Alexander</h6>
                                                            <p class="text-muted mb-0">Sales executive , EL</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Portuguese</label>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Ux</label>
                                                    <label class="badge badge-danger">Ui</label>
                                                    <label class="badge badge-danger">php</label>
                                                </td>
                                                <td>jgraham@example.com</td>
                                                <td>
                                                    <div class="table-actions text-center">
                                                        <a href="#editLayoutItem" data-toggle="modal"
                                                            data-target="#editLayoutItem"><i class="ik ik-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-inline-block align-middle">
                                                        <img src="../img/users/4.jpg" alt="user image"
                                                            class="rounded-circle img-40 align-top mr-15">
                                                        <div class="d-inline-block">
                                                            <h6>Shirley Hoe</h6>
                                                            <p class="text-muted mb-0">Sales executive , NY</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Portuguese</label>
                                                    <label class="badge badge-danger">Spanish</label>
                                                </td>
                                                <td>
                                                    <label class="badge badge-danger">Sketch</label>
                                                    <label class="badge badge-primary">Ui</label>
                                                </td>
                                                <td>grant.simonis@example.com</td>
                                                <td>
                                                    <div class="table-actions text-center">
                                                        <a href="#editLayoutItem" data-toggle="modal"
                                                            data-target="#editLayoutItem"><i class="ik ik-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-inline-block align-middle">
                                                        <img src="../img/users/4.jpg" alt="user image"
                                                            class="rounded-circle img-40 align-top mr-15">
                                                        <div class="d-inline-block">
                                                            <h6>Shirley Hoe</h6>
                                                            <p class="text-muted mb-0">Sales executive , NY</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                </td>
                                                <td>
                                                    <label class="badge badge-success">Spanish</label>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Ux</label>
                                                    <label class="badge badge-danger">Ui</label>
                                                    <label class="badge badge-danger">php</label>
                                                </td>
                                                <td>henry.chris@example.com</td>
                                                <td>
                                                    <div class="table-actions text-center">
                                                        <a href="#editLayoutItem" data-toggle="modal"
                                                            data-target="#editLayoutItem"><i class="ik ik-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-inline-block align-middle">
                                                        <img src="../img/users/4.jpg" alt="user image"
                                                            class="rounded-circle img-40 align-top mr-15">
                                                        <div class="d-inline-block">
                                                            <h6>Shirley Hoe</h6>
                                                            <p class="text-muted mb-0">Sales executive , NY</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-yellow"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                    <a href="#!"><i class="fa fa-star f-12 text-default"></i></a>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Portuguese</label>
                                                    <label class="badge badge-success">Spanish</label>
                                                    <label class="badge badge-primary">English</label>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary">Ux</label>
                                                    <label class="badge badge-success">Ui</label>
                                                    <label class="badge badge-warning">php</label>
                                                </td>

                                                <td>boyle.aglea@example.com</td>
                                                <td>
                                                    <div class="table-actions text-center">
                                                        <a href="#editLayoutItem" data-toggle="modal"
                                                            data-target="#editLayoutItem"><i class="ik ik-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="modal fade edit-layout-modal" id="editLayoutItem" tabindex="-1" role="dialog"
                aria-labelledby="editLayoutItemLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="d-inline-block align-middle">
                                <img src="../img/users/4.jpg" alt="user image"
                                    class="rounded-circle img-40 align-top mr-15">
                                <div class="d-inline-block">
                                    <h6>Shirley Hoe</h6>
                                    <p class="text-muted mb-0">Sales executive , NY</p>
                                </div>
                            </div>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                        </div>
                        <div class="modal-body">
                            <p class="lead">Nullam elementum aliquam porta.</p>
                            <p>Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus fermentum
                                imperdiet ligula, et mollis quam sagittis ac. In quis interdum sem. Vivamus blandit
                                fringilla hendrerit. Suspendisse vulputate sapien vitae mi convallis dictum. Sed blandit
                                felis ut quam accumsan, at condimentum nibh varius. Mauris ornare ultricies ipsum.</p>
                            <div class="row">
                                <div class="col-md-6"><img src="../img/portfolio-1.jpg" class="img-fluid" alt=""></div>
                                <div class="col-md-6"><img src="../img/portfolio-8.jpg" class="img-fluid" alt=""></div>
                            </div>
                            <div class="jumbotron pt-30 pb-30 mt-30">
                                <h2 class="mt-0">Hello, world!</h2>
                                <p class="lead">This is a simple hero unit, a simple jumbotron-style component for
                                    calling extra attention to featured content or information.</p>
                            </div>
                            <p>Praesent eleifend ac felis dignissim mattis. Suspendisse eget congue enim, ac fermentum
                                risus. Donec eget risus lacus. Nullam nec lectus quis tortor ultrices consectetur. Etiam
                                dui erat, tristique vel quam a, maximus porttitor enim. Ut molestie turpis in est
                                iaculis, ut congue massa porta.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-times"
                                    aria-hidden="true"></i> Close</button>
                            <button type="button" class="btn btn-success"><i class="fa fa-print" aria-hidden="true"></i>
                                Print</button>
                        </div>
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
    <script>window.jQuery || document.write('<script src="../src/js/vendor/jquery-3.3.1.min.js"><\/script>')</script>
    <script src="../plugins/popper.js/dist/umd/popper.min.js"></script>
    <script src="../plugins/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="../plugins/screenfull/dist/screenfull.js"></script>
    <script src="../plugins/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../plugins/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script src="../dist/js/theme.js"></script>
    <script src="../js/datatables.js"></script>
</body>

</html>