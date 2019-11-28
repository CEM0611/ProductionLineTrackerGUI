package com.github.cem0611;

/**
 * This class was made to test future functionality of implementing
 * further categorization and detailed logging of visual and visual mobile
 * products. This class involves the MonitorType enum and ScreenSpec interface
 * to extend the details of visual/visual mobile products.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public class Screen extends Product implements ScreenSpec, Item {
  private final String resolution;
  private final int refreshRate;
  private final int responseTime;

  /**
   * Constructor for Screen class.
   *
   * @param resolution   String
   * @param refreshRate  int
   * @param responseTime int
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  public String getResolution() {
    return this.resolution;
  }

  public int getRefreshRate() {
    return this.refreshRate;
  }

  public int getResponseTime() {
    return this.responseTime;
  }

  @Override
  public String toString() {
    return "Resolution: " + getResolution() + "\n"
        + "Refresh Rate: " + getRefreshRate() + "\n"
        + "Response Time: " + getResponseTime();
  }
}
