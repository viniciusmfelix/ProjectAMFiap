<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Language"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Bio"%>
<%@page import="com.model.Location"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.model.Profession"%>
<%@page import="com.dao.ResumeDAO"%>
<%@page import="com.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
int lang_repeat = 0;
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
    <title>Sniper Contractor - Update Profile</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="../favicon.ico" type="image/x-icon" />

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700,800" rel="stylesheet">

    <link rel="stylesheet" href="../plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/dist/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/icon-kit/dist/css/iconkit.min.css">
    <link rel="stylesheet" href="../plugins/mohithg-switchery/dist/switchery.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet">
    <link href="https://raw.githack.com/ttskch/select2-bootstrap4-theme/master/dist/select2-bootstrap4.min.css"
        rel="stylesheet">
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
                                <a href="UserFeedbacks.jsp"><i class="ik ik-award"></i><span>Feedbacks</span></a>
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

                                    <form class="repeater" action="../../extracourses" method="post">
                                        <div data-repeater-list="group-skills">
                                            <div class="form-row" data-repeater-item>
                                                <div class="form-group col-6">
                                                    <input type="text" name="skill" class="form-control" id="skill"
                                                        placeholder="Skill name">
                                                </div>
                                                <div class="form-group col-5">
                                                    <select class="form-control select2-single" name="level_skill"
                                                        id="selectLevel">
                                                        <option></option>
                                                        <option value="beginner">beginner</option>
                                                        <option value="intermediate">Intermediate</option>
                                                        <option value="advanced">Advanced</option>
                                                        <option value="expert">Expert</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-1 d-flex justify-content-center">
                                                    <button data-repeater-delete class="btn btn-link  btn-trash"
                                                        type="button"><i class="ik ik-trash-2"></i></a>
                                                </div>
                                            </div>
                                        </div>

                                        <button data-repeater-create type="button"
                                            class="btn btn-outline-secondary btn-block"><i class="fas fa-plus"></i>
                                            Add</button>
                                        <br>
                                        <button type="submit" name="skill_sub" class="btn btn-success float-right" value="Save">Save</button>
                                         <button type="submit"  name="skill_sub" class="btn btn-success float-right" value="Update" style="margin-right:15px">Update</button>
                                          <button type="submit" name="skill_sub" class="btn btn-success float-right" value="Delete" style="margin-right:15px">Delete</button>
                                    </form>

                                </div>

                                <div class="card-body pt-0 sale-card">
                                    <h5 class="text-muted d-block pt-5 mt-3 text-center">Languages</h5>
                                    <hr class="pb-0">

                                    <form class="repeater" action="../../languages" method="post">
                                        <div data-repeater-list="group-languages">
                                            <div class="form-row" data-repeater-item>
                                           
                                                <div class="form-group col-6">   
                                                <input type="text" name="language" class="form-control" id="skill"
                                                        placeholder="Language" required>
                                                </div>
                                                
                                                <div class="form-group col-5">
                                                    <select class="form-control select2-single" name="level_language"
                                                        id="selectLevel" required> 
                                                        <option></option>
                                                        <option value="beginner">Beginner</option>
                                                        <option value="intermediate">Intermediate</option>
                                                        <option value="advanced">Advanced</option>
                                                        <option value="fluent">Fluent</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-1 d-flex justify-content-center">
                                                    <button data-repeater-delete class="btn btn-link btn-trash"
                                                        type="submit"><i class="ik ik-trash-2"></i></a>                
                                                </div>
                                            </div>
                                        </div>
                                        <button data-repeater-create type="button"
                                            class="btn btn-outline-secondary btn-block" ><i class="fas fa-plus"></i>
                                            Add </button>

                                        <br>
                                        <button type="submit" name="lang_sub" class="btn btn-success float-right" value="Save">Save</button>
                                        <button type="submit" name="lang_sub" class="btn btn-success float-right" style="margin-right:15px;" value="Update">Update</button>
                                         <button type="submit" name="lang_sub" class="btn btn-success float-right" style="margin-right:15px;" value="Delete">Delete</button>
                                    </form>

                                </div>

                                <div class="card-body pt-0 sale-card">
                                    <h5 class="text-muted d-block pt-5 mt-3  text-center">Social Profiles</h5>
                                    <hr class="pb-0">

                                    <form action="" method="post">
                                        <div class="form-row">
                                            <label class="sr-only" for="linkMyself">Meu Site</label>
                                            <div class="input-group mb-2 mr-sm-2">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text"><i class="fa fa-globe mr-2"></i>
                                                    </div>
                                                </div>
                                                <input id="linkMyself" class="form-control" type="text"
                                                    name="linkMyself">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <label class="sr-only" for="linkLinkedin">Linkedin</label>
                                            <div class="input-group mb-2 mr-sm-2">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text"><i class="fab fa-linkedin mr-2"></i>
                                                    </div>
                                                </div>
                                                <input id="linkLinkedin" class="form-control" type="text"
                                                    name="linkLinkedin">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <label class="sr-only" for="linkFacebook">Facebook</label>
                                            <div class="input-group mb-2 mr-sm-2">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text"><i class="fab fa-facebook-f mr-2"></i>
                                                    </div>
                                                </div>
                                                <input id="linkFacebook" class="form-control" type="text"
                                                    name="linkFacebook">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-success float-right">Save</button>
                                    </form>
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
                                                    <form name="personalInfo" action="../../personalinfo" method="post">
                                                        <div class="form-row">
                                                            <div class="form-group col-md-6">
                                                                <label for="firstName">First name</label>
                                                                <input type="text" name="firstname" class="form-control"
                                                                    id="firstName" value="<%=name %>" required>
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label for="lastName">Last name</label>
                                                                <input type="text" name="lastname" class="form-control"
                                                                    id="lastName" value="<%=lastname %>" required>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="profession"
                                                                class="control-label">Profession</label>
                                                            <input type="text" class="form-control" id="profession" name="profession" value="<%=profession.getProfession() %>"
                                                               required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="dateBirth">Date Of Birth</label>
                                                            <input type="date" name="borndate" class="form-control"
                                                                id="dateBirth" aria-describedby="emailHelp" value="<%=born_date%>">
                                                            <small id="age" class="form-text text-muted">21 years
                                                                old
                                                                (example)</small>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="email">Email address</label>
                                                            <input type="email" class="form-control" id="email"  value="<%=email %>"
                                                                disabled required>
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-6">
                                                                <label for="phone">Phone</label>
                                                                <input type="tel" name="phone" class="form-control" value="<%=phone %>"
                                                                    id="Phone" required>
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label for="location">Location</label>
                                                                <input type="local" name="country" class="form-control" value="<%=location.getCountry() %>"
                                                                    id="location" required>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="address">Address</label>
                                                            <input type="local" name="address" class="form-control" value="<%=location.getAddress() %>"
                                                                id="address" >
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-12">
                                                                <h5>Professional Summary</h5>
                                                                <hr class="mt-0 pt-0">
                                                            </div>
                                                            <div class="form-group col-12">
                                                                <label for="professionalSummary">Skills,
                                                                    experiences and achievements as they pertain to
                                                                    a
                                                                    job opening</label>
                                                                <textarea class="form-control"
                                                                    name="bio" id="professionalSummary"
                                                                    rows="5" ><%=bio.getDescription() %></textarea>
                                                            </div>
                                                        </div>
                                                        <button type="submit"
                                                            class="btn btn-success float-right">Save</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--PE-->
                                    <div class="tab-pane fade" id="experience" role="tabpanel"
                                        aria-labelledby="pills-profile-tab">
                                        <div class="card-body">
                                            <div class="row mb-5 pb-5">
                                                <div class="col-6">
                                                    <h5 class="card-title">Professional Experience</h5>
                                                </div>

                                                <div class="col-6 d-flex justify-content-end">
                                                    <h6 class="text-muted mr-5">i don't have any</h6>
                                                    <input name="havePE" id="havePE" type="checkbox"
                                                        class="mr-3 js-small" />
                                                </div>

                                                <div class="col-12">
                                                    <hr class="mt-0 pt-0">
                                                </div>

                                                <div class="col-12">
                                                    <h2 class="p-5 text-center d-none" id="messagePE">We hope you get
                                                        your
                                                        next job soon.</h2>
                                                </div>

                                                <div class="col-12" id="PEs">
                                                    <form class="repeater" name="formPE" id="formPE" action="../../professionalexperience"
                                                        method="post">
                                                        <div data-repeater-list="group-PEs">
                                                            <input type="number" name="countPEs" id="countPEs" hidden>
                                                            <div id="item-PE" class="item-PE" data-repeater-item>
                                                                <div class="card card-with-border mb-3">
                                                                    <div class="card-header " id="headingPE1">
                                                                        <div class="col-6">
                                                                            <h5 class="mb-0">(Not specified)</h5>
                                                                            <small>start date - end date</small>
                                                                        </div>
                                                                        <div class="col-6 d-flex justify-content-end">
                                                                            <button type="button"
                                                                                class="btn btn-link btn-expand pr-0 justify-content-end btn-CPE"
                                                                                data-toggle="collapse"
                                                                                data-target="#collapsePE1"
                                                                                aria-expanded="true"
                                                                                aria-controls="collapsePE1">
                                                                                <i class="fa fa-sort"
                                                                                    aria-hidden="true"></i>
                                                                            </button>
                                                                            <button type="button"
                                                                                class="btn btn-link pr-0 justify-content-end btn-trash"
                                                                                data-repeater-delete>
                                                                                <i class="ik ik-trash-2"></i>
                                                                            </button>
                                                                        </div>
                                                                    </div>

                                                                    <div id="collapsePE1" class="collapse show"
                                                                        aria-labelledby="headingPE1"
                                                                        data-parent="#item-PE">
                                                                        <div class="card-body">
                                                                            <div class="experiencePE">
                                                                                <div class="form-row">
                                                                                    <div class="form-group col-md-6">
                                                                                        <label for="jobTitle">Job
                                                                                            Title</label>
                                                                                        <input id="jobTitle"
                                                                                            class="form-control"
                                                                                            type="text" name="jobTitle"
                                                                                            required>
                                                                                    </div>
                                                                                    <div class="form-group col-md-6">
                                                                                        <label
                                                                                            for="employer">Employer</label>
                                                                                        <input id="employer"
                                                                                            class="form-control"
                                                                                            type="text" name="employer"
                                                                                            required>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-row">
                                                                                    <div class="form-group col-6 pr-1">
                                                                                        <label for="startDate">Start
                                                                                            Date</label>
                                                                                        <input id="startDate"
                                                                                            class="form-control"
                                                                                            type="date"
                                                                                            name="startDate">
                                                                                    </div>
                                                                                    <div class="form-group col-6 pl-0">
                                                                                        <div class="form-group">
                                                                                            <label for="endDate">End
                                                                                                Date</label>
                                                                                            <input id="endDate"
                                                                                                class="form-control"
                                                                                                type="date"
                                                                                                name="endDate">
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-row">
                                                                                    <div class="form-group col-12">
                                                                                        <label
                                                                                            for="jobDescription">Description</label>
                                                                                        <textarea class="form-control"
                                                                                            name="jobDescription"
                                                                                            id="jobDescription"
                                                                                            rows="5"></textarea>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <button type="button" name="" id=""
                                                            class="btn btn-outline-secondary btn-block"
                                                            data-repeater-create><i class="fa fa-plus"
                                                                aria-hidden="true"></i> add
                                                            More</button>
                                                        <br>
                                                        <button type="submit" name="pe_sub" class="btn btn-success float-right"
                                                            id="savePEs" value="Save">Save</button>
                                                          <button type="submit" name="pe_sub" class="btn btn-success float-right"
                                                            id="savePEs" value="Update" style="margin-right:15px">Update</button>
                                                          <button type="submit" name="pe_sub" class="btn btn-success float-right"
                                                            id="savePEs" value="Delete" style="margin-right:15px">Delete</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>



                                    <!--Education-->
                                    <div class="tab-pane fade" id="education" role="tabpanel"
                                        aria-labelledby="pills-profile-tab">
                                        <div class="card-body">
                                            <div class="row mb-5 pb-5">
                                                <div class="col-12">
                                                    <h5>Education</h5>
                                                    <hr class="mt-0 pt-0">
                                                </div>
                                                <div class="col-12">
                                                    <form class="repeater" name="formEducation" action="../../academictrainings" method="post">
                                                        <div data-repeater-list="group-educations">
                                                            <div id="accordion" data-repeater-item>
                                                                <div class="card card-with-border mb-3">
                                                                    <div class="card-header " id="headingED1">
                                                                        <div class="col-6">
                                                                            <h5 class="mb-0">(Not specified)</h5>
                                                                            <small>start date - end date</small>
                                                                        </div>
                                                                        <div class="col-6 d-flex justify-content-end">
                                                                            <button type="button"
                                                                                class="btn btn-link btn-expand pr-0 justify-content-end"
                                                                                data-toggle="collapse"
                                                                                data-target="#collapseED1"
                                                                                aria-expanded="true"
                                                                                aria-controls="collapseED1">
                                                                                <i class="fa fa-sort"
                                                                                    aria-hidden="true"></i>
                                                                            </button>
                                                                            <button type="button"
                                                                                class="btn btn-link pr-0 justify-content-end btn-trash"
                                                                                data-repeater-delete>
                                                                                <i class="ik ik-trash-2"></i>
                                                                            </button>
                                                                        </div>
                                                                    </div>

                                                                    <div id="collapseED1" class="collapse show"
                                                                        aria-labelledby="headingED1"
                                                                        data-parent="#accordion">
                                                                        <div class="card-body">
                                                                            <div class="education">
                                                                                <div class="form-row">
                                                                                    <div class="form-group col-md-6">
                                                                                        <label
                                                                                            for="school">School</label>
                                                                                        <input id="school"
                                                                                            class="form-control"
                                                                                            type="text" name="school">
                                                                                    </div>
                                                                                    <div class="form-group col-md-6">
                                                                                        <label
                                                                                            for="degree">Degree</label>
                                                                                        <input id="degree"
                                                                                            class="form-control"
                                                                                            type="text" name="degree">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-row">
                                                                                    <div class="form-group col-6 pr-1">
                                                                                        <label for="startDate">Start
                                                                                            Date</label>
                                                                                        <input id="startDate"
                                                                                            class="form-control"
                                                                                            type="date"
                                                                                            name="startDate">
                                                                                    </div>
                                                                                    <div class="form-group col-6 pl-0">
                                                                                        <div class="form-group">
                                                                                            <label for="endDate">End
                                                                                                Date</label>
                                                                                            <input id="endDate"
                                                                                                class="form-control"
                                                                                                type="date"
                                                                                                name="endDate">
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-row">
                                                                                    <div class="form-group col-12">
                                                                                        <label
                                                                                            for="educationDescription">Description</label>
                                                                                        <textarea class="form-control"
                                                                                            name="educationDescription"
                                                                                            id="educationDescription"
                                                                                            rows="5"></textarea>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <button type="button" name="" id=""
                                                            class="btn btn-outline-secondary btn-block"
                                                            data-repeater-create><i class="fa fa-plus"
                                                                aria-hidden="true"></i> add
                                                            More</button>
                                                        <br>
                                                        <button type="submit"
                                                            class="btn btn-success float-right" name = "at_sub" value="Save">Save</button>
                                                        <button type="submit"
                                                            class="btn btn-success float-right" name = "at_sub" value="Update" style="margin-right:15px">Update</button>
                                                        <button type="submit"
                                                            class="btn btn-success float-right"  name = "at_sub" value="Delete" style="margin-right:15px">Delete</button>
                                                    </form>
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
                    <span class="text-center text-sm-left d-md-inline-block">Copyright © 2018 ThemeKit v2.0. All
                        Rights
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.full.min.js"></script>
    <script src="../js/select.js"></script>
    <script src="../plugins/jquery.repeater/jquery.repeater.min.js"></script>
    <script src="../js/repeater.js"></script>
    <script src="../plugins/mohithg-switchery/dist/switchery.min.js"></script>
    <script src="../js/swithes.js"></script>
    <script src="../dist/js/theme.js"></script>
    <script>
        $(document).ready(function () {

            function changeSwitchery(element, checked) {
                if ((element.is(':checked') && checked == false) || (!element.is(':checked') && checked == true)) {
                    element.parent().find('.switchery').trigger('click');
                }
            }

            $('#havePE').change(function () {

                if ($(this).is(':checked')) {
                    if (confirm("are you sure you want to delete work experience fields ?")) {

                        $('#PEs').addClass("d-none");
                        $("#messagePE").removeClass("d-none");

                        //Apagar inputs

                    } else {
                        changeSwitchery($('#havePE'), false);
                    }
                } else {
                    $('#PEs').removeClass("d-none");
                    $("#messagePE").addClass("d-none");
                }

            });

            $("#countPEs").each(function () {
            });


        });
    </script>
</body>

</html>