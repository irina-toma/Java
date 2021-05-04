package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller {
    private String url = "jdbc:mysql://localhost:3306/hotel";
    private String username = "root";
    private String password = "root";

    Connection connection = null;

    protected Connection getDbConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(
                        url, username, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                return connection;
            }
        }
    }

    protected void showOtherPage(String resourceName, Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(resourceName));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    protected void showOtherPage(String resourceName, Stage stage, String css) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(resourceName));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(css).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    protected void showOtherPage(Controller controller, String resourceName, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    protected void showOtherPage(Controller controller, String resourceName, Stage stage, String css) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource(css).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


}
