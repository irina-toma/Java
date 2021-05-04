package com.link.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    ArrayList<String> users = new ArrayList<>();

    @GetMapping("/users")
    @ResponseBody
    public ArrayList<String> getUsers() {
        this.users.add("Irina");
        return users;
    }

    private void addUser(String name) {
        this.users.add(name);
    }


}
