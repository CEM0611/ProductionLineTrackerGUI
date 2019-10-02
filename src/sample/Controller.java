/**
 * This file contains the majority of the code used for database operation
 * and storage as well as general program interaction.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * This file contains the majority of the code used for database operation
 * and storage as well as general program interaction.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */
public class Controller {
  // setting global variables for use within methods
  private Connection conn;

  @FXML
  private Button testBut;

  @FXML
  private TextField productName;

  @FXML
  private TextField manufacturer;

  @FXML
  private ChoiceBox<String> itemType;

  @FXML
  private TableView<?> existingProductTable;

  @FXML
  private TableColumn<?, ?> manufacturerColumn;

  @FXML
  private TableColumn<?, ?> productsColumn;

  @FXML
  private TableColumn<?, ?> itemTypeColumn;

  @FXML
  private ComboBox<String> recQuantity;

  @FXML
  private Button recP;

  /**
   * initialize() method is used to preset the values for
   *  both the "Choose Quantity" combo-box in the
   *  Production tab and the "Item Type" choice-box in the Product Line tab.
   */
  @FXML
  public void initialize() {
    ObservableList<String> itemTypeOptions =
        FXCollections.observableArrayList(
            "Audio",
            "Visual",
            "AudioMobile",
            "VisualMobile"
        );
    itemType.setItems(itemTypeOptions);
    itemType.getSelectionModel().selectFirst();
    ObservableList<String> recQuantityOptions =
        FXCollections.observableArrayList(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
        );
    recQuantity.setItems(recQuantityOptions);
    recQuantity.setEditable(true);
    recQuantity.getSelectionModel().selectFirst();
  }

  /*
   * addProduct() method is used to collect data entered from
   * specified text fields and insert them into the
   * database previously connected to by using the initializeDB() method.
   */
  @FXML
  void addProduct(MouseEvent event) {
    try {
      initializeDB(); // Initializes database connection
      /* PreparedStatement stmt;
      stmt = conn.createStatement();*/
      String productNameText = productName.getText();
      String manufacturerText = manufacturer.getText();
      String selectedItem = itemType.getSelectionModel().getSelectedItem();
      String sq1 = "INSERT INTO PRODUCT (NAME,TYPE,MANUFACTURER) "
          + "VALUES ('" + manufacturerText + "', '"
              + productNameText + "', '" + selectedItem + "')";
      PreparedStatement preparedStatement1 = conn.prepareStatement(sq1);
      preparedStatement1.executeUpdate();
      preparedStatement1.close();
      // Statement stmt = conn.createStatement();
      // stmt.execute(String.format("SQL STATEMENT HERE WITH (%s string var pointers);", productName.getText(),etc.);
      // stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @FXML
  void recordProduct(MouseEvent event) {
    System.out.println("Sorry, this isn't implemented yet!");
  }

  /*
   * initializeDB() is used to initialize the connection
   *  to the database for interaction between the program and the database.
   */
  private void initializeDB() {
    // properties, Username and password needed to access database
    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./res/H2";
    try {
      // connect to database
      Class.forName(jdbcDriver);
      conn = DriverManager.getConnection(dbUrl);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
