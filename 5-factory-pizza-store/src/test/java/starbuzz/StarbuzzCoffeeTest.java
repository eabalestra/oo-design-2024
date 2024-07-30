package starbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import starbuzz.beverage.Beverage;
import starbuzz.factory.SimpleBeverageFactory;

import static org.junit.jupiter.api.Assertions.*;

class StarbuzzCoffeeTest {

    static Stream<Arguments> beverageProvider() {
        return Stream.of(
                Arguments.of("Espresso", Size.TALL, List.of("Mocha"), "Espresso Coffee, Mocha" + " $" + 2.45),
                Arguments.of("DarkRoast", Size.VENTI, List.of("Mocha", "Mocha", "Whip"), "Dark Roast Coffee, Mocha, Mocha, Whip" + " $" + 1.55),
                Arguments.of("HouseBlend", Size.TALL, List.of("Soy", "Mocha", "Mocha", "Whip"), "House Blend Coffee, Soy, Mocha, Mocha, Whip" + " $" + 2.4),
                Arguments.of("Decaf", Size.GRANDE, List.of("Milk", "Mocha"), "Decaf Coffee, Milk, Mocha" + " $" + 1.7),
                Arguments.of("Tea", Size.VENTI,  List.of("Sugar"), "Tea, Sugar" + " $" + 1.6)
        );
    }

    @ParameterizedTest
    @MethodSource("beverageProvider")
    public void descriptionMatchesExpected(String beverageType, Size size, List<String> condimentsType, String expected) {
        SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
        Beverage beverage = beverageFactory.createBeverage(beverageType, size);
        for (String condimentType : condimentsType) {
            beverage = beverageFactory.addCondiment(beverage, condimentType);
        }
        assertEquals(expected, beverage.getDescription() + " $" + beverage.cost());
    }

    static Stream<Arguments> invalidBeverageProvider() {
        return Stream.of(
                Arguments.of("InvalidBeverage", Size.TALL, List.of("Mocha")),
                Arguments.of("Espresso", Size.TALL, List.of("InvalidCondiment"))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidBeverageProvider")
    public void throwsExceptionForInvalidInputs(String beverageType, Size size, List<String> condimentsType) {
        SimpleBeverageFactory beverageFactory = new SimpleBeverageFactory();
        assertThrows(IllegalArgumentException.class, () -> {
            Beverage beverage = beverageFactory.createBeverage(beverageType, size);
            for (String condimentType : condimentsType) {
                beverage = beverageFactory.addCondiment(beverage, condimentType);
            }
        });
    }
}