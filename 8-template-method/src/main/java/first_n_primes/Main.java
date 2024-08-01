package first_n_primes;

import first_n_primes.primesprinters.PrimePrinterByDivisors;
import first_n_primes.primesprinters.PrimePrinterBySieveOfEratosthenes;
import output.FileOutput;
import output.ConsoleOutput;

public class Main {
    public static void main(String[] args) {
        PrimePrinter consolePrinter = new PrimePrinterByDivisors(10, new ConsoleOutput());
        consolePrinter.print();

        PrimePrinter filePrinter = new PrimePrinterBySieveOfEratosthenes(10, new FileOutput("primes.txt"));
        filePrinter.print();
    }
}