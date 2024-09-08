# ABC-Cars-Portal

A website application that offers a marketplace for buying and selling used
cars. It allows users to browse a wide selection of pre-owned vehicles and
place bids on cars they are interested in, providing them with the potential to
purchase a vehicle at a lower price.

## Project Overview

**There are 2 types of users in this Used Cars Sales portal. They are**

1.  Users
2.  Administrator

**Users should be able to perform following functions in the portal**

1.  Register in the Portal
2.  Login to the Portal
3.  Post a Car for Sale along with Picture upload
4.  Deactivate an Existing car sale
5.  Update their Profile after logging in.
6.  Book an appointment for test drive
7.  Post the bidding price

**Administrators should be able to perform the following functions in the
portal**

1.  Register in the Portal
2.  Login to the portal
3.  View List of Registered Users
4.  Mark a User as Administrator
5.  Activate / Deactivate a Car post
6.  Update their profile
7.  Approve or deny the users appointment based on the bidding
8.  Transact the sales if price is right

**Both Users & Administrator**

1.  Visit Home Page
2.  View Car Listing
3.  Search for a Car by Make, Model, Registration Year & Price Range
4.  About Us Page
5.  Contact Us Page

## Technologies Used & System Requirements

Backend : Java SE 11, MySQL 8, Spring Boot, Spring Security <br/>
Frontend : JSP (Jakarta Server Page), JavaScript, Bootstrap <br/>

## HOW TO RUN

1. **Import Existing Project into Visual Studio Code** <br/>
2. **Create MySQL database**

```bash
mysql> create database abc_cars
```

3. **Setup application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/abc_cars
spring.datasource.username=<YOUR_DB_USERNAME>
spring.datasource.password=<YOUR_DB_PASSWORD>
```

4. **Run Java Application and open [http://localhost:8080](http://localhost:8080)**

## Screenshot

<p>Home Page</p>
<img src="./images/home.png" alt="home_page" width="50%"/>
<p>Login</p>
<img src="./images/login.png" alt="login" width="50%"/>
<p>Profile page</p>
<img src="./images/profile.png" alt="profile" width="50%"/>
<p>Cars Page</p>
<img src="./images/cars.png" alt="cars" width="50%"/>
<p>Car Detail Page</p>
<img src="./images/car-detail.png" alt="car_detail" width="50%"/>
<p>Post Car</p>
<img src="./images/post-car.png" alt="post_car" width="50%"/>
<p>Bid Car</p>
<img src="./images/place-bid.png" alt="bid_car" width="50%"/>
<p>Test Drive</p>
<img src="./images/test-drive.png" alt="test_drive" width="50%"/>
<p>Appointment</p>
<img src="./images/appointment.png" alt="appointment" width="50%"/>
<p>My Posted Car</p>
<img src="./images/my-posted-car.png" alt="my_posted_car" width="50%"/>
<p>About Page</p>
<img src="./images/about.png" alt="about" width="50%"/>
<p>Contact Page</p>
<img src="./images/contact.png" alt="contact" width="50%"/>
<p>Admin Pages</p>
<img src="./images/admin.png" alt="admin" width="50%"/>
<img src="./images/admin2.png" alt="admin" width="50%"/>
