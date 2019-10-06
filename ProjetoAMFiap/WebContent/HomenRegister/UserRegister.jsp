<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Sniper Contractor - Register</title>

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
              <a class="nav-link js-scroll-trigger" href="../#services">Services</a>
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

  <div class="bg-bussines d-flex align-content-center flex-wrap" id="page-content">
    <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-12 col-sm-10 col-md-8 col-lg-8 col-xl-8">
                <div class="card w-100 mx-auto">
                    <div class="col-10 card-body align-self-center">
                        <form action="../userregister" method="POST" id="regForm">

                            <h1 class="text-center mt-0">Register</h1>
                            <!-- Circles which indicates the steps of the form: -->
                            <hr>
                            <div class="text-center">
                                <span class="step"></span>
                                <span class="step"></span>
                                <span class="step"></span>
                            </div>
                            <hr>

                            <!-- One "tab" for each step in the form: -->
                            <div class="tab mt-3">
                                <div class="form-group">
                                    <div class="col-12 mb-3">
                                        <h5 class="pt-2 mb-0"><label for="validationServer01">First name</label></h5>
                                        <input type="text" name="firstname" class="form-control form-control-lg" id="validationServer01"
                                            placeholder="First name" oninput="validateInput(this)" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <h5 class="pt-2 mb-0"><label for="validationServer02">Last name</label></h5>
                                        <input type="text" name="lastname"class="form-control form-control-lg" id="validationServer02"
                                            placeholder="Last name" oninput="validateInput(this)" required>
                                    </div>
                                </div>

                                <h5 class="text-center mt-4">Or sign up with:</h5>

                                <div class="card-body template-demo text-center">
                                    <button type="button" class="btn social-btn-lg btn-facebook"><i
                                            class="fab fa-facebook-f"></i></button>
                                    <button type="button" class="btn social-btn-lg btn-linkedin"><i
                                            class="fab fa-linkedin"></i></button>
                                    <button type="button" class="btn social-btn-lg btn-google"><i
                                            class="fab fa-google"></i></button>
                                </div>
                            </div>

                            <div class="tab mt-3">
                                <div class="form-group">
                                    <div class="col-12 mb-3">
                                        <h5 class="pt-2 mb-0"><label for="validationServer06">Email</label></h5>
                                        <input  type="email" name="email" class="form-control form-control-lg" id="validationServer06" placeholder="example@example.com"
                                            oninput="validateInput(this)" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <h5 class="pt-2 mb-0"><label for="validationServer06">Born Date</label></h5>
                                        <input  type="date" name="born_date" class="form-control form-control-lg" id="validationServer06" placeholder="example@example.com"
                                            oninput="validateInput(this)" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <h5 class="pt-2 mb-0"><label for="validationServer07">Phone</label></h5>
                                        <input type="tel" name="telephone" class="form-control form-control-lg" id="validationServer07" placeholder="Only numbers"
                                            oninput="validateInput(this)" required>
                                    </div>
                                </div>
                            </div>

                            <div class="tab mt-3">
                                <div class="form-group">
                                    <div class="col-12 mb-3">
                                        <h5 class="pt-2 mb-0"><label for="validationServer06">Password</label></h5>
                                        <input type="password" name="password" class="form-control form-control-lg" id="validationServer06" placeholder="Password"
                                            oninput="validateInput(this)" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <h5 class="pt-2 mb-0"><label for="validationServer07">Confirm Password</label></h5>
                                        <input type="password" name="password_confirm" class="form-control form-control-lg" id="validationServer07" placeholder="Confirm Password"
                                            oninput="validateInput(this)" required>
                                    </div>
                                </div>
                            </div>

                            <div class="row pt-3">
                                <div class="col-6 float-left">
                                    <button type="button" class="btn btn-secondary btn-lg" id="prevBtn"
                                        onclick="nextPrev(-1)">Previous</button>
                                </div>
                                <div class="col-6 float-right">
                                    <button type="button" class="btn btn-theme btn-lg float-right" id="nextBtn"
                                        onclick="nextPrev(1)">Next</button>
                                </div>
                                
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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

  <script>
    var currentTab = 0; // Current tab is set to be the first tab (0)
    showTab(currentTab); // Display the current tab
    function showTab(n) {
      // This function will display the specified tab of the form ...
      var x = document.getElementsByClassName("tab");
      x[n].style.display = "block";
      // ... and fix the Previous/Next buttons:
      if (n == 0) {
        document.getElementById("prevBtn").style.display = "none";
      } else {
        document.getElementById("prevBtn").style.display = "inline";
      }
      if (n == (x.length - 1)) {
        document.getElementById("nextBtn").innerHTML = "Submit";
      } else {
        document.getElementById("nextBtn").innerHTML = "Next";
      }
      // ... and run a function that displays the correct step indicator:
      fixStepIndicator(n)
    }
    function nextPrev(n) {
      // This function will figure out which tab to display
      var x = document.getElementsByClassName("tab");
      // Exit the function if any field in the current tab is invalid:
      if (n == 1 && !validateForm()) return false;
      // Hide the current tab:
      x[currentTab].style.display = "none";
      // Increase or decrease the current tab by 1:
      currentTab = currentTab + n;
      // if you have reached the end of the form... :
      if (currentTab >= x.length) {
        //...the form gets submitted:
        document.getElementById("regForm").submit();
        return false;
      }
      // Otherwise, display the correct tab:
      showTab(currentTab);
    }
    function validateForm() {
      // This function deals with validation of the form fields
      var x, y, i, valid = true;
      x = document.getElementsByClassName("tab");
      y = x[currentTab].getElementsByTagName("input");
      // A loop that checks every input field in the current tab:
      for (i = 0; i < y.length; i++) {
        // If a field is empty...
        if (y[i].value == "") {
          // add an "invalid" class to the field:
          y[i].className += " invalid";
          // and set the current valid status to false:
          valid = false;
        }
      }
      // If the valid status is true, mark the step as finished and valid:
      if (valid) {
        document.getElementsByClassName("step")[currentTab].className += " finish";
      }
      return valid; // return the valid status
    }
    function validateInput(n) {
      n.className = "form-control form-control-lg";
    }
    function fixStepIndicator(n) {
      // This function removes the "active" class of all steps...
      var i, x = document.getElementsByClassName("step");
      for (i = 0; i < x.length; i++) {
        x[i].className = x[i].className.replace(" active", "");
      }
      //... and adds the "active" class to the current step:
      x[n].className += " active";
    }
  </script>

</body>

</html>