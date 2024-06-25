package stringCalculator.input;

import org.junit.jupiter.api.Test;
import stringCalculator.System;
import stringCalculator.output.MockOutput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    public void inputTest() {
        MockInput mock = new MockInput();
        mock.setInput("//[%][$$]\n1%9$$2;8");
        System system = new System(mock, new MockOutput());

        int result = system.stringCalculator();
        int expected = 20;

        assertTrue(mock.isInvoked());
        assertThat(result).isEqualTo(expected);
    }

}