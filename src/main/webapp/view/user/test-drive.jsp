<%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/form.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="../components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container d-flex justify-content-center">
        <div class="form-wrapper small">
          <h2 class="form-header text-center">Test Drive</h2>
          <p class="fw-bold fs-5 m-0 ms-1">${car.make} ${car.model} ${car.year}</p>
          <div class="car-thumbnail mb-3">
            <img class="img-thumbnail" src="data:${car.carPicture.fileType};base64,${car.carPicture.image}" alt="${car.make}" />
          </div>
          <!-- FORM -->
          <form:form action="testDriveProcess" method="POST" modelAttribute="testDrive">
            <label class="fs-6 form-label">Date</label>
            <form:input class="form-control" type="date" path="date" id="inputDate" />

            <form:hidden path="user" value="${user.idUser}" />
            <form:hidden path="car" value="${car.idCar}" />

            <button class="btn form-button" style="background-color: #ED3D63; color: aliceblue;" type="submit">Test Drive</button>
          </form:form>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
    <script src="/js/test-drive.js"></script>
  </body>
</html>
