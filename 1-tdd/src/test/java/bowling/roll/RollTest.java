package bowling.roll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RollTest {

    private static Stream<Arguments> providePinsForRoll() {
        return Stream.of(
                Arguments.of(0, 0), // Test lower boundary
                Arguments.of(5, 5), // Test middle value
                Arguments.of(10, 10) // Test upper boundary
        );
    }

    private static Stream<Arguments> negativeProvidePinsForRoll() {
        return Stream.of(
                Arguments.of(-1, IllegalArgumentException.class), // Test below lower boundary
                Arguments.of(11, IllegalArgumentException.class) // Test above upper boundary
        );
    }

    @ParameterizedTest
    @MethodSource("providePinsForRoll")
    public void testRoll(int pins, Object expected) {
        Roll roll = new Roll(pins);
        Assertions.assertEquals((int) expected, roll.pins());
    }

    @ParameterizedTest
    @MethodSource("negativeProvidePinsForRoll")
    public void testExceptionRoll(int pins, Class<? extends Exception> expected) {
        Assertions.assertThrows(expected, () -> new Roll(pins));
    }
}