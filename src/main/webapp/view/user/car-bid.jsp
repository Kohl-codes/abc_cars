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
          <h2 class="form-header">Place Bid</h2>
          <c:if test="${highestBidding == 0}">
            <p class="text-secondary fs-5 m-0">STARTING PRICE:</p>
            <p class="fs-5 m-0">$${car.price}</p>
          </c:if>

          <c:if test="${highestBidding != 0}">
            <p class="text-secondary fs-5 m-0 text-uppercase">Highest Bid:</p>
            <p class="fs-5 m-0">$${highestBidding}</p>
          </c:if>
          <!-- FORM -->
          <p class="error">${message}</p>
          <form:form action="postCarBidding" method="POST" modelAttribute="carBidding">
            <form:hidden path="user" value="${user.idUser}" />

            <form:hidden path="car" value="${car.idCar}" />

            <input type="hidden" name="highestBidding" value="${highestBidding}" />

            <label class="fs-6 form-label">Bid Price</label>
            <form:input class="form-control" type="number" path="bidPrice" cssErrorClass="error-border" />
            <form:errors path="bidPrice" cssClass="error" />

            <button class="btn form-button" style="background-color: #ED3D63; color: aliceblue;" type="submit">Place Bid</button>
          </form:form>
        </div>
      </div>
    </main>

    <!-- Footer -->
    <%@ include file="../components/footer.jsp" %>
  </body>
</html>
