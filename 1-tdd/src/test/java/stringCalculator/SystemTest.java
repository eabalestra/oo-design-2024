package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringCalculator.input.Input;
import stringCalculator.output.Output;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SystemTest {
    private System system;
    private Input mockInput;
    private Output mockOutput;

    @BeforeEach
    void setUp() {
        mockInput = mock(Input.class);
        mockOutput = mock(Output.class);

        system = new System(mockInput, mockOutput);
    }

    @Test
    void stringCalculatorReturnsCorrectResultWhenValidText() {
        when(mockInput.input()).thenReturn("1,2,3");

        int result = system.stringCalculator();
        assertEquals(6, result);
        verify(mockOutput).print(6);
    }

    @Test
    void stringCalculatorReturnsCorrectResultWhenCustomDelimiters() {
        when(mockInput.input()).thenReturn("//[xyzw][///][m]\n-10xyzw1m7///3");

        int result = system.stringCalculator();

        assertEquals(1, result);
        verify(mockOutput).print(1);
    }

    @Test
    void stringCalculatorThrowsExceptionWhenInvalidInput() {
        when(mockInput.input()).thenReturn("//[¿¿][*][_]\n2¿¿5-5,11*31_11");

        assertThrows(IllegalArgumentException.class, () -> system.stringCalculator());
    }

}