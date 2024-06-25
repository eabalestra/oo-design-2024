package fizzbuzz;

import output.Output;

import java.util.List;

public class PrintFizzBuzz {

    final Output output;

    public PrintFizzBuzz(Output output) {
        this.output = output;
    }

    public void printFizzBuzz(List<Integer> numbers) {
        List<String> res = FizzBuzzSequence.fizzBuzzSequence(numbers);
        String toPrint = String.join(",", res);
        output.print(toPrint);
    }

}
