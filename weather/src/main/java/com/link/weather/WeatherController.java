package com.link.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class WeatherController {
	
	@GetMapping("/weather") 
	public ModelAndView weather() {
		ModelAndView weather = new ModelAndView("weather.html");
		return weather;
	}
	
	@GetMapping("/weather-form")
	public ModelAndView weatherForm(
			@RequestParam(name = "city", required = true) String location)
					throws IOException {
		ModelAndView weather = new ModelAndView("weather.html");
		
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=097b03b6796dfb0f566fc400d4026404";
		URL con = new URL(url);
		URLConnection urlCon = con.openConnection();
		
		InputStream obj = (InputStream)urlCon.getContent();
//		System.out.println(obj.toString());
		
		Scanner s = new Scanner(obj);
		String result = "";
		while (s.hasNext()) {
			result += s.nextLine();
		}
		
		System.out.println(result);
		
		Gson gson = new Gson();
		Weather w = gson.fromJson(result, Weather.class);
		System.out.println(w.getMain().getTemp());
		
		System.out.println(w.getWeather().get(0).getDescription());
	
//		try {
//			Weather w = getWeather(location);
//			weather.addObject("temp", String.format("%.02f", w.getMain().getTemp() - 273.15));
//			weather.addObject("location", location);
//		} catch (IOException e) {
//			weather.addObject("error", e.getMessage());
//			e.printStackTrace();
//		}
//		
		return weather;
	}
	
	private Weather getWeather(String location) throws IOException {
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=097b03b6796dfb0f566fc400d4026404";
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		String response = "";
		Scanner scanner = new Scanner(connection.getInputStream());
		while (scanner.hasNext()) {
			response += scanner.next();
		}
		
		Gson gson = new Gson();
		Weather w = gson.fromJson(response, Weather.class);
		
		System.out.println(w.getMain().getTemp());
		
		
		
		return w;		
	}
}