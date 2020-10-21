package com.link.weather;

import java.util.ArrayList;
import java.util.List;

public class Weather {
	private Main main;
	private List<Sky> weather;
	
	public Weather(Main main, List<Sky> weather) {
		super();
		this.main = main;
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public List<Sky> getWeather() {
		return weather;
	}

	public void setWeather(ArrayList<Sky> weather) {
		this.weather = weather;
	}
}
