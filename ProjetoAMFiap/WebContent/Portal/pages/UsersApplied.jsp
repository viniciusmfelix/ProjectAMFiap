<%@page import="com.model.AcademicTraining"%>
<%@page import="com.model.ProfessionalExperience"%>
<%@page import="com.model.Language"%>
<%@page import="com.model.ExtracurricularCourse"%>
<%@page import="com.model.Location"%>
<%@page import="com.dao.ResumeDAO"%>
<%@page import="com.model.Profession"%>
<%@page import="com.dao.JobOpeningDAO"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
ResumeDAO resumedao = new ResumeDAO();
int job_id = (int) session.getAttribute("jobid");
JobOpeningDAO jobopeningdao = new JobOpeningDAO();
List<User> user_list = jobopeningdao.usersApplied(job_id);
Profession profession = new Profession();
Location location = new Location();
List<ExtracurricularCourse> skills;
List<Language> languages;
List<ProfessionalExperience> pe_list;
List<AcademicTraining> ac_list;
%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Sniper Contractor - Applies</title>
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
                                <a class="dropdown-item" href="../../HomenRegister/RecruiterLogin.jsp"><i class="ik ik-power dropdown-icon"></i>
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
                                <a href="../RecruiterPage.jsp"><i class="ik ik-bar-chart-2"></i><span>Start</span></a>
                            </div>
                            <div class="nav-lavel">Users Applied</div>
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
                            <div class="nav-lavel"></div>
                            <div class="nav-item">
                               
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
                                    <h3>Users Applied</h3>
                                    <a href="SelectBestUser.jsp" style="position:absolute;margin-left:1300px">Select Best User Applied</a>
                                </div>
                                
                                <div class="card-body">
                                    <table id="data_table" class="table">
                                        <thead>
                                            <tr>
                                                <th>Resume</th>
                                                <th>Skills</th>
                                                <th>Languages</th>
                                                <th>Email</th>
                                                <th class="nosort">&nbsp;</th>
                                            </tr>
                                        </thead>
                                        <%for(User user : user_list){ %>
                    					<%location = resumedao.retrieveLocation(user.getUser_id()); %>
                    					<%ac_list = resumedao.retrieveAcademicTraining(user.getUser_id()); %>
                                        <tbody>
                                            <tr>
                                                <td>
                                                
                                                    <div class="d-inline-block align-middle">
                                                    
                                                        
                                                        <div class="d-inline-block">
                                                            <h6><%=user.getFirstname() %> <%=user.getLastname() %></h6>
                                                            <p class="text-muted mb-0"><%profession = resumedao.retrieveProfession(user.getUser_id()); %><%=profession.getProfession() %></p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary"><%skills = resumedao.retrieveExtracurricularCourse(user.getUser_id()); for(ExtracurricularCourse skill: skills){%>
                                                    <br/><%=skill.getCourse() %><br/>
                                                    <%} %>
                                                    </label>
                                                </td>
                                                <td>
                                                    <label class="badge badge-primary"><%languages = resumedao.retrieveLanguage(user.getUser_id()); for(Language lang : languages){ %>
                                                    <br/><%=lang.getLanguage() %><br/>
                                                    <%} %>
                                                    </label>
                                                </td>
                                                
                                                <td><%=user.getEmail() %></td>
                                                <td>
                                                    <div class="table-actions text-center">
                                                    
                                                        <a href="#editLayoutItem" data-toggle="modal"
                                                        data-target="#editLayoutItem" ><i class="ik ik-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                         <%} %>
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
                <%for(User user : user_list){ %>
				<%skills = resumedao.retrieveExtracurricularCourse(user.getUser_id()); %>
				<%ac_list = resumedao.retrieveAcademicTraining(user.getUser_id()); %>
				<%profession = resumedao.retrieveProfession(user.getUser_id()); %>
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="d-inline-block align-middle">
                                
                                <div class="d-inline-block"><%%>
                                    <h6><%=user.getFirstname()%> <%=user.getLastname() %></h6>
                                    <p class="text-muted mb-0"><%=profession.getProfession() %>, <%=location.getCountry() %></p>
                                </div>
                            </div>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                        </div>
                        <div class="modal-body">
                            <p class="lead"><h6>Professional Experience</h6><%pe_list = resumedao.retrieveProfessionalExperience(user.getUser_id()); %>
 							<%for(ProfessionalExperience pe : pe_list){ %>                           
                            <strong>Title: </strong><%=pe.getJobtitle() %>, <strong>Employer: </strong><%=pe.getEmployer() %><br/>
                            <strong>Start:</strong> <%=pe.getStart_date() %>, <strong>End:</strong> <%=pe.getEnd_date() %><br/>
                            <strong>Description: </strong><%=pe.getJobdescription() %>
                            <%} %>
                            </p>
                            <div class="row">
                                <div class="col-md-6"><img src="../img/portfolio-1.jpg" class="img-fluid" alt=""></div>
                                <div class="col-md-6"><img src="../img/portfolio-8.jpg" class="img-fluid" alt=""></div>
                            </div>
                            <div class="jumbotron pt-30 pb-30 mt-30">
                                <h2 class="mt-0">Skills for Job: <%for(ExtracurricularCourse skill : skills){%></h2>
                                <p class="lead">
                                <strong>Skill: </strong> <%=skill.getCourse() %> - <strong>Level: </strong><%=skill.getLevel() %>
                                
                                <%} %>
                                </p>
                            </div>
                            <p>
                             <h6>Academic Training</h6>
                            <%for(AcademicTraining ac: ac_list){ %>
                            <%if(ac.getCourse() != ""){ %>
                            <strong>Course: </strong><%=ac.getCourse() %>, <strong>Institution: </strong><%=ac.getInstitution() %><br/>
                            <strong>Start: </strong><%=ac.getStart_date() %>, <strong>End: </strong><%=ac.getEnd_date() %><br/>
                            <strong>Description: </strong><%=ac.getDescription() %>
                            <%}else{%>
                            <strong>Don't have any.</strong>
                            <%}} %>
                            </p>
                        </div>
                  		
                  		
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-times" aria-hidden="true"></i> Close</button>
                            <%session.setAttribute("usermail",user.getEmail()); %>
                            <a href="SelectBestUser.jsp"><button type="button" class="btn btn-success"><i class="fa fa-comments"></i> Set Feedback</button></a>
                        	
                        </div>
                     
                    </div>
                       <%} %> 
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