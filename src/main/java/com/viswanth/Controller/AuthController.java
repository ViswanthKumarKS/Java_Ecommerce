package com.viswanth.Controller;

import DB.Database;
import com.viswanth.DAO.ProductDao;
import com.viswanth.DAO.UserDao;
import com.viswanth.model.Product;
import com.viswanth.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AuthController extends HttpServlet {
  public final UserDao userDao;

  private final ProductDao productDao;

  public AuthController() {
    userDao = new UserDao();
    productDao=new ProductDao();
    Database.getConnection();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    System.out.println(email);
    System.out.println(password);
    User loginUser = userDao.loginUser(email, password);
    if (loginUser != null) {
      HttpSession httpSession = req.getSession();
      httpSession.setAttribute("id", loginUser.getId());
      RequestDispatcher request = req.getRequestDispatcher("home.jsp");
      List<Product> products= null;
      try {
        products = productDao.getproducts();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      req.setAttribute("products",products);
      request.forward(req, resp);
      //System.out.println("heme");
    } else {
      req.setAttribute("error", true);
      RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
      dispatcher.forward(req, resp);
    }

  }
}
