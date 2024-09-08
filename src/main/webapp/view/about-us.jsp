<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/about-us.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container-fluid jumbotron">
      </div>
      

      <div class="container mt-4 d-flex">
        <div class="about p-4">
          <h3 class="fw-bolder">About Us</h3>
          <p class="text-secondary">
            Founded in the Philippines, ABC.cars is a dynamic digital platform revolutionizing the automotive industry. 
            Our innovative solutions empower car shoppers to make informed decisions while seamlessly connecting with dealers. 
            With a focus on efficiency and customer experience, we continue to lead the way in transforming the car-buying journey.
          </p>
        </div>
        <img class="image-about" src="/images/background/aboutus.jpg" alt="cars" />
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="components/footer.jsp" %>
  </body>
</html>
