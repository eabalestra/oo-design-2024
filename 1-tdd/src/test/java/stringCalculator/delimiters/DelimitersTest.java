package stringCalculator.delimiters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringCalculator.System;
import stringCalculator.input.MockInput;
import stringCalculator.output.ConsoleOutput;

import static org.junit.jupiter.api.Assertions.*;

class DelimitersTest {
    System system;

    @BeforeEach
    public void setUp() {
        system = new System(new MockInput(), new ConsoleOutput());
    }

    @Test
    public void isADelimiterTest() {
        String input = "//[xyzw][///][m]\n-10xyzw1m7///3";
        Delimiters actual = DelimitersFactory.generateDelimiters(input);

        assertTrue(actual.isValidDelimiter("xyzw"));
        assertTrue(actual.isValidDelimiter("///"));
    }

    @Test
    public void numberDelimiterShouldReject() {
        String input = "//[{{{5}}}][*][_]\n2{{{5}}}11*31_11";

        assertThrows(IllegalArgumentException.class, () -> system.stringCalculator(input));
    }

    @Test
    public void minusSignDelimiterShouldReject() {
        String input = "//[-][*][^^^]\n9*8-5^^^6";

        assertThrows(IllegalArgumentException.class, () -> system.stringCalculator(input));
    }

    @Test
    public void cantEndsWithDelimiter() {
        String input = "//[{}][*][_]\n211*31_11*";

        assertThrows(IllegalArgumentException.class, () -> system.stringCalculator(input));
    }
}