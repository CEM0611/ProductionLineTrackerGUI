/**
 * This file contains the majority of the code used for database operation
 * and storage as well as general program interaction.
 * Florida Gulf Coast University
 * COP 3003 Object Oriented Programming Course
 *
 * @author Cristian Mendoza
 */

package com.github.CEM0611;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
  private int accumulatedCount = 0;
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
  private TableView<Product> existingProductTable;

  @FXML
  private TableColumn<?, ?> manufacturerColumn;

  @FXML
  private TableColumn<?, ?> productsColumn;

  @FXML
  private TableColumn<?, ?> itemTypeColumn;

  @FXML
  private ListView<String> chooseProductList;

  @FXML
  private ListView<ProductionRecord> logListView;

  @FXML
  private ComboBox<String> recQuantity;

  @FXML
  private Button recP;

  /**
   * initialize() method is used to preset the values for
   * both the "Choose Quantity" combo-box in the
   * Production tab and the "Item Type" choice-box in the Product Line tab.
   * It also refreshes the TableView on the Product Line tab and the ListViews
   * in the Record Production and Production Log tabs from the database.
   */
  @FXML
  public void initialize() {
    initializeDB(); // Initializes database connection
    ObservableList<String> itemTypeOptions =
        FXCollections.observableArrayList(
            ItemType.AU.getMediaType(),
            ItemType.VI.getMediaType(),
            ItemType.AM.getMediaType(),
            ItemType.VM.getMediaType()
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

    productsColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    itemTypeColumn.setCellValueFactory(new PropertyValueFactory<>("mediaType"));

    try {
      String sq1 = "SELECT * FROM PRODUCT";
      Statement statement1 = conn.createStatement();
      ResultSet rs = statement1.executeQuery(sq1);
      ObservableList<String> recordedProduct = FXCollections.observableArrayList();
      while (rs.next()) {
        String productName = rs.getString("NAME");
        recordedProduct.add(productName);
      }
      chooseProductList.setItems(recordedProduct);
      statement1.close();

      String sq2 = "SELECT * FROM PRODUCT";
      Statement statement2 = conn.createStatement();
      ResultSet rs2 = statement2.executeQuery(sq2);
      ObservableList<Product> existingProducts = FXCollections.observableArrayList();
      while (rs2.next()) {
        String productName = rs2.getString("NAME");
        String manufacturer = rs2.getString("MANUFACTURER");
        String type = rs2.getString("TYPE");
        Product product = new Product(productName, manufacturer, type);
        existingProducts.add(product);
      }
      existingProductTable.getItems().addAll(existingProducts);
      statement2.close();

      String sq3 = "SELECT * FROM PRODUCTIONRECORD";
      Statement statement3 = conn.createStatement();
      ResultSet rs3 = statement3.executeQuery(sq3);
      ObservableList<ProductionRecord> productionRecords = FXCollections.observableArrayList();
      while (rs3.next()) {
        int productionNum = rs3.getInt("PRODUCTION_NUM");
        String productId = rs3.getString("PRODUCT_ID");
        String serialNum = rs3.getString("SERIAL_NUM");
        String dateProducedFromDB = rs3.getString("DATE_PRODUCED");
        LocalDate dateProduced = LocalDate.parse(dateProducedFromDB);
        ProductionRecord productionRecord = new ProductionRecord(productionNum, productId, serialNum, dateProduced);
        productionRecords.add(productionRecord);
      }
      logListView.getItems().addAll(productionRecords);
      statement3.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * addProduct() method is used to collect data entered from
   * specified text fields and insert them into the
   * database previously connected to by using the initializeDB() method.
   */
  @FXML
  void addProduct(MouseEvent event) {
    try {
      /* PreparedStatement stmt;
      stmt = conn.createStatement();*/
      String productNameText = productName.getText();
      String manufacturerText = manufacturer.getText();
      String selectedItem = itemType.getSelectionModel().getSelectedItem();

      Product product = new Product(productNameText, manufacturerText, selectedItem);
      ObservableList existingProduct = FXCollections.observableArrayList(product);
      existingProductTable.getItems().addAll(existingProduct);

      String sq1 = "INSERT INTO PRODUCT (NAME,TYPE,MANUFACTURER) "
          + "VALUES ('" + productNameText + "', '"
          + selectedItem + "', '" + manufacturerText + "')";
      PreparedStatement preparedStatement1 = conn.prepareStatement(sq1);
      preparedStatement1.executeUpdate();
      preparedStatement1.close();

      String sq2 = "SELECT * FROM PRODUCT";
      Statement statement2 = conn.createStatement();
      ResultSet rs = statement2.executeQuery(sq2);
      ObservableList<String> recordedProduct = FXCollections.observableArrayList();
      while (rs.next()) {
        String productName = rs.getString("NAME");
        recordedProduct.add(productName);
      }
      chooseProductList.setItems(recordedProduct);
      statement2.close();
      // Statement stmt = conn.createStatement();
      // stmt.execute(String.format("SQL STATEMENT HERE WITH (%s string var pointers);", productName.getText(),etc.);
      // stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  /**
   * recordProduct() is used as soon as the Record Production button
   * in the Record Production tab is clicked when you've previously selected
   * a product in the Choose Product list and the number of products you wish
   * to record production for.
   * If this button is clicked and the previous two actions had not been made,
   * the program may throw an exception.
   */
  @FXML
  void recordProduct(MouseEvent event) {
    int selectedCount = Integer.parseInt(recQuantity.getSelectionModel().getSelectedItem());
    for (int i = 1; i <= selectedCount; i++) {
      try {
        String selectedItem = chooseProductList.getSelectionModel().getSelectedItem();
        String sq = "SELECT * FROM PRODUCT WHERE NAME='"
            + selectedItem + "'";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        ObservableList<ProductionRecord> productionLine = FXCollections.observableArrayList();
        while (rs.next()) {
          String productName = rs.getString("NAME");
          String manufacturer = rs.getString("MANUFACTURER");
          String itemType = rs.getString("TYPE");
          Product product = new Product(productName, manufacturer, itemType);
          ProductionRecord productionRecord = new ProductionRecord(product, accumulatedCount);
          accumulatedCount++;
          productionLine.add(productionRecord);
          PreparedStatement ps = conn.prepareStatement("INSERT INTO PRODUCTIONRECORD VALUES('"
              + productionRecord.getProductionNum()
              + "', '"
              + product.getName()
              + "', '"
              + productionRecord.getSerialNum()
              + "', '"
              + productionRecord.getProdDate()
              + "')");
          ps.executeUpdate();
        }
        logListView.getItems().addAll(productionLine);
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * initializeDB() is used to initialize the connection
   * to the database for interaction between the program and the database.
   */
  private void initializeDB() {
    // properties, Username and password needed to access database
    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./res/hr";
    try {
      // connect to database
      Class.forName(jdbcDriver);
      conn = DriverManager.getConnection(dbUrl);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
