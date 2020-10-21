package com.link.weather;

public class Main {
	private float temp;
	private int pressure;
	private int humidity;
	
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	public Main(float temp, int pressure, int humidity) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
	}
}
