package simpleactiverecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnect {
    private static Connection connection;
    private DbConnect() {}
    public static Connection getConnection() throws SQLException{
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        if(connection==null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
        } 
        return connection;
    }
}
