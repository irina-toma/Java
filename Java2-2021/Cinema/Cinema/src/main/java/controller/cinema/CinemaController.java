package controller.cinema;

import controller.Controller;
import model.Cinema;
import model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CinemaController extends Controller {
    /**
     * toate cinematografele
     *  - conectare la baza de date
     * select cinema
     * lista cu toate cinematografele
     * intoarcem cinematografele
     */

    public ArrayList<Cinema> getAll() {
        Connection connection = connectToDB();
        String sqlQuery = "SELECT * FROM cinema;";
        return runSelect(connection, sqlQuery);
    }

    public Cinema getById(int cinemaId) {
        Connection connection = connectToDB();
        String sqlQuery = "SELECT * FROM cinema WHERE id=" + cinemaId;
        ArrayList<Cinema> cinemaList = runSelect(connection, sqlQuery);
        if (cinemaList.size() > 0) {
            return cinemaList.get(0);
        } else {
            return null;
        }
    }

    public void add(Cinema c) {
        Connection connection = connectToDB();
        String sqlQuery = "INSERT INTO `cinema`.`cinema` (`name`, `location`, `no_rooms`) VALUES ( ?, ?, ?);";
        runInsert(connection, sqlQuery, c);
    }

    public ArrayList<Cinema> runSelect(Connection connection, String sqlQuery) {
        ArrayList<Cinema> cinemaList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cinema c = new Cinema(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("no_rooms")
                );
                cinemaList.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cinemaList;
    }

    public void runInsert(Connection connection, String sqlQuery, Cinema c) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, c.getName());
            ps.setString(2, c.getLocation());
            ps.setInt(3, c.getNoRooms());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
