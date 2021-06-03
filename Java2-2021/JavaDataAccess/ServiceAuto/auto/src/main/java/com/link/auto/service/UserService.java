package com.link.auto.service;

import com.link.auto.dao.User;
import com.link.auto.dao.UserDAO;
import com.link.auto.dto.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public boolean register(RegisterForm data) {

        boolean result = userDAO.save(data.getFirstName(), data.getLastName(),
                data.getEmail(), data.getPassword(), data.getPhone());

        return result;
    }

    public User login(String email, String password) {

        User user = userDAO.getByEmailAndPassword(email, password);
        return user;
    }
}
