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
          <h2 class="form-header text-center">Upload Picture</h2>
          <!-- FORM -->
          <form action="uploadCarPicture" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <label class="fs-6 form-label">File</label>
            <input class="form-control" type="file" name="imageFile" />
            <p class="text-secondary">Image support : .jpg .jpeg .png</p>
            <p class="error">${message}</p>

            <button class="btn form-button mt-3" style="background-color: #ED3D63; color: aliceblue;" type="submit">Upload</button>
          </form>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
  </body>
</html>
