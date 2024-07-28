package weatherstationpullversion.observer;

import output.MockOutput;
import output.Output;
import weatherstation.DisplayElement;
import weatherstationpullversion.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class MockCelsiusDisplay extends MockOutput implements Observer, DisplayElement {
    float celsiusTemp;
    Observable observable;
    Output output;

    public MockCelsiusDisplay(Observable observable, Output output) {
        this.observable = observable;
        this.output = output;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            float temp = weatherData.getTemperature();
            celsiusTemp = (temp - 32) * 5 / 9;
            display();
        }
    }

    @Override
    public void display() {
        output.print("Current temperature in Celsius: "+celsiusTemp+"°C");
    }
}
