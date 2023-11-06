package com.viswanth.Controller;

import DB.Database;
import com.viswanth.DAO.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterController extends HttpServlet {

  public final UserDao userDao;
  public RegisterController() {
    userDao = new UserDao();
    Database.getConnection();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String email= req.getParameter("email");
    String password = req.getParameter("password");

    try {
      boolean LoggedInUser = this.userDao.NewUser(email, password);
      if (LoggedInUser != false) {

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
      }

    } catch (SQLException var8) {
      throw new RuntimeException(var8);
    }






  }
}
