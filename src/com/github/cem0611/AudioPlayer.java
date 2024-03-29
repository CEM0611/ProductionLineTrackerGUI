package com.github.cem0611;

/**
 * This Class was made to test future functionality of an audio player embedded
 * within this GUI program.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public class AudioPlayer extends Product implements MultimediaControl {
  private final String audioFormats;
  private final String playlistFormats;
  private final String code;

  /**
   * Constructor for the AudioPlayer class.
   *
   * @param productName     String
   * @param manufacturer    String
   * @param audioFormats    String
   * @param playlistFormats String
   */
  public AudioPlayer(String productName, String manufacturer,
                     String audioFormats, String playlistFormats) {
    super(productName, manufacturer);
    this.code = ItemType.AU.getMediaType();
    this.audioFormats = audioFormats;
    this.playlistFormats = playlistFormats;
  }

  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
        + "Manufacturer: " + this.getManufacturer() + "\n"
        + "Type: " + this.code + "\n"
        + "Supported Audio Formats: " + this.audioFormats + "\n"
        + "Supported Playlist Formats: " + this.playlistFormats;
  }

  public void play() {
    System.out.println("Playing");
  }

  public void stop() {
    System.out.println("Stopping");
  }

  public void next() {
    System.out.println("Next");
  }

  public void previous() {
    System.out.println("Previous");
  }
}