<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/cars.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container pt-5">
        <div class="d-flex">
          <!-- Sidebar -->
          <aside class="sidebar-car me-sm-4 pt-3">
            <ul class="fw-semibold">
              <li class="ms-1">
                <a href="<%= request.getContextPath() %>/cars"><i class="fa-solid fa-car"></i> Car List</a>
              </li>
              <li>
                <a href="<%= request.getContextPath() %>/user/post-car">
                  <button class="btn" style="background-color: #ED3D63; color: aliceblue;">Post a car</button>
                </a>
              </li>
              <li>
                <p class="ms-1"><i class="fa-solid fa-dollar-sign"></i> Price Range</p>
                <form action="<%= request.getContextPath() %>/cars">
                  <input class="form-control mb-3 ps-4 pe-0" type="number" name="low" required placeholder="Minimum price" />
                  <input class="form-control mb-3 ps-4 pe-0" type="number" name="high" required placeholder="Maximum price" />
                  <button type="submit" class="btn" style="background-color: #223ccf; color: aliceblue;">Search</button>
                </form>
              </li>
            </ul>
          </aside>

          <!-- Car List -->
          <div class="car-list">
            <!-- Search -->
            <form action="<%= request.getContextPath() %>/cars" id="searchForm" class="d-flex">
              <input class="form-control" type="text" name="keyword" required placeholder="Search by Make, Model, or Year" />
              <button type="submit" class="btn btn-light">
                <i class="fa-solid fa-magnifying-glass"></i>
              </button>
            </form>
            <!-- List -->
            <div class="mt-4 row">
              <c:if test="${!listCar.isEmpty()}">
                <c:forEach items="${listCar}" var="car">
                  <c:if test="${car.status.equals('ACTIVE')}">
                    <div class="col-12 col-md-6 col-md-4 col-lg-3 mb-3">
                      <div class="card">
                        <img class="card-img-top" src="data:${car.carPicture.fileType};base64,${car.carPicture.image}" alt="${car.make}" />
                        <div class="card-body">
                          <p class="car-details fw-bold">${car.make} ${car.model} ${car.year}</p>
                          <p class="car-price">$${car.price}</p>
                          <a href="<%= request.getContextPath() %>/cars/${car.make}/${car.model}/${car.year}/${car.idCar}">
                            <button class="btn" style="background-color: #223ccf; color: aliceblue;">Car Details</button>
                          </a>
                        </div>
                      </div>
                    </div>
                  </c:if>
                </c:forEach>
              </c:if>
              <c:if test="${listCar.isEmpty()}">
                <h4 class="fw-bold text-secondary text-center">Car not found</h4>
              </c:if>
            </div>
          </div>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="components/footer.jsp" %>
  </body>
</html>
