package com.viswanth.DAO;

import DB.Database;
import com.viswanth.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

  private final Connection connection;

  private String LOGIN_Query = "SELECT  id,email,password FROM login WHERE email=? AND password=?";

  private String Insert_Query="INSERT INTO login(email,password)values(?,?)";


  public UserDao() {
    connection=Database.getConnection();
    System.out.println("hiii");
  }

  public User loginUser(String email, String password) {

    User user = null;

    try {
      PreparedStatement p1 = connection.prepareStatement(LOGIN_Query);
      p1.setString(1, email);
      p1.setString(2, password);
      ResultSet r1 = p1.executeQuery();
      if (r1.next()) {
        user = new User();
        user.setId(Integer.parseInt(r1.getString("id")));
        user.setEmail(r1.getString("email"));
        user.setPassword(r1.getString("password"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }


    return user;

  }

  public boolean NewUser(String email ,String password ) throws SQLException {

    PreparedStatement p2 = connection.prepareStatement(Insert_Query);
    System.out.println(p2);
    p2.setString(1, email);
    p2.setString(2, password);
    System.out.println(p2);
    p2.executeUpdate();
    System.out.println(p2);


    return true;
  }
}
