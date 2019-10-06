<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Language"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.model.Bio"%>
<%@page import="com.model.Location"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.model.Profession"%>
<%@page import="com.dao.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Language> lang_list = new ArrayList<>();
session = request.getSession(true);
String email = (String) session.getAttribute("email");
String name,lastname,born_date,phone;
Profession profession;
UserDAO userdao = new UserDAO(); 
int user_id = userdao.returnUserId(email);
name = userdao.retrieveName(email);
lastname = userdao.retrieveLastName(email);
ResumeDAO resumedao = new ResumeDAO();
phone = userdao.retrievePhone(email);
profession = resumedao.retrieveProfession(user_id);
Location location;
location = resumedao.retrieveLocation(user_id);
born_date = userdao.retrieveBornDate(user_id);
Bio bio;
bio = resumedao.retrieveBio(user_id);
lang_list = resumedao.retrieveLanguage(user_id);
%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Sniper Contractor - User Profile</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="../favicon.ico" type="image/x-icon" />

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700,800" rel="stylesheet">

    <link rel="stylesheet" href="../plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/dist/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/icon-kit/dist/css/iconkit.min.css">
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
                                <a class="dropdown-item" href="UserProfile.jsp"><i class="ik ik-user dropdown-icon"></i>
                                    Profile</a>
                                <a class="dropdown-item" href="UserSettings.jsp"><i class="ik ik-settings dropdown-icon"></i>
                                    Settings</a>
                                <a class="dropdown-item" href="../../Logout.jsp"><i class="ik ik-power dropdown-icon"></i>
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
                    <a class="header-brand" href="../UserPage.jsp">
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
                            <div class="nav-item">
                                <a href="../UserPage.jsp"><i class="ik ik-bar-chart-2"></i><span>Start</span></a>
                            </div>
                            <div class="nav-lavel">Job Openings</div>
                            <div class="nav-item">
                                <a href="JobOpeningPortalUser.jsp"><i class="ik ik-book-open"></i><span>My Job Openings</span></a>
                            </div>
                            <div class="nav-item">
                                <a href="UserJobOpeningApplied.jsp"><i class="ik ik-book"></i><span>Applies</span></a>
                            </div>
                            <div class="nav-lavel">Resume</div>
                            <div class="nav-item active">
                                <a href="UserProfile.jsp"><i class="ik ik-user"></i><span>Profile</span></a>
                            </div>
                            <div class="nav-item">
                                <a href="pages/"><i class="ik ik-award"></i><span>Analytics</span></a>
                            </div>
                            <div class="nav-lavel">Support</div>
                            <div class="nav-item">
                                <a href="javascript:void(0)"><i class="ik ik-help-circle"></i><span>Remove Doubts</span></a>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>


            <div class="main-content">
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-lg-4 col-md-5">
                            <div class="card">
                                <div class="card-body pb-1">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-4 col-sm-6 text-center">
                                            <img src="../img/user.jpg" class="rounded-circle" width="100" />
                                        </div>
                                        <div class="col-lg-6 col-md-8 col-sm-6 text-center">
                                            <div class="row text-center">
                                                <div class="col-12">
                                                    <h4 class="card-title mt-10"><%=name %> <%=lastname %></h4>
                                                </div>
                                                <div class="col-12">
                                                    <p class="card-subtitle"><%=profession.getProfession() %></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="card-body pt-0 sale-card">
                                    <h5 class="text-muted d-block pt-5 mt-3 text-center">Skills</h5>
                                    <hr class="pb-0">
                                    <p class="mb-10 text-left"><span class="badge badge-success">HTML</span><span
                                            class="float-right">Very good</span></p>
                                    <div class="progress mb-20">
                                        <div class="progress-bar bg-success" style="width:90%"></div>
                                    </div>
                                    <p class="mb-10 text-left"><span class="badge badge-yellow">Java</span><span
                                            class="float-right">Basic</span></p>
                                    <div class="progress mb-20">
                                        <div class="progress-bar bg-yellow" style="width:40%"></div>
                                    </div>
                                    <p class="mb-10 text-left"><span class="badge badge-primary">Ruby</span><span
                                            class="float-right">Good</span></p>
                                    <div class="progress mb-20">
                                        <div class="progress-bar bg-primary" style="width:60%"></div>
                                    </div>


                                    <div class="collapse" id="collapseSkills">
                                            <p class="mb-10 text-left"><span class="badge badge-yellow">Java</span><span
                                                    class="float-right">Basic</span></p>
                                            <div class="progress mb-20">
                                                <div class="progress-bar bg-yellow" style="width:40%"></div>
                                            </div>
                                            <p class="mb-10 text-left"><span class="badge badge-primary">Ruby</span><span
                                                    class="float-right">Good</span></p>
                                            <div class="progress mb-20">
                                                <div class="progress-bar bg-primary" style="width:60%"></div>
                                            </div>
                                        </div>
    
                                        <h6 class="viewmoreSkills">
                                            <a data-toggle="collapse" href="#collapseSkills" role="button"
                                                aria-expanded="false" aria-controls="collapseSkills">
                                                <small class="text-primary d-block pt-10"><i
                                                        class="fas fa-bars mr-10"></i>View more...</small>
                                            </a>
                                        </h6>

                                    <h5 class="text-muted d-block pt-5 mt-3 text-center">Languages</h5>
                                    <hr class="pb-0">
                                    <%for(Language lang : lang_list){ %>
                                    <h6 class="mb-1"><%=lang.getLanguage() %><span class="badge badge-secondary ml-2"><%=lang.getLevel() %></span></h6>
	                                 <%} %>   

                                    <h6 class="seemore languages" style="display:none"><a href="#!"><small
                                                class="text-primary d-block pt-10"><i class="fas fa-bars mr-10"></i> See
                                                more...</small></a>
                                    </h6>


                                    <h5 class="text-muted d-block pt-5 mt-3  text-center">Social Profiles</h5>
                                    <hr class="pb-0">
                                    <div class="row">
                                        <label class="col-sm-12 col-lg-12 col-form-label">
                                            <h6><i class="fa fa-globe mr-2"></i><a class="text-muted">Nenhum site
                                                    pŕoprio</a></h6>
                                        </label>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-12 col-lg-12 col-form-label">
                                            <h6><i class="fab fa-linkedin mr-2"></i><a
                                                    href="www.linkedin.com/user">Nenhum link vinculado</a></h6>
                                        </label>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-12 col-lg-12 col-form-label">
                                            <h6><i class="fab fa-facebook-f mr-2"></i><a
                                                    href="www.facebook.com/user">Nenhum link vinculado</a></h6>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 col-md-7">
                            <div class="card">
                                <ul class="nav nav-pills custom-pills" id="pills-tab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="pills-profile-tab" data-toggle="pill"
                                            href="#profile" role="tab" aria-controls="pills-profile"
                                            aria-selected="false">Profile</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="pills-experience-tab" data-toggle="pill"
                                            href="#experience" role="tab" aria-controls="pills-experience"
                                            aria-selected="false">Experience</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="pills-education-tab" data-toggle="pill"
                                            href="#education" role="tab" aria-controls="pills-education"
                                            aria-selected="false">Education</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="pills-setting-tab" data-toggle="pill" href="#options"
                                            role="tab" aria-controls="pills-options" aria-selected="false">Options</a>
                                    </li>
                                </ul>
                                <div class="tab-content" id="pills-tabContent">

                                    <!--Profile-->
                                    <div class="tab-pane fade show active" id="profile" role="tabpanel"
                                        aria-labelledby="pills-profile-tab">
                                        <div class="card-body">
                                            <div class="row mb-5 pb-5">
                                                <div class="col-12">
                                                    <h5>Personal Info</h5>
                                                    <hr class="mt-0 pt-0">
                                                </div>
                                                <div class="col-12">
                                                    <small class="text-muted d-block">Full name</small>
                                                    <h6><%=name %> <%=lastname %></h6>
                                                    <small class="text-muted d-block">Born Date</small>
                                                    <h6><%=born_date %></h6>
                                                    <small class="text-muted d-block">Email address </small>
                                                    <h6><%=email %></h6>
                                                    <small class="text-muted d-block pt-10">Phone</small>
                                                    <h6><%=userdao.retrievePhone(email) %></h6>
                                                    <small class="text-muted d-block pt-10">Location</small>
                                                    <h6><%=location.getCountry() %></h6>
                                                    <small class="text-muted d-block pt-10">Address</small>
                                                    <h6><%=location.getAddress() %></h6>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-12">
                                                    <h5>Professional Summary</h5>
                                                    <hr class="mt-0 pt-0">
                                                </div>
                                                <div class="col-12">
                                                    <p class="text-muted"><%=bio.getDescription() %></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="tab-pane fade" id="experience" role="tabpanel"
                                        aria-labelledby="pills-profile-tab">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-12">
                                                        <h5>Professional Experience</h5>
                                                    <hr class="mt-0 pt-0">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-2 pr-1">
                                                    <p>2006-12-present</p>
                                                </div>
                                                <div class="col-10 pl-0">
                                                    <h6>Senior Project Manager</h6>
                                                    <h6 class="text-muted">Setion Hospital, ME</h6>
                                                    <ul class="pl-4">
                                                        <li><span><i class="mdi mdi-lightbulb-outline"></i></span>An
                                                            electric light with a wire filament heated to such a
                                                            high
                                                            temperature that it glows with visible light</li>
                                                        <li><span><i
                                                                    class="mdi mdi-clipboard-check-outline"></i></span>A
                                                            thin, rigid board with a clip at the top for holding
                                                            paper
                                                            in place.</li>
                                                        <li><span><i class="mdi mdi-finance"></i></span>A graphical
                                                            representation of data, in which the data is represented
                                                            by
                                                            symbols, such as bars in a bar chart, lines in a line
                                                            chart,
                                                            or slices in a pie chart.</li>
                                                        <li><span><i class="mdi mdi-server"></i></span>A system that
                                                            responds to requests across a computer network worldwide
                                                            to
                                                            provide, or help to provide, a network or data service.
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-2 pr-1">
                                                    <p>2006-12-present</p>
                                                </div>
                                                <div class="col-10 pl-0">
                                                    <h6>Senior Project Manager</h6>
                                                    <h6 class="text-muted">Setion Hospital, ME</h6>
                                                    <ul class="pl-4">
                                                        <li><span><i class="mdi mdi-lightbulb-outline"></i></span>An
                                                            electric light with a wire filament heated to such a
                                                            high
                                                            temperature that it glows with visible light</li>
                                                        <li><span><i
                                                                    class="mdi mdi-clipboard-check-outline"></i></span>A
                                                            thin, rigid board with a clip at the top for holding
                                                            paper
                                                            in place.</li>
                                                        <li><span><i class="mdi mdi-finance"></i></span>A graphical
                                                            representation of data, in which the data is represented
                                                            by
                                                            symbols, such as bars in a bar chart, lines in a line
                                                            chart,
                                                            or slices in a pie chart.</li>
                                                        <li><span><i class="mdi mdi-server"></i></span>A system that
                                                            responds to requests across a computer network worldwide
                                                            to
                                                            provide, or help to provide, a network or data service.
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--Education-->
                                    <div class="tab-pane fade" id="education" role="tabpanel"
                                        aria-labelledby="pills-profile-tab">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-12">
                                                    <h5>Education</h5>
                                                    <hr class="mt-0 pt-0">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-2 pr-0">
                                                    <p>2006-12-present</p>
                                                </div>
                                                <div class="col-10 pl-0">
                                                    <h6>Senior Project Manager</h6>
                                                    <h6 class="text-muted">Setion Hospital, ME</h6>
                                                    <ul class="pl-4">
                                                        <li><span><i class="mdi mdi-lightbulb-outline"></i></span>An
                                                            electric light with a wire filament heated to such a
                                                            high
                                                            temperature that it glows with visible light</li>
                                                        <li><span><i
                                                                    class="mdi mdi-clipboard-check-outline"></i></span>A
                                                            thin, rigid board with a clip at the top for holding
                                                            paper
                                                            in place.</li>
                                                        <li><span><i class="mdi mdi-finance"></i></span>A graphical
                                                            representation of data, in which the data is represented
                                                            by
                                                            symbols, such as bars in a bar chart, lines in a line
                                                            chart,
                                                            or slices in a pie chart.</li>
                                                        <li><span><i class="mdi mdi-server"></i></span>A system that
                                                            responds to requests across a computer network worldwide
                                                            to
                                                            provide, or help to provide, a network or data service.
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--Options-->
                                    <div class="tab-pane fade" id="options" role="tabpanel"
                                        aria-labelledby="pills-setting-tab">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-12">
                                                    <h5>Options</h5>
                                                    <hr class="mt-0 pt-0">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-12">
                                                    <button type="button" class="btn btn-success btn-block"><i
                                                            class="fa fa-download"></i> Generate PDF</button>
                                                            <a href="UserUpdateProfile.jsp"><br/>
                                                    <button type="button" class="btn btn-primary btn-block"><i
                                                            class="fa fa-user-edit"></i> Edit Resume</button></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <footer class="footer">
                <div class="w-100 clearfix">
                    <span class="text-center text-sm-left d-md-inline-block">Copyright © 2019 Sniper Contractor Inc. v1.0 All Rights
                        Reserved.</span>
                    <span class="float-none float-sm-right mt-1 mt-sm-0 text-center">Hosted with <i
                            class="fa fa-heart text-danger"></i> by <a href="http://lavalite.org/" class="text-dark"
                            target="_blank">GitHub</a></span>
                </div>
            </footer>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>window.jQuery || document.write('<script src="../src/js/vendor/jquery-3.3.1.min.js"><\/script>')</script>
    <script src="../plugins/popper.js/dist/umd/popper.min.js"></script>
    <script src="../plugins/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="../plugins/screenfull/dist/screenfull.js"></script>
    <script src="../dist/js/theme.js"></script>
</body>

</html>