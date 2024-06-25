package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringCalculator.input.MockInput;
import stringCalculator.output.ConsoleOutput;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    System system;

    @BeforeEach
    void setUp() {
        system = new System(new MockInput(), new ConsoleOutput());
    }

    private static Stream<Arguments> numbersProvider() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3),
                Arguments.of("1;2,3", 6),
                Arguments.of("1,5;3", 9),
                Arguments.of("//[**]\n1**2", 3),
                Arguments.of("//[***]\n1***2***3", 6),
                Arguments.of("//[**][$$]\n1**2$$8", 11),
                Arguments.of("//[xyzw][///][m]\n-10xyzw1m7///3", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersProvider")
    public void addTest(String input, int expected) {
        int result = system.stringCalculator(input);

        assertEquals(expected, result);
    }

    @Test
    public void invalidNumberShouldReject() {
        String input = "//[¿¿][*][_]\n2¿¿5-5,11*31_11";

        assertThrows(IllegalArgumentException.class, () -> system.stringCalculator(input));
    }

}
