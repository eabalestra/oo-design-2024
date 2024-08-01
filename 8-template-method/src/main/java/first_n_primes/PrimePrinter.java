package first_n_primes;

import java.util.List;

public abstract class PrimePrinter {
    int limit;

    public PrimePrinter(int limit) {
        this.limit = limit;
    }

    public void print() {
        List<Integer> primeNumbers = generatePrimes(limit);
        outputPrimes(primeNumbers);
    }

    protected abstract List<Integer> generatePrimes(int limit);

    protected abstract void outputPrimes(List<Integer> primeNumbers);

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
