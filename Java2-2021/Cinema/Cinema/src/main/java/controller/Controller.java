package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller {
    /**
     * conectare la baza de date
     */

    String connectionUrl = "jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "auth";
    String password = "auth";

    protected Connection connectToDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                            connectionUrl,
                            username,
                            password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return connection;
        }
    }
}
