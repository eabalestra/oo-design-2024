package weatherstation.observer;

import weatherstation.DisplayElement;
import weatherstation.WeatherData;

public class CelsiusDisplay implements Observer, DisplayElement {
    float celsiusTemp;
    WeatherData weatherData;

    public CelsiusDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        celsiusTemp = (temp - 32) * 5 / 9;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current temperature in Celsius: "+celsiusTemp+"°C");
    }
}
