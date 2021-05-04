package controller.room;

import controller.Controller;
import controller.cinema.CinemaController;
import model.Cinema;
import model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomController extends Controller {

    public ArrayList<Room> getAll() {
        Connection connection = connectToDB();
        String sqlQuery = "SELECT * FROM room;";
        return runSelect(connection, sqlQuery);
    }

    public ArrayList<Room> getAllByCinema(Cinema c) {
        Connection connection = connectToDB();
        String sqlQuery = "SELECT * FROM room WHERE cinema_id=" + c.getId();
        return runSelect(connection, sqlQuery);
    }

    public void add(Room r) {
        Connection connection = connectToDB();

        // gasim cinematograful de care apartine sala - daca nu il primim ca parmetru
        CinemaController cc = new CinemaController();
        Cinema cinema = cc.getById(r.getCinemaId());

        // salile de cinema din baza de date pt cinema id dat

        ArrayList<Room> roomList = getAllByCinema(cinema);
        int actualCinemaNoRooms = roomList.size();

        // verificam ca numarul de sali este corect
        //      numarul efectiv de sali < numarul de sali specificat de cinematograf
        if (cinema.getNoRooms() > actualCinemaNoRooms) {
            String sqlQuery = "INSERT INTO `cinema`.`room` (`cinema_id`,`no_seats`,`type`) VALUES(?,?,?);";
            runInsert(connection, sqlQuery, r);
        } else {
            // throw exception
            System.out.println("Am depasit numarul de sali");
        }
    }

    public ArrayList<Room> runSelect(Connection connection, String sqlQuery) {
        ArrayList<Room> roomList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room r = new Room(
                        rs.getInt("id"),
                        rs.getInt("cinema_id"),
                        rs.getInt("no_seats"),
                        rs.getString("type")
                );
                roomList.add(r);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }

    public void runInsert(Connection connection, String sqlQuery, Room c) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, c.getCinemaId());
            ps.setInt(2, c.getNoSeats());
            ps.setString(3, c.getType());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
