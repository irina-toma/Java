package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class Controller {

    @FXML
    public Button loginBtn;

    public Controller() {

    }

    @FXML
    public void mouseEntered(MouseEvent e) {
        loginBtn.setStyle("-fx-background-color: pink;");
        System.out.println(e);
    }

    @FXML
    public void mouseExited() {
        loginBtn.setStyle("-fx-background-color: lightblue;");
    }
}
