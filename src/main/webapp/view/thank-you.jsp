<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/thank-you.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <section class="mt-5">
        <div class="container d-flex justify-content-center">
          <div class="confirmation d-flex flex-column text-center">
            <i class="fa-solid fa-check text-success"></i>
            <h2 class="fw-semibold">Thank You for Registering</h2>
            <p class="text-secondary">Your account has been created</p>
            <div class="wrapper">
              <a href="<%= request.getContextPath() %>/" class="text-decoration-none">
                <button class="btn btn-outline-secondary mt-3 me-3">HOME</button>
              </a>
              <a href="<%= request.getContextPath() %>/login" class="text-decoration-none">
                <button class="btn mt-3" style=" background-color: #ED3D63; color: aliceblue;">LOGIN</button>
              </a>
            </div>
          </div>
        </div>
      </section>
    </main>

    <!-- Footer -->
    <%@ include file="components/footer.jsp" %>
  </body>
</html>
