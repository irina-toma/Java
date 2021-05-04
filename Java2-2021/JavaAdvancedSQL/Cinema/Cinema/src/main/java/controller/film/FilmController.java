package controller.film;

import controller.Controller;
import model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmController extends Controller {
    /**
     * toate filmele
     *  - conectare la baza de date
     * select filme
     * lista cu toate filmele
     * intoarcem filmele
     */

    public ArrayList<Film> getAll() {
        Connection connection = connectToDB();
        String sqlQuery = "SELECT * FROM film;";
        return runSelect(connection, sqlQuery);
    }

    public ArrayList<Film> getByYear(int year) {
        ArrayList<Film> filmList = new ArrayList<>();
        Connection connection = connectToDB();
        String sqlQuery = "SELECT * FROM film WHERE release_year=" + year;
        filmList = runSelect(connection, sqlQuery);
        return filmList;
    }

    public void add(Film f) {
        Connection connection = connectToDB();
        String sqlQuery = "INSERT INTO film (`title`,`description`," +
                "`release_year`,`language`,`rating`) VALUES (?,?,?,?,?)";
        runInsert(connection, sqlQuery, f);
    }

    public ArrayList<Film> runSelect(Connection connection, String sqlQuery) {
        ArrayList<Film> filmList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Film f = new Film(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("release_year"),
                        rs.getString("language"),
                        rs.getInt("rating"));
                filmList.add(f);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }

    public void runInsert(Connection connection, String sqlQuery, Film f) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, f.getTitle());
            ps.setString(2, f.getDescription());
            ps.setInt(3, f.getReleaseYear());
            ps.setString(4, f.getLanguage());
            ps.setInt(5, f.getRating());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
