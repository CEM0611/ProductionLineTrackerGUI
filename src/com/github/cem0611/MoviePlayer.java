package com.github.cem0611;

/**
 * This class was made to test future functionality of an embedded
 * video player within the GUI.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public class MoviePlayer extends Product implements MultimediaControl {
  private final String resolution;
  private final int refreshRate;
  private final int responseTime;
  private final MonitorType monitorType;
  private String code;

  MoviePlayer(String productName, String manufacturer, Screen screen, MonitorType monitorType) {
    super(productName, manufacturer);
    this.code = "VISUAL";
    this.resolution = screen.getResolution();
    this.refreshRate = screen.getRefreshRate();
    this.responseTime = screen.getResponseTime();
    this.monitorType = monitorType;
    this.code = ItemType.VI.getMediaType();
  }

  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
        + "Manufacturer: " + this.getManufacturer() + "\n"
        + "Type: " + this.code + "\n"
        + "Screen: " + "\n"
        + "Resolution: " + this.resolution + "\n"
        + "Refresh rate: " + this.refreshRate + "\n"
        + "Response time: " + this.responseTime + "\n"
        + "Monitor Type: " + this.monitorType;
  }

  public void play() {
    System.out.println("Playing movie");
  }

  public void stop() {
    System.out.println("Stopping movie");
  }

  public void next() {
    System.out.println("Next movie");
  }

  public void previous() {
    System.out.println("Previous movie");
  }
}