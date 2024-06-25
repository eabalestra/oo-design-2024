package stringCalculator.output;

import org.junit.jupiter.api.Test;
import stringCalculator.System;
import stringCalculator.input.MockInput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    @Test
    public void outputTest() {
        String input = "//[**][$$]\n1**5$$8;2";
        int expected = 16;

        MockOutput mock = new MockOutput();
        System system = new System(new MockInput(), mock);
        system.stringCalculator(input);

        assertTrue(mock.isInvoked());
        assertThat(mock.getValueToPrint()).isEqualTo(expected);
    }

}