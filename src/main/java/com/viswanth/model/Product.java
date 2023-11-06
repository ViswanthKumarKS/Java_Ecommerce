package com.viswanth.model;

public class Product {
  private int id;
  private String title;
  private double price;
  private String image;

  public Product() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Product(int id, String title, double price, String image) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.image = image;
  }
}
