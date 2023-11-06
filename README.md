# Java_JDBC_ECommerce_Servlet
This java console application for E-Commerce has the following sections:
 
👤 Login - Existing User and Admin
👥 Register - New User
🏠 Home - User
    👀 View Categories 
        🛍️ View products based on category.
        ⏬ Add products to cart.
    👀 View Products 
        ⏬ Add products to cart.
    🛒 View Cart 
        ✔️ Check out products from cart.
    ➡️ View Order 
        📦 Check for placed orders.
    📤 Logout
 
 
-> '💻-Java' for coding -> '🗃️-Database' for storing and retrieving data.
Tables used for each sections:
 
1. "🗃️-User table with Admin and User"  for storing user data.
2. "🗃️-Product table" for storing Products.
3. "🗃️-Cart table" for storing user cart details.
4. "🗃️-Order table" for storing user order details.
 
 
Steps used and challenges faced to build this application:-
 
Steps:
------
👉 Used MVC (Model, View, Controller) architecture for developing the console application.
👉 Added the required Models, Views and Controller along with Interface implementation to achieve abstraction.
👉 Added user-defined exceptions to catch anf handle the exceptions.
👉 Used encapsulation to hide data and used getter and setter for getting and setting the data for the models.
👉 Used "ArrayList" to store and manipulate data according to the user preferrences.
👉 Used "JDBC" and "Connection Path" to connect and access the database for storing and retriving the data.
👉 Used Data Access Object (dao) for accessing Database using queries.
👉 Stored the Connection path, Scanner class other sensitive information in a separate Utility folder.
👉 Used Singleton pattern to avoid creating objects.
👉 Used "Date" class for handling date for orders.
👉 Handled exceptions for invalid choices.
Challenges:
-----------
🔴 Faced error on calling httpServlet dopost and doget method.
🔴 Faced isses to store the data into database.

