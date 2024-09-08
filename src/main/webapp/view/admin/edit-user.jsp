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
          <h2 class="form-header text-center">Edit Profile</h2>
          <!-- FORM -->
          <form:form action="editProfileProcess" method="POST" modelAttribute="profile">
            <form:hidden path="idProfile" />

            <label class="form-label">First name</label>
            <div>
              <form:errors path="firstName" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="firstName" cssErrorClass="form-control error-border" />

            <label class="form-label">Last name</label>
            <div>
              <form:errors path="lastName" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="lastName" cssErrorClass="form-control error-border" />

            <label class="form-label">Phone number</label>
            <div>
              <form:errors path="phoneNumber" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="phoneNumber" cssErrorClass="form-control error-border" />

            <label class="form-label">Address</label>
            <div>
              <form:errors path="address" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="address" cssErrorClass="form-control error-border" />

            <label class="form-label">About Me</label>
            <form:input class="form-control" type="text" path="about" />

            <button class="btn form-button mt-3" style=" background-color: #ED3D63; color: aliceblue;" type="submit">Save Edit</button>
          </form:form>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
  </body>
</html>
