package com.github.CEM0611;

/**
 * This enum performs a function very similar to the ItemType enum and
 * rightly so. This enum sets the type of screen/monitor used for visual
 * and visual mobile type products.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public enum MonitorType {
  LCD("LCD"), LED("LED");
  private String code;

  MonitorType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}