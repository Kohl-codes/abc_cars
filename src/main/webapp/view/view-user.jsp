<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/view-user.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container">
        <div class="d-flex flex-column justify-content-center mt-5">
          <div class="view-user d-flex pb-4 mb-3">
            <div class="user-image me-4">
              <c:if test="${profile.profilePicture == null}">
                <img src="/images/user/user-default.png" alt="${profile.firstName}" />
              </c:if>
              <c:if test="${profile.profilePicture != null}">
                <img src="data:${profile.profilePicture.fileType};base64,${profile.profilePicture.image}" alt="${profile.firstName}" />
              </c:if>
            </div>
            <div class="user-details pt-3">
              <h5 class="fw-semibold">${profile.firstName} ${profile.lastName}</h5>
              <p class="text-secondary m-0">${profile.phoneNumber}</p>
              <p class="text-secondary m-0">${profile.address}</p>
            </div>
          </div>
          <div class="car-post row">
            <h3 class="fw-bold mb-2">Car Sales History</h3>
            <c:forEach items="${listCar}" var="car">
              <div class="col-12 col-md-6 col-lg-4 mb-3">
                <div class="card">
                  <img class="card-img-top" src="data:${car.carPicture.fileType};base64,${car.carPicture.image}" alt="${car.make}" />
                  <div class="card-body">
                    <p class="car-details fw-bold">${car.make} ${car.model} ${car.year}</p>
                    <p class="car-price">$${car.price}</p>
                    <a href="<%= request.getContextPath() %>/cars/${car.make}/${car.model}/${car.year}/${car.idCar}">
                      <button class="btn " style=" background-color: #ED3D63; color: aliceblue;">Car Details</button>
                    </a>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="components/footer.jsp" %>
  </body>
</html>
