package first_n_primes.primesprinters;

import first_n_primes.PrimePrinter;
import output.Output;

import java.util.ArrayList;
import java.util.List;

public class PrimePrinterBySieveOfEratosthenes extends PrimePrinter {
    private final List<Integer> primes;
    private final Output output;
    private boolean[] isPrime;
    private int limit;

    public PrimePrinterBySieveOfEratosthenes(int limit, Output output) {
        super(limit);
        this.output = output;
        primes = new ArrayList<>();
    }

    @Override
    public List<Integer> generatePrimes(int limit) {
        this.limit = limit;
        isPrime = new boolean[limit + 1];
        initializePrimeArray();
        sievePrimes();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    @Override
    protected void outputPrimes(List<Integer> primeNumbers) {
        output.print(primeNumbers.toString());
    }

    private void sievePrimes() {
        for (int factor = 2; factor * factor <= limit; factor++) {
            if (isPrime[factor]) {
                for (int j = factor * factor; j <= limit; j += factor) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private void initializePrimeArray() {
        for (int i = 2; i <= this.limit; i++) {
            isPrime[i] = true;
        }
    }

}