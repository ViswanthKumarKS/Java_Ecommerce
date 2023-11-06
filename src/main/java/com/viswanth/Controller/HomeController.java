package com.viswanth.Controller;

import com.viswanth.DAO.ProductDao;
import com.viswanth.DAO.UserDao;
import com.viswanth.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class HomeController extends HttpServlet {

  private ProductDao productDao;

  private UserDao userDao;

  public HomeController() {
    productDao=new ProductDao();
    userDao=new UserDao();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String productid = req.getParameter("id");
    HttpSession httpSession = req.getSession();
    int loggedIn = (int) httpSession.getAttribute("productid");
    if (productid != null) {

    }
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher d1=req.getRequestDispatcher("home.jsp");
    int userid=Integer.parseInt(req.getSession().getAttribute("id").toString());
    try {
      List<Product> product=productDao.getproducts();
      req.setAttribute("products",product);
      d1.forward(req,resp);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
