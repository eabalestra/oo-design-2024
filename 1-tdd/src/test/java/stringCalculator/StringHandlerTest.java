package stringCalculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringHandlerTest {

    @Test
    void getNumbersSubStringReturnsCorrectSubStringWhenCustomDelimiters() {
        String result = StringHandler.getNumbersSubString("//[xyzw][///][m]\n-10xyzw1m7///3");

        assertEquals("-10xyzw1m7///3", result);
    }

    @Test
    void getNumbersSubStringReturnsCorrectSubStringWhenDefaultDelimiters() {
        String result = StringHandler.getNumbersSubString("1,2,3");

        assertEquals("1,2,3", result);
    }

    @Test
    void convertToIntListReturnsCorrectListWhenValidStrings() {
        List<String> input = List.of("1", "2", "3");
        List<Integer> result = StringHandler.convertToIntList(input);

        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void convertToIntListThrowsExceptionWhenInvalidStrings() {
        List<String> input = List.of("1", "a", "3");

        assertThrows(NumberFormatException.class, () -> StringHandler.convertToIntList(input));
    }

}