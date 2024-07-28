package weatherstation.observer;

import output.MockOutput;
import output.Output;
import weatherstation.DisplayElement;
import weatherstation.WeatherData;

public class MockCelsiusDisplay extends MockOutput implements Observer, DisplayElement {
    float celsiusTemp;
    Output output;
    WeatherData weatherData;

    public MockCelsiusDisplay(WeatherData weatherData, Output output) {
        this.weatherData = weatherData;
        this.output = output;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        celsiusTemp = (temp - 32) * 5 / 9;
        display();
    }

    @Override
    public void display() {
        output.print("Current temperature in Celsius: "+celsiusTemp+"°C");
    }
}
