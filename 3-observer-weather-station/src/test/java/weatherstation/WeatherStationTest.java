package weatherstation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.MockOutput;
import weatherstation.observer.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.*;

class WeatherStationTest {
    WeatherData weatherData;
    MockOutput output;

    Observer currentConditionsDisplay;
    Observer statisticsDisplay;
    Observer forecastDisplay;


    @BeforeEach
    void setUp() {
        weatherData = new WeatherData();
        output = new MockOutput();
        currentConditionsDisplay = mock(CurrentConditionsDisplay.class);
        statisticsDisplay = mock(StatisticsDisplay.class);
        forecastDisplay = mock(ForecastDisplay.class);
    }


    @Test
    void addMultipleObserversAndVerifyUpdates() {
        weatherData.registerObserver(currentConditionsDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);

        verify(currentConditionsDisplay, times(1)).update(80, 65, 30.4f);
        verify(statisticsDisplay, times(1)).update(80, 65, 30.4f);
        verify(forecastDisplay, times(1)).update(80, 65, 30.4f);
    }

    @Test
    void removeObserverAndVerifyNoUpdate() {
        weatherData.registerObserver(currentConditionsDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(80, 65, 30.4f);

        verify(currentConditionsDisplay, times(1)).update(80, 65, 30.4f);
        verify(statisticsDisplay, times(1)).update(80, 65, 30.4f);
        verify(forecastDisplay, never()).update(anyFloat(), anyFloat(), anyFloat());
    }

    @Test
    void celsiusDisplayUpdatesTemperature() {
        Observer observer = new MockCelsiusDisplay(weatherData, output);

        weatherData.setMeasurements(80, 65, 30.4f);

        assertEquals("Current temperature in Celsius: 26.666666°C", output.getPrintInput());
    }

    @Test
    void heatIndexDisplayUpdatesHeatIndex() {
        Observer observer = new MockThermalSensationDisplay(weatherData, output);

        weatherData.setMeasurements(80, 65, 30.4f);

        assertEquals("Current Thermal Sensation: 82.95535°C", output.getPrintInput());
    }
}