package com.viswanth.DAO;

import DB.Database;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.viswanth.model.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductDao {

  private static Connection connection;
  private static String PRODUCT_QUERY = "SELECT *FROM product";

  private static String CART_QUERY="INSERT INTO e_CART(userid,productid)values(?,?)";

  public ProductDao() {
    connection = Database.getConnection();
  }



  public static List<Product> getproducts() throws SQLException, FileNotFoundException {
    PreparedStatement p1 = connection.prepareStatement(PRODUCT_QUERY);
    ResultSet s1 = p1.executeQuery();
    List<Product> product = new ArrayList<>();
    while (s1.next()) {
      Product p2 = new Product();
//      FileInputStream imagestream=new FileInputStream("images/vivo.webp");
      p2.setId(Integer.parseInt(s1.getString("id")));
      p2.setTitle(s1.getString("title"));
      p2.setPrice(Integer.parseInt(s1.getString("price")));
      p2.setImage(s1.getString("image"));
      product.add(p2);
//      for(Product product1:product){
//        System.out.println(product1.getId());
//        System.out.println(product1.getTitle());
//        System.out.println(product1.getPrice());
//        System.out.println(product1.getImage());
//      }
    }
    return product;
  }


  public void addproduct(int userId, int prodctId) throws SQLException {
    PreparedStatement prepare = connection.prepareStatement(CART_QUERY);
    prepare.setInt(1,userId);
    prepare.setString(2, String.valueOf(prodctId));
    prepare.executeUpdate();


  }
}




