package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController extends Controller{
    public TextField emailTf;
    public PasswordField passwordTf;
    public Button submitBtn;
    public Button registerBtn;

    private User user;

    public void onClickSubmit(ActionEvent actionEvent) {
        String email = emailTf.getText();
        String password = passwordTf.getText();
        // validari: email si parola diferite de null
        // email sa contina @
        // parola sa aiba cel putin 8 caractere
        // validare care nu este indeplinita -> afisam un mesaj in pagina
        Connection connection = getDbConnection();
        String sqlQuery = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("name"));
                showMainHotelPage();
            } else {
                // nu avem un user cu aceste credentiale
                System.out.println("Nu exista user");
            }
        } catch (SQLException | IOException throwables) {
            System.out.println("Alta problema");
            throwables.printStackTrace();
        }

        // verificam in bd ca exista user cu parola
        // daca da -> mergem pe pagina hotel
        // daca nu -> afisam un mesaj de eroare
    }

    public void onClickRegister(ActionEvent actionEvent) throws IOException {
        // ne trimite la pagina de register
        String resourceName = "../register.fxml";
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        showOtherPage(resourceName, stage);
    }

    private void showMainHotelPage() throws IOException {
        HotelController hc = new HotelController(user);
        String resourceName = "../hotel.fxml";
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        showOtherPage(hc, resourceName, stage);
    }
}
