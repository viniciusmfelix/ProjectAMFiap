<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Sniper Contractor - Home</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet'
    type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/agency.min.css" rel="stylesheet">

</head>

<body id="page-top" class="d-flex flex-column">

  <header>
    <!-- Navbar fixa -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="Home.jsp">Sniper Contractor</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
          data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
          aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav text-uppercase ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#jobs">Job Openings</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">Contact</a>
            </li>
            <li class="nav-item">
              <a name="" id="" class="nav-button btn btn-primary" href="UserLogin.jsp" role="button">Login</a>
            </li>
            <li class="nav-item">
              <a name="" id="" class="nav-button btn btn-primary" href="UserRegister.jsp" role="button">Sign Up</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>

  <!-- Header -->
  <header class="masthead">
    <div class="container">
      <div class="intro-text">
        <div class="background-text">
          <div class="intro-lead-in">Get job alerts that fits your profile!</div>
          <a class="btn btn-primary btn-lg text-uppercase" href="UserRegister.jsp">Sign Up Here</a>
        </div>
      </div>
    </div>
  </header>

  <!-- Services -->
  <section class="page-section" id="services">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Services</h2>
          <h3 class="section-subheading text-muted">Know the advantages of our platform</h3>
        </div>
      </div>
      <div class="row text-center">
        <div class="col-md-4">
          <span class="fa-stack fa-4x">
            <i class="fas fa-circle fa-stack-2x text-primary"></i>
            <i class="fas fa-briefcase fa-stack-1x fa-inverse"></i>
          </span>
          <h4 class="service-heading">New Opportunities</h4>
          <p class="text-muted">Find and apply yourself to new job openings.</p>
        </div>
        <div class="col-md-4">
          <span class="fa-stack fa-4x">
            <i class="fas fa-circle fa-stack-2x text-primary"></i>
            <i class="fas fa-user fa-stack-1x fa-inverse"></i>
          </span>
          <h4 class="service-heading">Updated profile</h4>
          <p class="text-muted">Keep your profile always updated to our recruiters.</p>
        </div>
        <div class="col-md-4">
          <span class="fa-stack fa-4x">
            <i class="fas fa-circle fa-stack-2x text-primary"></i>
            <i class="fas fa-comments fa-stack-1x fa-inverse"></i>
          </span>
          <h4 class="service-heading">Real Feedback</h4>
          <p class="text-muted">Receive a personalized feedback for each apply.</p>
        </div>
      </div>
    </div>
  </section>

  <!-- Jobs Grid -->
  <section class="bg-light page-section" id="jobs">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Job Openings</h2>
          <h3 class="section-subheading text-muted"></h3>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4 col-sm-6 jobs-item">
          <a class="jobs-link" data-toggle="modal" href="#jobsModal1">
            <div class="jobs-hover">
              <div class="jobs-hover-content">
                <i class="fas fa-plus fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid" src="img/jobs/01-thumbnail.jpg" alt="">
          </a>
          <div class="jobs-caption">
            <h4>Sales Promoter</h4>
            <p class="text-muted">Responsible for analyzing and replacing missing products in the sales area.</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 jobs-item">
          <a class="jobs-link" data-toggle="modal" href="#jobsModal2">
            <div class="jobs-hover">
              <div class="jobs-hover-content">
                <i class="fas fa-plus fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid" src="img/jobs/02-thumbnail.jpg" alt="">
          </a>
          <div class="jobs-caption">
            <h4>Database Analyst</h4>
            <p class="text-muted">Development of routines based solutions.</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 jobs-item">
          <a class="jobs-link" data-toggle="modal" href="#jobsModal3">
            <div class="jobs-hover">
              <div class="jobs-hover-content">
                <i class="fas fa-plus fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid" src="img/jobs/03-thumbnail.jpg" alt="">
          </a>
          <div class="jobs-caption">
            <h4>Human Resources Analyst</h4>
            <p class="text-muted">We are looking for a senior analyst to compose our selection team.</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 jobs-item">
          <a class="jobs-link" data-toggle="modal" href="#jobsModal4">
            <div class="jobs-hover">
              <div class="jobs-hover-content">
                <i class="fas fa-plus fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid" src="img/jobs/04-thumbnail.jpg" alt="">
          </a>
          <div class="jobs-caption">
            <h4>Graphic Designer</h4>
            <p class="text-muted">Take care of the brand and watch over its graphic expressions.</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 jobs-item">
          <a class="jobs-link" data-toggle="modal" href="#jobsModal5">
            <div class="jobs-hover">
              <div class="jobs-hover-content">
                <i class="fas fa-plus fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid" src="img/jobs/05-thumbnail.jpg" alt="">
          </a>
          <div class="jobs-caption">
            <h4>BI Analyst</h4>
            <p class="text-muted">Analyze the global agribusiness market.</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 jobs-item">
          <a class="jobs-link" data-toggle="modal" href="#jobsModal6">
            <div class="jobs-hover">
              <div class="jobs-hover-content">
                <i class="fas fa-plus fa-3x"></i>
              </div>
            </div>
            <img class="img-fluid"  src="img/jobs/06-thumbnail.jpg" alt="">
          </a>
          <div class="jobs-caption">
            <h4>Java Developer</h4>
            <p class="text-muted">Work with the project team in a collaborative format, supporting technical issues.</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- About -->
  <section class="page-section" id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Sobre</h2>
          <h3 class="section-subheading text-muted">Conhe�a mais um pouco a nossa empresa</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <ul class="timeline">
            <li>
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="img/about/1.jpg" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>2009-2011</h4>
                  <h4 class="subheading">Our Humble Beginnings</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt ut voluptatum
                    eius sapiente, totam reiciendis temporibus qui quibusdam, recusandae sit vero unde, sed, incidunt et
                    ea quo dolore laudantium consectetur!</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="img/about/2.jpg" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>March 2011</h4>
                  <h4 class="subheading">An Agency is Born</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt ut voluptatum
                    eius sapiente, totam reiciendis temporibus qui quibusdam, recusandae sit vero unde, sed, incidunt et
                    ea quo dolore laudantium consectetur!</p>
                </div>
              </div>
            </li>
            <li>
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="img/about/3.jpg" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>December 2012</h4>
                  <h4 class="subheading">Transition to Full Service</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt ut voluptatum
                    eius sapiente, totam reiciendis temporibus qui quibusdam, recusandae sit vero unde, sed, incidunt et
                    ea quo dolore laudantium consectetur!</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="img/about/4.jpg" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>July 2014</h4>
                  <h4 class="subheading">Phase Two Expansion</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt ut voluptatum
                    eius sapiente, totam reiciendis temporibus qui quibusdam, recusandae sit vero unde, sed, incidunt et
                    ea quo dolore laudantium consectetur!</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
                <h4>Be Part
                  <br>Of Our
                  <br>Story!</h4>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>

  <!-- Contact -->
  <section class="page-section" id="contact">
    <div class="container">
      <div class="row mb-5">
        <div class="col-lg-12 text-center">
          <h1 class="section-heading text-uppercase">Fale Conosco</h1>
          <h2 class="section-subheading">Sugest�es, perguntas e suporte esse � o lugar perfeito!</h2>
        </div>
      </div>
      <div class="row p-5">
        <div class="col-lg-12">
          <form id="contactForm" name="sentMessage" novalidate="novalidate">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <input class="form-control" id="name" type="text" placeholder="Seu Nome *" required="required"
                    data-validation-required-message="Por favor escreva seu nome.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="email" type="email" placeholder="Seu Email *" required="required"
                    data-validation-required-message="Por favor escreva seu email.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="phone" type="tel" placeholder="Seu numero de telefone *"
                    required="required" data-validation-required-message="Por favor escreva seu numero de telefone.">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="col-md-6 mb-5">
                <div class="form-group">
                  <textarea class="form-control" id="message" placeholder="Sua Mensagem *" required="required"
                    data-validation-required-message="Por favor escreva uma mensagem."></textarea>
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="clearfix"></div>
              <div class="col-lg-12 text-center">
                <div id="success"></div>
                <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">Enviar
                  Mensagem</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer id="sticky-footer" class="footer bg-dark text-white-50">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-4">
          <small><span class="copyright">Copyright &copy; Sniper Contractor 2019</span></small>
        </div>
        <div class="col-4">
          <ul class="list-inline social-buttons">
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-twitter"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-facebook"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-linkedin"></i>
              </a>
            </li>
          </ul>
        </div>
        <div class="col-4">
          <ul class="list-inline quicklinks">
            <li class="list-inline-item">
              <a href="#">Privacy Policy</a>
            </li>
            <li class="list-inline-item">
              <a href="#">Terms of Use</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>

  <!-- jobs Modals -->

  <!-- Modal 1 -->
  <div class="jobs-modal modal fade" id="jobsModal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
          <div class="lr">
            <div class="rl"></div>
          </div>
        </div>
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <div class="modal-body">
                <!-- Project Details Go Here -->
                <h2 class="text-uppercase">Project Name</h2>
                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est
                  blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia
                  expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                <ul class="list-inline">
                  <li>Date: January 2017</li>
                  <li>Client: Threads</li>
                  <li>Category: Illustration</li>
                </ul>
                <button class="btn btn-primary" data-dismiss="modal" type="button">
                  <i class="fas fa-times"></i>
                  Close Project</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Modal 2 -->
  <div class="jobs-modal modal fade" id="jobsModal2" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
          <div class="lr">
            <div class="rl"></div>
          </div>
        </div>
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <div class="modal-body">
                <!-- Project Details Go Here -->
                <h2 class="text-uppercase">Project Name</h2>
                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est
                  blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia
                  expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                <ul class="list-inline">
                  <li>Date: January 2017</li>
                  <li>Client: Explore</li>
                  <li>Category: Graphic Design</li>
                </ul>
                <button class="btn btn-primary" data-dismiss="modal" type="button">
                  <i class="fas fa-times"></i>
                  Close Project</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Modal 3 -->
  <div class="jobs-modal modal fade" id="jobsModal3" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
          <div class="lr">
            <div class="rl"></div>
          </div>
        </div>
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <div class="modal-body">
                <!-- Project Details Go Here -->
                <h2 class="text-uppercase">Project Name</h2>
                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est
                  blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia
                  expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                <ul class="list-inline">
                  <li>Date: January 2017</li>
                  <li>Client: Finish</li>
                  <li>Category: Identity</li>
                </ul>
                <button class="btn btn-primary" data-dismiss="modal" type="button">
                  <i class="fas fa-times"></i>
                  Close Project</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Modal 4 -->
  <div class="jobs-modal modal fade" id="jobsModal4" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
          <div class="lr">
            <div class="rl"></div>
          </div>
        </div>
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <div class="modal-body">
                <!-- Project Details Go Here -->
                <h2 class="text-uppercase">Project Name</h2>
                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est
                  blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia
                  expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                <ul class="list-inline">
                  <li>Date: January 2017</li>
                  <li>Client: Lines</li>
                  <li>Category: Branding</li>
                </ul>
                <button class="btn btn-primary" data-dismiss="modal" type="button">
                  <i class="fas fa-times"></i>
                  Close Project</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Modal 5 -->
  <div class="jobs-modal modal fade" id="jobsModal5" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
          <div class="lr">
            <div class="rl"></div>
          </div>
        </div>
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <div class="modal-body">
                <!-- Project Details Go Here -->
                <h2 class="text-uppercase">Project Name</h2>
                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est
                  blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia
                  expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                <ul class="list-inline">
                  <li>Date: January 2017</li>
                  <li>Client: Southwest</li>
                  <li>Category: Website Design</li>
                </ul>
                <button class="btn btn-primary" data-dismiss="modal" type="button">
                  <i class="fas fa-times"></i>
                  Close Project</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Modal 6 -->
  <div class="jobs-modal modal fade" id="jobsModal6" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
          <div class="lr">
            <div class="rl"></div>
          </div>
        </div>
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <div class="modal-body">
                <!-- Project Details Go Here -->
                <h2 class="text-uppercase">Project Name</h2>
                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est
                  blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia
                  expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                <ul class="list-inline">
                  <li>Date: January 2017</li>
                  <li>Client: Window</li>
                  <li>Category: Photography</li>
                </ul>
                <button class="btn btn-primary" data-dismiss="modal" type="button">
                  <i class="fas fa-times"></i>
                  Close Project</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact form JavaScript -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/agency.min.js"></script>

</body>

</html>