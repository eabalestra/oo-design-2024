package first_n_primes;

import first_n_primes.primesprinters.PrimePrinterByDivisors;
import first_n_primes.primesprinters.PrimePrinterBySieveOfEratosthenes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import output.MockOutput;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimePrinterTest {
    MockOutput output;
    PrimePrinter primePrinter;

    @BeforeEach
    void setUp() {
        output = new MockOutput();
    }

    @ParameterizedTest
    @MethodSource("primesProvider")
    void testPrimePrinterGenByDivisors(int limit, String expected) {
        primePrinter = new PrimePrinterByDivisors(limit, output);

        primePrinter.print();

        assertEquals(expected, output.getPrintInput());
    }

    @ParameterizedTest
    @MethodSource("primesProvider")
    void testPrimesGenBySieveOfEratosthenes(int limit, String expected) {
        primePrinter = new PrimePrinterBySieveOfEratosthenes(limit, output);

        primePrinter.print();

        assertEquals(expected, output.getPrintInput());
    }

    private static Stream<Arguments> primesProvider() {
        return Stream.of(
                Arguments.of(3, "[2, 3]"),
                Arguments.of(10, "[2, 3, 5, 7]"),
                Arguments.of(15, "[2, 3, 5, 7, 11, 13]"),
                Arguments.of(20, "[2, 3, 5, 7, 11, 13, 17, 19]"),
                Arguments.of(25, "[2, 3, 5, 7, 11, 13, 17, 19, 23]")
        );
    }

}