package com.github.CEM0611;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Production records are made with this class and can
 * take parameters directly from an existing product
 * or take parameters from entries within the database
 * table called "PRODUCTIONRECORD".
 * Both ways have been tweaked to be compatible with being inserted
 * and extracted from the database.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public class ProductionRecord extends Product {
  private int productNum;
  private String productId;
  private String serialNum;
  private LocalDate date;
  private String name;

  /**
   * Take newly added product and make a new production record from recording its production.
   */
  public ProductionRecord(Product product, int count) {
    this.productNum = 0;
    this.name = product.getName();
    this.serialNum = product.getManufacturer().substring(0, 2).toUpperCase() + product.getType().toString() + String.format("%05d", count);
    Date dateUnconverted = new Date();
    this.date = dateUnconverted.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

  /**
   * Take existing product and make a new production record from recording its production.
   */
  public ProductionRecord(int productNum, String name, String serialNum, LocalDate date) {
    this.productNum = productNum;
    this.serialNum = serialNum;
    this.date = date;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Prod. Num: " + this.productNum + " Product ID: " + this.name + " Serial Num: " +
        this.serialNum + " Date: " + this.date;
  }

  public void setProductionNum(int productNum) {
    this.productNum = productNum;
  }

  public void setProductID(String productId) {
    this.productId = productId;
  }

  public void setSerialNum(String serialNum) {
    this.serialNum = serialNum;
  }

  public void setProdDate(LocalDate date) {
    this.date = date;
  }

  public int getProductionNum() {
    return this.productNum;
  }

  public String getProductID() {
    return this.productId;
  }

  public String getSerialNum() {
    return this.serialNum;
  }

  public LocalDate getProdDate() {
    return this.date;
  }


}