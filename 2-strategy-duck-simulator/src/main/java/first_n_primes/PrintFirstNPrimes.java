package first_n_primes;

import first_n_primes.primegenerator.PrimeGenByDivisors;
import first_n_primes.primegenerator.PrimeGenBySieveOfEratosthenes;
import output.FileOutput;
import output.ConsoleOutput;

public class PrintFirstNPrimes {
    public static void main(String[] args) {
        int limit = 20;
        PrimePrinter consolePrinter = new PrimePrinter(limit, new PrimeGenBySieveOfEratosthenes(), new ConsoleOutput());
        System.out.println("Printing first " + limit + " prime numbers, using the Sieve of Eratosthenes algorithm:");
        consolePrinter.print();

        PrimePrinter filePrinter = new PrimePrinter(limit, new PrimeGenByDivisors(), new FileOutput("primes.txt"));
        System.out.println("Saving first " + limit + " prime numbers to a file, using the Divisors algorithm...");
        filePrinter.print();
    }
}