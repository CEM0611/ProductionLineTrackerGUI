package com.github.CEM0611;

/**
 * This class was made to test future functionality of an embedded
 * video player within the GUI.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public class MoviePlayer extends Product implements MultimediaControl {
  private String resolution;
  private int refreshRate;
  private int responseTime;
  private MonitorType monitorType;
  private String code;

  MoviePlayer(String productName, String manufacturer, Screen aScreen, MonitorType monitorType) {
    super(productName, manufacturer);
    this.code = "VISUAL";
    this.resolution = aScreen.getResolution();
    this.refreshRate = aScreen.getRefreshRate();
    this.responseTime = aScreen.getResponseTime();
    this.monitorType = monitorType;
    this.code = ItemType.VI.getMediaType();
  }

  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n" +
        "Manufacturer: " + this.getManufacturer() + "\n" +
        "Type: " + this.code + "\n" +
        "Screen: " + "\n" +
        "Resolution: " + this.resolution + "\n" +
        "Refresh rate: " + this.refreshRate + "\n" +
        "Response time: " + this.responseTime + "\n" +
        "Monitor Type: " + this.monitorType;
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