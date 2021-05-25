package simpleactiverecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.List;
public class Person {
    public int id;
    public String firstname;
    public String lastname;
    public byte age;

    public boolean update() throws SQLException{
        Connection conn = DbConnect.getConnection();
        PreparedStatement st = conn.prepareStatement("update person set firstname=?, lastname=?, age=? where id=?");
        st.setString(1, this.firstname);
        st.setString(2, this.lastname);
        st.setByte(3, this.age); 
        st.setInt(4, this.id);
        int res = st.executeUpdate();
        return res >= 1;
    }

    public boolean insert() throws SQLException{
        Connection conn = DbConnect.getConnection();
        PreparedStatement st = conn.prepareStatement("insert into person values (null,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
        st.setString(1, this.firstname);
        st.setString(2, this.lastname);
        st.setByte(3, this.age); 
        st.execute();
        ResultSet keys = st.getGeneratedKeys();
        if(!keys.isBeforeFirst()) return false;
        else {
            keys.next();
            this.id = keys.getInt(1);
        } 
        return true;
    }

    public static Person getById(int id) throws SQLException {
        Connection conn = DbConnect.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from person where id = ?");
        st.setInt(1, id);
        ResultSet res = st.executeQuery();
        if(!res.isBeforeFirst()){
            return null;
        } else {
            res.next();
            Person p = new Person();
            p.id = res.getInt(1);
            p.firstname = res.getString(2);
            p.lastname = res.getString(3);
            p.age = res.getByte(4);
            return p;
        }
    }

    public static List<Person> getAll() throws SQLException{
        Connection conn = DbConnect.getConnection();
        Statement st = conn.createStatement();
        List<Person> result = new ArrayList<Person>();
        //st.execute("insert into person values (null,'peter','jackson',35)");
        ResultSet res = st.executeQuery("select * from person");
        while(res.next()){
            Person p = new Person();
            p.id = res.getInt(1);
            p.firstname = res.getString(2);
            p.lastname = res.getString(3);
            p.age = res.getByte(4);
            result.add(p);
        }
        return result;
    }

    @Override
    public String toString() {
        return this.id + " " + this.firstname + " " + this.lastname + " " + this.age;
    }
    
    
}
