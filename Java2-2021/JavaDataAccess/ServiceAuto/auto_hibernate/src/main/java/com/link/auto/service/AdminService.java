package com.link.auto.service;

import com.link.auto.dao.User;
import com.link.auto.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    UserDAO userDAO;

    public List<User> getAllUsers() {
        List<User> userList = userDAO.getAll();
        return userList;
    }

    public User getUserById(Integer id) {
        User user = userDAO.getById(id);
        return user;
    }
}
