package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import model.Room;
import model.User;

public class ReservationController extends Controller {
    public Label usernameLabel;
    public Label roomNameLabel;
    public Label roomPriceLabel;
    public DatePicker reservationDate;
    public Button confirmBtn;

    private User user;
    private Room room;

    public ReservationController(User user, Room room) {
        this.user = user;
        this.room = room;
    }

    @FXML
    public void onReserveBtnClick(ActionEvent actionEvent) {
        System.out.println(this.reservationDate.getValue());
    }

    @FXML
    public void initialize() {
        this.usernameLabel.setText(user.getName());
        this.roomNameLabel.setText(room.getDescription());

    }
}
