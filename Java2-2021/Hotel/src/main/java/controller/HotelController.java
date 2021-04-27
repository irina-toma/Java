package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelController extends Controller {

    public Text descLabel;
    public Text addressLabel;
    public Text roomsLabel;
    public Button showRoomsBtn;

    public void showMainInfo() {
        // conectare la db
        // citire informatii hotel
        // populare labels
        Connection connection = getDbConnection();
        String sqlQuery = "SELECT * FROM hotel";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                descLabel.setText(rs.getString("description"));
                addressLabel.setText(rs.getString("address"));
                roomsLabel.setText("" + rs.getInt("nr_rooms"));
            }
        } catch (SQLException throwables) {
            System.out.println("Alta problema");
            throwables.printStackTrace();
        }
    }

    public void onClickShowRooms(ActionEvent actionEvent) throws IOException {
        String resourceName = "../roomsList.fxml";
        Stage stage = (Stage) showRoomsBtn.getScene().getWindow();
        showOtherPage(resourceName, stage);
    }

    @FXML
    private void initialize() {
        showMainInfo();
    }
}
