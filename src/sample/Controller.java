package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Button testBut;

    @FXML
    void addProduct(MouseEvent event) {
        System.out.println("Hi");
    }
    @FXML
    void recordProduct(MouseEvent event) {
        System.out.println("Hi");
    }

}
