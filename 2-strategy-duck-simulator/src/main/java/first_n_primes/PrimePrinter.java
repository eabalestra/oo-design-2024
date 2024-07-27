package first_n_primes;

import first_n_primes.primegenerator.PrimeGenerator;
import output.Output;

import java.util.List;

public class PrimePrinter {
    PrimeGenerator primeGenerator;
    Output output;
    int limit;

    public PrimePrinter(int limit, PrimeGenerator primeGenerator, Output output) {
        this.limit = limit;
        this.primeGenerator = primeGenerator;
        this.output = output;
    }

    public void print() {
        List<Integer> primeNumbers = primeGenerator.getPrimes(limit);
        output.print(primeNumbers.toString());
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public void setPrimeGenerator(PrimeGenerator primeGenerator) {
        this.primeGenerator = primeGenerator;
    }
}
