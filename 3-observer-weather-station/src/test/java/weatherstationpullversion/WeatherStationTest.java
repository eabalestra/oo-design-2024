package weatherstationpullversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.MockOutput;
import weatherstationpullversion.observer.*;

import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;
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

        weatherData.addObserver(currentConditionsDisplay);
        weatherData.addObserver(statisticsDisplay);
        weatherData.addObserver(forecastDisplay);
    }

    @Test
    void addMultipleObserversAndVerifyUpdates() {
        weatherData.setMeasurements(80, 65, 30.4f);

        verify(currentConditionsDisplay, times(1)).update(weatherData, null);
        verify(statisticsDisplay, times(1)).update(weatherData, null);
        verify(forecastDisplay, times(1)).update(weatherData, null);
    }

    @Test
    void removeObserverAndVerifyNoUpdate() {
        weatherData.deleteObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);

        verify(currentConditionsDisplay, times(1)).update(weatherData, null);
        verify(statisticsDisplay, times(1)).update(weatherData, null);
        verify(forecastDisplay, never()).update(weatherData, null);
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