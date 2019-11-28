package com.github.cem0611;

/**
 * This interface holds the methods used by the Screen Class.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}