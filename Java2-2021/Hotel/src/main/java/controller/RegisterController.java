package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController extends Controller {
    public Button loginBtn;
    public Button submitBtn;
    public TextField emailTf;
    public PasswordField passwordTf;
    public TextField nameTf;

    public void onClickLogin(ActionEvent actionEvent) throws IOException {
        String resourceName = "../login.fxml";
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        showOtherPage(resourceName, stage);
    }

    public void onClickSubmit(ActionEvent actionEvent) {
        // verifica email unic ?
        // adaugam user in bd
    }
}
