package com.example.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.LoginForm;
import com.example.models.User;
import com.example.models.UserMapper;


@Controller
public class UsersController {
	@Autowired
	JdbcTemplate jdbcTemplate;

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
			HttpServletRequest req, HttpServletResponse resp,
			LoginForm loginForm) {
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
				resp.addCookie(new Cookie("username", dbUser.getUsername()));

				Cookie[] cookies = req.getCookies();
				Cookie sessionCookie = createUserCookies(dbUser, cookies);

				resp.addCookie(sessionCookie);
				return new ModelAndView("redirect:/dashboard");
			} else {
				loginMV.addObject("errLogin", "Parola incorecta");
				return loginMV;
			}
		}
	}

	@GetMapping("/dashboard")
	public ModelAndView showDashboard(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView dashboardMV = new ModelAndView("dashboard.html");

		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			dashboardMV.addObject("err", "Utilizatorul nu este autentificat");
			return dashboardMV;
		}

		boolean isAuthenticated = false;

		for (Cookie cookie: cookies) {
			if (cookie.getName().equals("username")) {
				dashboardMV.addObject("username", cookie.getValue());
				isAuthenticated = true;
			}
		}

		if (!isAuthenticated) {
			dashboardMV.addObject("err", "Utilizatorul nu este autentificat");
		}

		dashboardMV.addObject("isAuthenticated", isAuthenticated);

		return dashboardMV;
	}

	private Cookie createUserCookies(User dbUser, Cookie[] cookies) {		
		Cookie sessionCookie = findCookie("sessionId", cookies);
		if (sessionCookie == null) {
			// create new session cookie
			UUID uuid = UUID.randomUUID();
			sessionCookie = new Cookie("sessionId", uuid.toString());
		}
		return sessionCookie;

	}

	private Cookie findCookie(String name, Cookie[] cookies) {
		if (cookies == null) {
			return null;
		}

		for (Cookie cookie: cookies) {
			if (cookie.getName().equals(name)) {
				return cookie;
			}
		}
		return null;
	}
}
