package stringCalculator.delimiters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimitersFactoryTest {
    private String customDelimiterText;
    private String defaultDelimiterText;

    @BeforeEach
    void setUp() {
        customDelimiterText = "//[xyzw][///][m]\n-10xyzw1m7///3";
        defaultDelimiterText = "1,2,3";
    }

    @Test
    void generateDelimitersReturnsCustomDelimitersWhenTextStartsWithCustomDelimiterStarts() {
        Delimiters delimiters = DelimitersFactory.generateDelimiters(customDelimiterText);

        assertInstanceOf(CustomDelimiters.class, delimiters);
    }

    @Test
    void generateDelimitersReturnsDefaultDelimitersWhenTextDoesNotStartWithCustomDelimiterStarts() {
        Delimiters delimiters = DelimitersFactory.generateDelimiters(defaultDelimiterText);

        assertInstanceOf(DefaultDelimiters.class, delimiters);
    }
}