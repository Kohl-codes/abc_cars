<nav class="navbar navbar-expand-lg sticky-top p-0">
  <div class="container">
    <a class="navbar-brand fw-bold fs-5" href="<%= request.getContextPath() %>/"><em
        style="color: #ED3D63; font-weight: 1500;">ABC.</em><em style="color: #161B7F; font-weight: 700;">cars</em></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarNav">
      <ul class="navbar-nav ms-auto me-0 me-lg-auto fw-semibold ">
        <li class="nav-item me-0 me-lg-3">
          <a class="nav-link" href="<%= request.getContextPath() %>/">HOME</a>
        </li>
        <li class="nav-item me-0 me-lg-3">
          <a class="nav-link" href="<%= request.getContextPath() %>/cars">CARS</a>
        </li>
        <security:authorize access="hasRole('USER')">
          <li class="nav-item me-0 me-lg-3">
            <a class="nav-link" href="<%= request.getContextPath() %>/user/post-car">SELL CAR</a>
          </li>
        </security:authorize>
        <li class="nav-item me-0 me-lg-3">
          <a class="nav-link" href="<%= request.getContextPath() %>/about-us">ABOUT US</a>
        </li>
        <li class="nav-item me-0 me-lg-3">
          <a class="nav-link" href="<%= request.getContextPath() %>/contact-us">CONTACT</a>
        </li>
      </ul>

      <!-- Login & Logout -->
      <security:authorize access="!isAuthenticated()">

        <div class="nav-button d-flex flex-column flex-lg-row">
          <a href="<%= request.getContextPath() %>/login"
            class="btn btn-outline-secondary me-0 me-lg-3 mb-3 mb-lg-0">LOGIN</a>
          <a href="<%= request.getContextPath() %>/register" class="btn mb-3 mb-lg-0"
            style="background-color: #ED3D63; color: aliceblue;">Register</a>
        </div>



      </security:authorize>

      <!-- User Menu -->
      <security:authorize access="isAuthenticated()">
        <ul class="navbar-nav fw-semibold">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" role="button"
              data-bs-toggle="dropdown" aria-expanded="false">
              <div class="nav-account me-2">

                <!-- Profile Picture -->

                <c:if test="${profileLog.profilePicture == null}">
                  <img src="/images/user/user-default.png" alt="Profile Picture" />
                </c:if>
                <c:if test="${profileLog.profilePicture != null}">
                  <img src="data:${profileLog.profilePicture.fileType};base64,${profileLog.profilePicture.image}"
                    alt="Profile Picture" />
                </c:if>
              </div>
              ${profileLog.firstName}
            </a>
            <ul class="dropdown-menu">
              <security:authorize access="hasRole('USER')">
                <li>
                  <a class="dropdown-item" href="<%= request.getContextPath() %>/user"><i class="fa-solid fa-user"></i>
                    Profile</a>
                </li>
                <li>
                  <a class="dropdown-item" href="<%= request.getContextPath() %>/user/my-posted-car"><i
                      class="fa-solid fa-car"></i> My Posted Car</a>
                </li>
                <li>
                  <a class="dropdown-item" href="<%= request.getContextPath() %>/user/test-drive"><i
                      class="fa-regular fa-calendar-check"></i> Appointment</a>
                </li>
              </security:authorize>

              <!-- Admin Dashboard -->
              <security:authorize access="hasRole('ADMIN')">
                <li>
                  <a class="dropdown-item" href="<%= request.getContextPath() %>/admin/dashboard"><i
                      class="fa-solid fa-gauge-high"></i> Dashboard </a>
                </li>
              </security:authorize>

              <li class="dropdown-divider"></li>
              <li>
                <a class="dropdown-item" href="<%= request.getContextPath() %>/logout">
                  <button class="nav-logout btn" style="background-color: #ED3D63; color: aliceblue;">LOGOUT</button>
                </a>
              </li>
            </ul>
          </li>
        </ul>


      </security:authorize>
    </div>
  </div>
</nav>