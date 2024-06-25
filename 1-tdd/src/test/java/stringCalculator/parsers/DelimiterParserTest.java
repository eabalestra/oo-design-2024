package stringCalculator.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringCalculator.delimiters.DefaultDelimiters;
import stringCalculator.delimiters.Delimiters;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterParserTest {
    Delimiters delimiters;

    @BeforeEach
    public void setUp() {
        delimiters = new DefaultDelimiters();
    }

    @Test
    void parseDelimiterReturnsCorrectIndexWhenValidDelimiter() {
        int result = DelimiterParser.parseDelimiter(",123", 0, delimiters);

        assertEquals(0, result);
    }
}