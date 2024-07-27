package first_n_primes.primegenerator;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenBySieveOfEratosthenes implements PrimeGenerator {
    private int limit;
    private boolean[] isPrime;
    private List<Integer> primes;

    public PrimeGenBySieveOfEratosthenes() {
        primes = new ArrayList<>();
    }

    @Override
    public List<Integer> getPrimes(int limit) {
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