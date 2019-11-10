package com.github.CEM0611;
/**
 * This interface acts as a guide into which methods are implemented by whatever
 * class chooses to implement them.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public interface Item {
  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String Manufacturer);

  String getManufacturer();
}
