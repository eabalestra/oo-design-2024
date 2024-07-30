package starbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.stream.Stream;

import decorator.starbuzz.*;
import decorator.starbuzz.beverage.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestBeverageFactory {

    @ParameterizedTest
    @MethodSource("beverageProvider")
    public void testCreateBeverage(String beverageString, Beverage expected) {
        BeverageFactory BeverageFactory = new BeverageFactory();
        Beverage beverage = BeverageFactory.createBeverage(beverageString, expected.getSize());

        assertInstanceOf(expected.getClass(), beverage);
        assertEquals(expected.getSize(), beverage.getSize());
    }

    private static Stream<Object> beverageProvider() {
        return Stream.of(
                Arguments.of("Espresso", new Espresso(Size.GRANDE)),
                Arguments.of("Tea", new Tea(Size.VENTI)),
                Arguments.of("HouseBlend", new HouseBlend(Size.TALL)),
                Arguments.of("Decaf", new Decaf(Size.GRANDE)),
                Arguments.of("DarkRoast", new DarkRoast(Size.VENTI))
        );
    }
}