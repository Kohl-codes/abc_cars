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
        <div class="form-wrapper medium">
          <h2 class="form-header text-center">Post Car</h2>
          <!-- FORM -->
          <form:form action="postCarProcess" method="POST" enctype="multipart/form-data" modelAttribute="car">
            <label class="form-label">Make</label>
            <div>
              <form:errors path="make" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="make" cssErrorClass="form-control error-border" />

            <label class="form-label">Model</label>
            <div>
              <form:errors path="model" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="model" cssErrorClass="form-control error-border" />

            <label class="form-label">Year</label>
            <div>
              <form:errors path="year" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="year" cssErrorClass="form-control error-border" />

            <label class="form-label">Price</label>
            <div>
              <form:errors path="price" cssClass="error" />
            </div>
            <form:input class="form-control" type="number" path="price" cssErrorClass="form-control error-border" />

            <label class="form-label">Car Picture</label>
            <div>
              <span class="error">${fileError}</span>
            </div>
            <input class="form-control" type="file" name="imageFile" />

            <button class="btn form-button mt-3" style="background-color: #ED3D63; color: aliceblue;"  type="submit">Post Car</button>
          </form:form>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
  </body>
</html>
