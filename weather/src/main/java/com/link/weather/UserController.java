package com.link.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class UserController {
	@GetMapping("/user") 
	public ModelAndView weather() {
		ModelAndView weather = new ModelAndView("weather.html");
		return weather;
	}

	@GetMapping("/user-form")
	public ModelAndView weatherForm(
			@RequestParam(name = "id", required = true) String userId)
					throws IOException {
		ModelAndView userView = new ModelAndView("weather.html");

		String url = "https://jsonplaceholder.typicode.com/posts?userId=" + userId;

		URL con = new URL(url);
		URLConnection urlCon = con.openConnection();

		InputStream obj = (InputStream)urlCon.getContent();

		Scanner s = new Scanner(obj);
		String result = "";
		while (s.hasNext()) {
			result += s.nextLine();
		}

		System.out.println(result);

		Gson gson = new Gson();
		List<Post> listOfPosts = gson.fromJson(result, 
				new TypeToken<List<Post>>(){}.getType());
		
		for (int i = 0; i < listOfPosts.size(); i ++) {
			System.out.println(listOfPosts.get(i).getTitle());
		}
		
		return userView;
	}
}
