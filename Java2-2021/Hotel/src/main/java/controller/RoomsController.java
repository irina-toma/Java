package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomsController extends Controller {

    ObservableList<Room> rooms;

    public Label titleLabel;
    public ListView roomListView;
    public Label roomIdLabel;
    public Text roomDescriptionText;
    public Label roomTypeLabel;
    public Label nrPersLabel;
    public Button reserveBtn;

    @FXML
    private void initialize() {
        rooms = FXCollections.observableArrayList();

        ArrayList<Room> dbRooms = getRoomsFromDB();
        rooms.setAll(dbRooms);
        roomListView.setItems(rooms);

        roomListView.setCellFactory(new Callback<ListView<Room>, ListCell<Room>>() {
            @Override
            public ListCell<Room> call(ListView<Room> param) {
                ListCell<Room> roomCell = new ListCell<Room>() {
                    @Override
                    protected void updateItem(Room item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getType());
                        } else {
                            setText("");
                        }
                    }
                };
                return roomCell;
            }
        });
    }

    private ArrayList<Room> getRoomsFromDB() {
        ArrayList<Room> rooms = new ArrayList<>();

        Connection connection = getDbConnection();
        String sqlQuery = "SELECT * FROM room;";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Room r = new Room(rs.getInt("id"), rs.getString("description"),
                        rs.getString("type"), rs.getInt("nr_pers"));
                rooms.add(r);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return rooms;
        }
    }
}
