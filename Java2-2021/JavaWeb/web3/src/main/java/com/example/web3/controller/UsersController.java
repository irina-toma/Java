package com.example.web3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.web3.model.LoginForm;
import com.example.web3.model.User;
import com.example.web3.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UsersController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/register")
	public ModelAndView showRegister() {
		ModelAndView registerMV = new ModelAndView("register.html");
		return registerMV;
	}

	@GetMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView registerMV = new ModelAndView("login.html");
		return registerMV;
	}

	@GetMapping("/register-form")
	public ModelAndView register(
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "password", required = true) String password,
			@RequestParam(name = "re-password", required = true) String password2)
	{

		ModelAndView registerMV = new ModelAndView("register.html");

		if (!password.equals(password2)) {
			registerMV.addObject("errPass", "Parolele nu coincid");
			return registerMV;
		} else {
			jdbcTemplate.update("INSERT INTO users values (null, ?, ?, ?)",
					username, password, email);
		}

		return new ModelAndView("redirect:/index.html");

	}

	@GetMapping("/login-form")
	public ModelAndView login(
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "password", required = true) String password) {
		ModelAndView loginMV = new ModelAndView("login.html");
		
		String queryStm = "SELECT * FROM users WHERE email='" + email + "';";

		ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query(queryStm, new UserMapper());

		if (users.size() == 0) {
			loginMV.addObject("errLogin", "Nu exista un cont de utilizator cu acest email.");
			return loginMV;
		} else if (users.size() > 1) {
			loginMV.addObject("errLogin", "Exista mai multi utilizatori cu acelasi email");
			return loginMV;
		} else {
			User dbUser = users.get(0);
			if (dbUser.getPassword().equals(password)) {
				return new ModelAndView("redirect:/dashboard");
			} else {
				loginMV.addObject("errLogin", "Parola incorecta");
				return loginMV;
			}
		}
	}

	@PostMapping(value="/login-form", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView loginPost(
			@RequestBody  LoginForm loginForm) {
		ModelAndView loginMV = new ModelAndView("login.html");

		ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query
				("SELECT * FROM users WHERE email='" + loginForm.getEmail() + "';", new UserMapper());

		if (users.size() == 0) {
			loginMV.addObject("errLogin", "Nu exista un cont de utilizator cu acest email.");
			return loginMV;
		} else if (users.size() > 1) {
			loginMV.addObject("errLogin", "Exista mai multi utilizatori cu acelasi email");
			return loginMV;
		} else {
			User dbUser = users.get(0);
			if (dbUser.getPassword().equals(loginForm.getPassword())) {
				return new ModelAndView("redirect:/dashboard");
			} else {
				loginMV.addObject("errLogin", "Parola incorecta");
				return loginMV;
			}
		}
	}
}
