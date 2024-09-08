<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/contact-us.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <!-- Hero banner -->
      <div class="container-fluid jumbotron">
        <div class="container">
          <h2 class="pt-5" style="color: aliceblue; font-weight: 900;">GET IN TOUCH</h2><br>
          <p style="color:aliceblue">We welcome any inquiries</p>
        </div>
      </div>

      <!-- Contact -->
      <div class="container mt-4 d-flex justify-content-center flex-column flex-lg-row">
        <div class="contact mb-3">
          <h3 class="text-center">Ask Question</h3>
          <form action="">
            <label class="form-label">Your name</label>
            <input type="text" class="form-control mb-2" name="name" />

            <label class="form-label">Email</label>
            <input type="text" class="form-control mb-2" name="email" />

            <label class="form-label">Message</label>
            <textarea class="form-control" name="message"></textarea>

            <button class="btn mt-4" style=" background-color: #ED3D63; color: aliceblue;" type="submit">Send Question</button>
          </form>
        </div>
        <div class="social-media mb-3">
          <h3 class="text-center">Contact</h3>
          <ul>
            <li><i class="fa-solid fa-phone"></i> <a href="">+62382344878</a>
            <li><i class="fa-solid fa-envelope"></i> <a href="">abc.cars@email.com</a></li>
            <li><i class="fa-solid fa-location-pin"></i> Philippines</li>
            <li class="text-center"><i class="fa-brands fa-facebook"></i> <i class="fa-brands fa-instagram"></i> <i class="fa-brands fa-twitter"></i></li>
          </ul>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="components/footer.jsp" %>
  </body>
</html>
