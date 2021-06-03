package com.link.auto.controller;

import com.link.auto.dto.LoginForm;
import com.link.auto.dto.RegisterForm;
import com.link.auto.dao.User;
import com.link.auto.security.UserSession;
import com.link.auto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserSession userSession;

    // endpoint care intoarce register.html -> GET
    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register.html");
    }

    // endpoint care proceseaza cererea de register -> POST
    @PostMapping(value = "/register-result", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postRegister(RegisterForm data) {
        ModelAndView registerView = new ModelAndView("register.html");

        if (!data.getPassword().equals(data.getPassword2())) {
            registerView.addObject("errPassword", "The two passwords do not match");
        } else {
            boolean success = userService.register(data);
            if (success) {
                return new ModelAndView("redirect:/login");
            } else {
                registerView.addObject("errPassword", "Error adding user");
            }
        }

        return registerView;
    }

    // endpoint care intoarce login.html -> GET
    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login.html");
    }

    // endpoint care proceseaza cererea de login -> POST
    @PostMapping(value = "/login-result",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postLogin(LoginForm data, HttpServletRequest request) {
        ModelAndView loginView = new ModelAndView("login.html");

        User user = userService.login(data.getEmail(), data.getPassword());
        if (user != null) {
            request.getSession().setAttribute("loggedIn", true);
//            userSession.setId(user.getId());
            return new ModelAndView("redirect:/dashboard");
        } else {
            loginView.addObject("errLogin",
                    "Incorrect email or password");
            return loginView;
        }
    }
}
