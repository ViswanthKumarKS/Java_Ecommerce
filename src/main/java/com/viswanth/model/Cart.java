package com.viswanth.model;

public class Cart {

  private int id;

  private int Userid;

  private int count;

  private Product product;

  public Cart(int id, int userid, int count, Product product) {
    this.id = id;
    Userid = userid;
    this.count = count;
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserid() {
    return Userid;
  }

  public void setUserid(int userid) {
    Userid = userid;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
