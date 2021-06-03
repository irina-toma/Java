package com.link.auto.controller;

import com.link.auto.dto.RegisterForm;
import com.link.auto.dao.User;
import com.link.auto.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/users")
    // un endpoint care sa imi afiseze toti utilizatorii din bd
    public ModelAndView getUsers() {
        ModelAndView userView = new ModelAndView("users.html");
        List<User> userList = adminService.getAllUsers();
        userView.addObject("users", userList);
        return userView;
    }

    @GetMapping("/users/{id}")
    public ModelAndView getUserById(@PathVariable Integer id) {
        ModelAndView userView = new ModelAndView("userProfile.html");
        User currentUser = adminService.getUserById(id);
        userView.addObject("user", currentUser);
        return userView;
    }


    @PutMapping(value="/users/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView updateUserById(@PathVariable Integer id, RegisterForm data) {
        ModelAndView userView = new ModelAndView("userProfile.html");

        System.out.println(id);
        System.out.println(data.getEmail());

        return userView;
    }

}
