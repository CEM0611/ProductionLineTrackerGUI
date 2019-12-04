package com.github.cem0611;

/**
 * Products in this class are assigned an ID, ItemType,
 * manufacturer, name, and mediaType.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public class Product implements Item {
  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;
  private String mediaType;

  Product() {
  }

  /**
   * Constructor for Product class.
   *
   * @param name         String
   * @param manufacturer String
   */
  Product(String name, String manufacturer) {
    this.id = 0;
    this.name = name;
    this.manufacturer = manufacturer;
  }

  /**
   * Constructor for Product class.
   *
   * @param name         String
   * @param manufacturer String
   * @param type         ItemType
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.id = 0;
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * Constructor for Product class.
   *
   * @param name         String
   * @param manufacturer String
   * @param mediaType    String
   */
  public Product(String name, String manufacturer, String mediaType) {
    this.id = 0;
    this.name = name;
    this.manufacturer = manufacturer;
    this.mediaType = mediaType;
    setType(mediaType);
  }

  /**
   * Constructor for Product Class.
   *
   * @param id           int
   * @param name         String
   * @param manufacturer String
   * @param type         ItemType
   */
  public Product(int id, String name, String manufacturer, ItemType type) {
    this.id = id;
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  ItemType getType() {
    return type;
  }

  /**
   * This setter for setting the ItemType enum of a product
   * is unique to the others as it takes a mediaType String parameter
   * and converts it through an if-else statement chain.
   */
  private void setType(String mediaType) {
    // If mediaType holds the same String value as "Audio"
    switch (mediaType) {
      case "Audio":
        this.type = ItemType.AU;
        break;
      case "AudioMobile":
        this.type = ItemType.AM;
        break;
      case "Visual":
        this.type = ItemType.VI;
        break;
      case "VisualMobile":
        this.type = ItemType.VM;
        break;
      default:
        System.out.println("Something went wrong with the enum!");
    }
  }

  public String getMediaType() {
    return mediaType;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public Product(String name) {
    this.name = name;
  }

  /**
   * Overridden toString() method for printing out Product class.
   *
   * @param name         String
   * @param manufacturer String
   * @param type         String
   */
  public void toString(String name, String manufacturer, String type) {
    System.out.println("Name: " + name + "\n"
        + "\n"
        + "Manufacturer: " + manufacturer + "\n"
        + "\n"
        + "Type: " + type);
  }
}
