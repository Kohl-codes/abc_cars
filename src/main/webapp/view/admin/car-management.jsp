<%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/admin.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="../components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container pt-5">
        <div class="d-flex">
          <!-- Sidebar -->
          <aside class="sidebar-admin pe-md-3">
            <ul>
              <li>
                <a href="<%= request.getContextPath() %>/admin"><i class="fa-solid fa-gauge-high"></i> Dashboard</a>
              </li>
              <li class="active-page">
                <a href="<%= request.getContextPath() %>/admin/car-management"><i class="fa-solid fa-car"></i> Car Management</a>
              </li>
            </ul>
          </aside>

          <!-- Content -->
          <div class="content-wrapper">
            <!-- List Car -->
            <h2 class="fw-bold mb-3">Car List</h2>
            <div class="table-responsive-md">
              <table class="table table-striped">
                <!-- Head -->
                <thead>
                  <tr>
                    <th>Car Id</th>
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
                  <c:forEach items="${listCar}" var="car">
                    <tr>
                      <td>${car.idCar}</td>
                      <td>${car.make}</td>
                      <td>${car.model}</td>
                      <td>${car.year}</td>
                      <td>${car.price}</td>
                      <c:if test="${car.status.equals('ACTIVE')}">
                        <td class="fw-semibold text-primary">${car.status}</td>
                      </c:if>
                      <c:if test="${car.status.equals('DEACTIVE')}">
                        <td class="fw-semibold text-danger">${car.status}</td>
                      </c:if>
                      <c:if test="${car.status.equals('SOLD')}">
                        <td class="fw-semibold text-success">${car.status}</td>
                      </c:if>
                      <c:if test="${!car.status.equals('SOLD')}">
                        <td>
                          <div class="dropdown">
                            <button class="btn dropdown-toggle" type="button"  style="background-color: #0683d7;"data-bs-toggle="dropdown" aria-expanded="false"><i class="fa-regular fa-pen-to-square" style="color: white;"></i></button>
                            <ul class="dropdown-menu dropdown-menu-light">
                              <c:if test="${car.status.equals('ACTIVE')}">
                                <li>
                                  <a class="dropdown-item" href="<%= request.getContextPath() %>/admin/deactivate/${car.idCar}">Deactivate Car Post</a>
                                </li>
                              </c:if>
                              <c:if test="${car.status.equals('DEACTIVE')}">
                                <li>
                                  <a class="dropdown-item" href="<%= request.getContextPath() %>/admin/activate/${car.idCar}">Activate Car Post</a>
                                </li>
                              </c:if>
                            </ul>
                          </div>
                        </td>
                      </c:if>
                      <c:if test="${car.status.equals('SOLD')}">
                        <td></td>
                      </c:if>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>

            <!-- Car Bid -->
            <h2 class="fw-bold mb-3 mt-5">Car Bid</h2>
            <div class="table-responsive-md">
              <table class="table table-striped">
                <!-- Head -->
                <thead>
                  <tr>
                    <th>Car Id</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Bid Price</th>
                    <th>Status</th>
                    <th></th>
                  </tr>
                </thead>
                <!-- Body -->
                <tbody>
                  <c:forEach items="${listCarBid}" var="bid">
                    <tr>
                      <td>${bid.car.idCar}</td>
                      <td>${bid.car.make}</td>
                      <td>${bid.car.model}</td>
                      <td>${bid.car.year}</td>
                      <td>${bid.bidPrice}</td>
                      <c:if test="${bid.status.equals('ONGOING')}">
                        <td class="fw-semibold text-primary">${bid.status}</td>
                      </c:if>
                      <c:if test="${bid.status.equals('APPROVED')}">
                        <td class="fw-semibold text-success">${bid.status}</td>
                      </c:if>
                      <c:if test="${bid.status.equals('DENIED')}">
                        <td class="fw-semibold text-danger">${bid.status}</td>
                      </c:if>
                      <td>
                        <c:if test="${bid.status.equals('ONGOING')}">
                          <div class="dropdown">
                            <button class="btn btn-warning dropdown-toggle" type="button"  style="background-color: #0683d7;" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa-regular fa-pen-to-square" style="color: white"></i></button>
                            <ul class="dropdown-menu dropdown-menu-light">
                              <li>
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/admin/approve-bid/${bid.idBid}">Approve Bid</a>
                              </li>
                              <li>
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/admin/deny-bid/${bid.idBid}">Deny Bid</a>
                              </li>
                            </ul>
                          </div>
                        </c:if>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- List Admin -->
          </div>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
  </body>
</html>
