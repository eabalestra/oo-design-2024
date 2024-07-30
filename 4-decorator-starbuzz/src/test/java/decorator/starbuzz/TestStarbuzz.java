package decorator.starbuzz;

import decorator.starbuzz.beverage.Beverage;
import decorator.starbuzz.BeverageFactory;
import decorator.starbuzz.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class TestStarbuzz {

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
    public void testDescription(String beverageType, Size size, List<String> condimentsType, String expected) {
        BeverageFactory beverageFactory = new BeverageFactory();
        Beverage beverage = beverageFactory.createBeverage(beverageType, size);
        for (String condimentType : condimentsType) {
            beverage = beverageFactory.createCondiment(beverage, condimentType);
        }
        Assertions.assertEquals(expected, beverage.getDescription() + " $" + beverage.cost());
    }
}
