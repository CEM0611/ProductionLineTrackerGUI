package com.github.cem0611;

/**
 * This enum is used for connecting ItemType codes and their full names to make easier
 * implementation with.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public enum ItemType {
  AU("Audio"), VI("Visual"), AM("AudioMobile"), VM("VisualMobile");
  private final String mediaType;

  ItemType(String mediaType) {
    this.mediaType = mediaType;
  }

  public String getMediaType() {
    return mediaType;
  }
}