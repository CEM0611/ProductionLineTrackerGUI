package com.github.cem0611;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This current project is the alpha version of the GUI Program
 * made for recording and tracking a production line of
 * various products of various type of various manufacturers.
 * This java file in particular handles the starting
 * properties and parameters of the program.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */
public class Main extends Application {
  // Starting method that collects resources from the GUI.fxml
  // file first then loads window properties and execution
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
    primaryStage.setTitle("Production Line Tracker GUI");
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.getScene().getStylesheets().add(getClass().getResource(
        "Stylesheet.css").toExternalForm());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}