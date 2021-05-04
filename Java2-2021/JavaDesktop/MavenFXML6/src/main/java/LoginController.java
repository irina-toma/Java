import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginController {

    @FXML
    Button loginBtn;


    public void onLoginClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Connection conn = connectToDb();

        stage.show();
    }

    public Connection connectToDb() {
        String connectionUrl = "jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "auth";
        String password = "auth";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return conn;
        }
    }
}
