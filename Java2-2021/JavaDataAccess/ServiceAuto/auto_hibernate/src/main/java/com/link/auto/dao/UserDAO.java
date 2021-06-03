package com.link.auto.dao;

import java.util.List;

public interface UserDAO {
    boolean save(String firstName, String lastName, String email, String password, String phone);
    User getByEmail(String email);
    User getById(Integer id);
    User getByEmailAndPassword(String email, String password);
    List<User> getAll();
}
