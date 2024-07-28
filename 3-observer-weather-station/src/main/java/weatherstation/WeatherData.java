package weatherstation;

import weatherstation.observer.Observer;

import java.util.*;

public class WeatherData implements Subject {
	private List<weatherstation.observer.Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<weatherstation.observer.Observer>();
	}
	
	public void registerObserver(weatherstation.observer.Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(weatherstation.observer.Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

}
