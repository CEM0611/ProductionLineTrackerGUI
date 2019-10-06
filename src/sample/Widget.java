/*
package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class Widget extends Product {
  private Connection conn;

  public Widget(int id, String name, String manufacturer, ItemType type) {
    super(id, name, manufacturer, type);
  }

  private void initializeDB() {
    // properties, Username and password needed to access database
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/H2";
    try {
      // connect to database
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}*/
