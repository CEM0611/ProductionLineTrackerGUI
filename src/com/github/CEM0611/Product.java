package com.github.CEM0611;

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

  public Product() {
  }

  public Product(String name, String manufacturer) {
    this.id = 0;
    this.name = name;
    this.manufacturer = manufacturer;
  }

  public Product(String name, String manufacturer, ItemType type) {
    this.id = 0;
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public Product(String name, String manufacturer, String mediaType) {
    this.id = 0;
    this.name = name;
    this.manufacturer = manufacturer;
    this.mediaType = mediaType;
    setType(mediaType);
  }

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

  public void setManufacturer(String Manufacturer) {
    this.manufacturer = Manufacturer;
  }

  public ItemType getType() {
    return type;
  }

  /**
   * This setter for setting the ItemType enum of a product
   * is unique to the others as it takes a mediaType String parameter
   * and converts it through an if-else statement chain.
   */
  public void setType(String mediaType) {
    // If mediaType holds the same String value as "Audio"
    if (mediaType.equals("Audio")) {
      this.type = ItemType.AU;
    } else if (mediaType.equals("AudioMobile")) {
      this.type = ItemType.AM;
    } else if (mediaType.equals("Visual")) {
      this.type = ItemType.VI;
    } else if (mediaType.equals("VisualMobile")) {
      this.type = ItemType.VM;
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

  public void toString(String name, String manufacturer, String type) {
    System.out.println("Name: " + name + "\n" +
        "\n" +
        "Manufacturer: " + manufacturer + "\n" +
        "\n" +
        "Type: " + type);
  }
}
