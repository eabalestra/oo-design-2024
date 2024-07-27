package first_n_primes;

import first_n_primes.primegenerator.PrimeGenBySieveOfEratosthenes;
import output.FileOutput;
import output.ConsoleOutput;

public class Main {
    public static void main(String[] args) {
        PrimePrinter consolePrinter = new PrimePrinter(10, new PrimeGenBySieveOfEratosthenes(), new ConsoleOutput());
        consolePrinter.print();

        PrimePrinter filePrinter = new PrimePrinter(10, new PrimeGenBySieveOfEratosthenes(), new FileOutput("primes.txt"));
        filePrinter.print();
    }
}