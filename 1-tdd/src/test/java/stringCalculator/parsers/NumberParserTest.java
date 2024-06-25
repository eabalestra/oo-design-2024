package stringCalculator.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumberParserTest {
    ArrayList<String> result;

    @BeforeEach
    public void setUp() {
        result = new ArrayList<>();
    }

    @Test
    void parseNumber_withValidNumber() {
        int parsedNumber = NumberParser.parseNumber("123", 0, result);

        assertEquals(2, parsedNumber);
        assertEquals("123", result.get(0));
    }

    @Test
    void parseNumber_withNegativeNumber() {
        int parsedNumber = NumberParser.parseNumber("-123", 0, result);

        assertEquals(3, parsedNumber);
        assertEquals("-123", result.get(0));
    }

    @Test
    void parseNumber_withInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> NumberParser.parseNumber("a123", 0, result));
    }

    @Test
    void parseNumber_withEmptyString() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> NumberParser.parseNumber("", 0, result));
    }

    @Test
    void parseNumber_withNonZeroStartIndex() {
        int parsedNumber = NumberParser.parseNumber("abc123", 3, result);

        assertEquals(5, parsedNumber);
        assertEquals("123", result.get(0));
    }

}