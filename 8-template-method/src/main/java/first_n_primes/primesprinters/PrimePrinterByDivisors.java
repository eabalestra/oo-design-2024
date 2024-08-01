package first_n_primes.primesprinters;

import first_n_primes.PrimePrinter;
import output.Output;

import java.util.ArrayList;
import java.util.List;

public class PrimePrinterByDivisors extends PrimePrinter {
    List<Integer> primeNumbers;
    Output output;

    public PrimePrinterByDivisors(int limit, Output output) {
        super(limit);
        this.output = output;
        primeNumbers = new ArrayList<>();
    }

    public List<Integer> generatePrimes(int limit) {
        for (int number = 2; number <= limit ; number++) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }
        return primeNumbers;
    }

    @Override
    protected void outputPrimes(List<Integer> primeNumbers) {
        output.print(primeNumbers.toString());
    }

    private boolean isPrime(int number) {
        List<Integer> divisors = getCantOfDivisors(number);
        return divisors.size() == 2;
    }

    private List<Integer> getCantOfDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }
}
