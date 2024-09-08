<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/form.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container d-flex justify-content-center">
        <div class="form-wrapper medium">
          <h2 class="form-header text-center">Register</h2>
          <!-- FORM -->
          <form:form action="profileProcess" method="POST" modelAttribute="profile">
            <label class="form-label fs-6">First name</label>
            <div>
              <form:errors path="firstName" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="firstName" cssErrorClass="form-control error-border" />

            <label class="form-label fs-6">Last name</label>
            <div>
              <form:errors path="lastName" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="lastName" cssErrorClass="form-control error-border" />

            <label class="form-label fs-6">Phone number</label>
            <div>
              <form:errors path="phoneNumber" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="phoneNumber" cssErrorClass="form-control error-border" />

            <label class="form-label fs-6">Address</label>
            <div>
              <form:errors path="address" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="address" cssErrorClass="form-control error-border" />

            <label class="form-label fs-6">About Me</label>
            <form:input class="form-control" type="text" path="about" />

            <button class="btn form-button mt-3" style=" background-color: #ED3D63; color: aliceblue;" type="submit">Register</button>
          </form:form>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="components/footer.jsp" %>
  </body>
</html>
