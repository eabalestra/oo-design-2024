package weatherstation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weatherstation.observer.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherDataTest {
    private WeatherData weatherData;
    private Observer observer;

    @BeforeEach
    void setUp() {
        weatherData = new WeatherData();
        observer = mock(Observer.class);
    }

    @Test
    void registerObserverAddsObserverToList() {
        weatherData.registerObserver(observer);
        weatherData.setMeasurements(80, 65, 30.4f);

        verify(observer, times(1)).update(80, 65, 30.4f);
    }

    @Test
    void removeObserverRemovesObserverFromList() {
        weatherData.registerObserver(observer);
        weatherData.removeObserver(observer);
        weatherData.setMeasurements(80, 65, 30.4f);

        verify(observer, never()).update(anyFloat(), anyFloat(), anyFloat());
    }

    @Test
    void notifyObserversNotifiesAllObservers() {
        Observer observer2 = mock(Observer.class);
        weatherData.registerObserver(observer);
        weatherData.registerObserver(observer2);
        weatherData.setMeasurements(80, 65, 30.4f);

        verify(observer, times(1)).update(80, 65, 30.4f);
        verify(observer2, times(1)).update(80, 65, 30.4f);
    }

    @Test
    void setMeasurementsUpdatesTemperatureHumidityAndPressure() {
        weatherData.setMeasurements(80, 65, 30.4f);

        assertEquals(80, weatherData.getTemperature());
        assertEquals(65, weatherData.getHumidity());
        assertEquals(30.4f, weatherData.getPressure());
    }

    @Test
    void setMeasurementsNotifiesObservers() {
        weatherData.registerObserver(observer);
        weatherData.setMeasurements(80, 65, 30.4f);

        verify(observer, times(1)).update(80, 65, 30.4f);
    }
}