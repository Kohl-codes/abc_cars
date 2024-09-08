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
              <li>
                <a href="<%= request.getContextPath() %>/user/my-posted-car"><i class="fa-solid fa-car"></i> My Posted Car</a>
              </li>
              <li class="active-page">
                <a href="<%= request.getContextPath() %>/user/test-drive"><i class="fa-regular fa-calendar-check"></i> Appointment</a>
              </li>
            </ul>
          </aside>

          <!-- Content -->
          <div class="content-wrapper">
            <h2 class="fw-bold mb-3">List Test Drive</h2>
            <!-- Table -->
            <c:if test="${!listTestDrive.isEmpty()}">
              <div class="table-responsive-md">
                <table class="table table-striped">
                  <!-- Head -->
                  <thead>
                    <tr>
                      <th>Id Car</th>
                      <th>Make</th>
                      <th>Model</th>
                      <th>Year</th>
                      <th>Client</th>
                      <th>Date</th>
                      <th></th>
                    </tr>
                  </thead>
                  <!-- Body -->
                  <tbody>
                    <c:forEach items="${listTestDrive}" var="test">
                      <tr>
                        <td>${test.car.idCar}</td>
                        <td>${test.car.make}</td>
                        <td>${test.car.model}</td>
                        <td>${test.car.year}</td>
                        <td>${test.user.profile.firstName}</td>
                        <td>${test.date}</td>
                        <td>
                          <div class="dropdown">
                            <button class="btn  dropdown-toggle" style="background-color: #0683d7;" type="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa-regular fa-pen-to-square" style="color: white;"></i></button>
                            <ul class="dropdown-menu dropdown-menu-light">
                              <li>
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/cars/${test.car.make}/${test.car.model}/${test.car.year}/${test.car.idCar}">Car Details</a>
                              </li>
                            </ul>
                          </div>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </c:if>

            <c:if test="${listTestDrive.isEmpty()}">
              <p class="text-secondary">You have not any test drive request</p>
            </c:if>
          </div>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
  </body>
</html>
