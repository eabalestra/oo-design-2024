package first_n_primes;

import first_n_primes.primegenerator.PrimeGenByDivisors;
import first_n_primes.primegenerator.PrimeGenBySieveOfEratosthenes;
import first_n_primes.primegenerator.PrimeGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import output.MockOutput;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PrimePrinterTest {
    MockOutput output;
    PrimeGenerator primeGenerator;
    PrimePrinter primePrinter;

    @BeforeEach
    void setUp() {
        output = new MockOutput();
    }

    @ParameterizedTest
    @MethodSource("primeGeneratorProvider")
    void testPrimePrinter(int limit, PrimeGenerator primeGenerator, String expected) {
        this.primeGenerator = primeGenerator;
        primePrinter = new PrimePrinter(limit, primeGenerator, output);

        primePrinter.print();

        assertEquals(expected, output.getPrintInput());
    }

    private static Stream<Arguments> primeGeneratorProvider() {
        return Stream.of(
                Arguments.of(3, new PrimeGenByDivisors(), "[2, 3]"),
                Arguments.of(10, new PrimeGenByDivisors(), "[2, 3, 5, 7]"),
                Arguments.of(15, new PrimeGenByDivisors(), "[2, 3, 5, 7, 11, 13]"),
                Arguments.of(3, new PrimeGenBySieveOfEratosthenes(), "[2, 3]"),
                Arguments.of(10, new PrimeGenBySieveOfEratosthenes(), "[2, 3, 5, 7]"),
                Arguments.of(15, new PrimeGenBySieveOfEratosthenes(), "[2, 3, 5, 7, 11, 13]")
        );
    }
}