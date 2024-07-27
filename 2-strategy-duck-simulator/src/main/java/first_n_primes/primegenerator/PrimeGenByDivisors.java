package first_n_primes.primegenerator;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenByDivisors implements PrimeGenerator {
    private final List<Integer> primes;

    public PrimeGenByDivisors() {
        primes = new ArrayList<>();
    }

    @Override
    public List<Integer> getPrimes(int limit) {
        for (int number = 2; number <= limit ; number++) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
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
