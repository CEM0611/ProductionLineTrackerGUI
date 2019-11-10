package com.github.CEM0611;

/**
 * This interface holds the methods used by the movie player class
 * and the audio player class.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

public interface MultimediaControl {
  void play();

  void stop();

  void next();

  void previous();
}