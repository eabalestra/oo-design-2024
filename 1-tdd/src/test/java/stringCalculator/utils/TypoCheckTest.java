package stringCalculator.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypoCheckTest {

    @Test
    void isAValidNumber_withValidNumber() {
        boolean result = TypoCheck.isAValidNumber("123");

        assertTrue(result);
    }

    @Test
    void isAValidNumber_withNegativeNumber() {
        boolean result = TypoCheck.isAValidNumber("-123");

        assertTrue(result);
    }

    @Test
    void isAValidNumber_withInvalidNumber() {
        boolean result = TypoCheck.isAValidNumber("1a23");

        assertFalse(result);
    }

    @Test
    void isAValidNumber_withEmptyString() {
        boolean result = TypoCheck.isAValidNumber("");

        assertFalse(result);
    }

    @Test
    void containsNumbers_withNumbers() {
        boolean result = TypoCheck.containsNumbers("1a23");

        assertTrue(result);
    }

    @Test
    void containsNumbers_withoutNumbers() {
        boolean result = TypoCheck.containsNumbers("abc");

        assertFalse(result);
    }

    @Test
    void containsNumbers_withEmptyString() {
        boolean result = TypoCheck.containsNumbers("");

        assertFalse(result);
    }

}