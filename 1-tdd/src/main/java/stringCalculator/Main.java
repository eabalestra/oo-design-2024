package stringCalculator;

import stringCalculator.input.ConsoleInput;
import stringCalculator.output.ConsoleOutput;

public class Main {

    // example for literal input \n: //[**][$$]\\n1**5$$8;2
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();

        System system = new System(input, output);
        String inputString;
        do {
            system.stringCalculator();
            inputString = input.getInput();
        } while (!inputString.isEmpty());
    }

}
