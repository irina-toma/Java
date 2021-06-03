package com.link.auto.dao.impl;

import com.link.auto.dao.User;
import com.link.auto.dao.UserDAO;
import com.link.auto.dao.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(String firstName, String lastName, String email, String password, String phone) {
        // adaugam user in baza de date
        String sqlQuery = "INSERT INTO `auto`.`user` (`first_name`,`last_name`,`email`,`password`,`phone`) " +
                "VALUES (?,?,?,?,?);";

        int result = jdbcTemplate.update(sqlQuery, firstName, lastName, email, password, phone);

        return result == 1;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        // verificam ca exista un user cu email si password
        String userQuery = "SELECT * FROM `auto`.`user` WHERE email = '" + email + "' AND password = '" + password + "'";
        User user = jdbcTemplate.queryForObject(userQuery, new UserRowMapper());
        return user;
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM `auto`.`user`";
        List<User> userList = jdbcTemplate.query(query, new UserRowMapper());
        return  userList;
    }

    @Override
    public User getByEmail(String email) {
        // verificam ca exista un user cu email si password
        String userQuery = "SELECT * FROM `auto`.`user` WHERE email = '" + email + "';";
        User user = jdbcTemplate.queryForObject(userQuery, new UserRowMapper());
        return user;
    }

    @Override
    public User getById(Integer id) {
        String userQuery = "SELECT * FROM `auto`.`user` WHERE id = " + id + ";";
        User user = jdbcTemplate.queryForObject(userQuery, new UserRowMapper());
        return user;
    }
}
