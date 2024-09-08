<%@ include file="../components/taglib.jsp" %> <%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/user.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="../components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container pt-5">
        <div class="d-flex">
          <!-- Sidebar -->
          <aside class="sidebar-user pe-md-3">
            <ul>
              <li>
                <a href="<%= request.getContextPath() %>/user"><i class="fa-solid fa-user"></i> Profile</a>
              </li>
              <li class="active-page">
                <a href="<%= request.getContextPath() %>/user/my-posted-car"><i class="fa-solid fa-car"></i> My Posted Car</a>
              </li>
              <li>
                <a href="<%= request.getContextPath() %>/user/test-drive"><i class="fa-regular fa-calendar-check"></i> Appointment</a>
              </li>
            </ul>
          </aside>

          <!-- Content -->
          <div class="content-wrapper">
            <h2 class="fw-bold mb-3">Posted Cars</h2>
            <!-- Table -->
            <c:if test="${!userCar.isEmpty()}">
              <div class="table-responsive-md">
                <table class="table table-striped">
                  <!-- Head -->
                  <thead>
                    <tr>
                      <th>Id Car</th>
                      <th>Make</th>
                      <th>Model</th>
                      <th>Year</th>
                      <th>Price</th>
                      <th>Status</th>
                      <th></th>
                    </tr>
                  </thead>
                  <!-- Body -->
                  <tbody>
                    <c:forEach items="${userCar}" var="car">
                      <tr>
                        <td>${car.idCar}</td>
                        <td>${car.make}</td>
                        <td>${car.model}</td>
                        <td>${car.year}</td>
                        <td>$${car.price}</td>
                        <c:if test="${car.status.equals('ACTIVE')}">
                          <td class="fw-semibold text-primary">${car.status}</td>
                        </c:if>
                        <c:if test="${car.status.equals('DEACTIVE')}">
                          <td class="fw-semibold text-danger">${car.status}</td>
                        </c:if>
                        <c:if test="${car.status.equals('SOLD')}">
                          <td class="fw-semibold text-success">${car.status}</td>
                        </c:if>
                        <c:if test="${car.status.equals('SOLD')}">
                          <td></td>
                        </c:if>
                        <c:if test="${!car.status.equals('SOLD')}">
                          <td>
                            <div class="dropdown">
                              <button class="btn dropdown-toggle" style="background-color: #0683d7;" type="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa-regular fa-pen-to-square" style="color: white;"></i></button>
                              <ul class="dropdown-menu dropdown-menu-light">
                                <li>
                                  <a class="dropdown-item" href="<%= request.getContextPath() %>/cars/${car.make}/${car.model}/${car.year}/${car.idCar}">Car Details</a>
                                </li>
                                <li>
                                  <a class="dropdown-item" href="<%= request.getContextPath() %>/user/edit-posted-car?id=${car.idCar}">Edit Details</a>
                                </li>
                                <li>
                                  <a class="dropdown-item" href="<%= request.getContextPath() %>/user/upload-car-picture?idCar=${car.idCar}">Edit Picture</a>
                                </li>
                                <c:if test="${car.status.equals('ACTIVE')}">
                                  <li>
                                    <a class="dropdown-item" href="<%= request.getContextPath() %>/user/deactivate/${car.idCar}">Deactivate Post</a>
                                  </li>
                                </c:if>
                                <c:if test="${car.status.equals('DEACTIVE')}">
                                  <li>
                                    <a class="dropdown-item" href="<%= request.getContextPath() %>/user/activate/${car.idCar}">Activate Post</a>
                                  </li>
                                </c:if>
                              </ul>
                            </div>
                          </td>
                        </c:if>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <a href="<%= request.getContextPath() %>/user/post-car">
                  <button class="btn" style="background-color: #ED3D63; color: aliceblue;">Sell Car</button>
                </a>
              </div>
            </c:if>
            <c:if test="${userCar.isEmpty()}">
              <p class="text-secondary">No Posted cars. Get Started</p>
              <a href="<%= request.getContextPath() %>/user/post-car">
                <button class="btn" style="background-color: #ED3D63; color: aliceblue;">Sell Car</button>
              </a>
            </c:if>
          </div>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
  </body>
</html>
