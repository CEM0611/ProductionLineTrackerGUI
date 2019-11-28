/*
  This class was a temporary experiment which had been
  conducted successfully in order to test the functionality
  of the Product class with the database.
  Florida Gulf Coast University
  COP 3003 Object Oriented Programming Course

  @author Cristian Mendoza
 */
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
