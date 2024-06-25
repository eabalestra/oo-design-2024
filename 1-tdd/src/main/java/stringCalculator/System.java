package stringCalculator;

import stringCalculator.delimiters.Delimiters;
import stringCalculator.input.Input;
import stringCalculator.output.Output;

import static stringCalculator.StringHandler.getNumbersSubString;
import static stringCalculator.delimiters.DelimitersFactory.generateDelimiters;

public class System {
    private final Output output;
    private final Input input;
    private final Calculator calculator;

    public System(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.calculator = new Calculator();
    }

    public int stringCalculator(String text) {
        Delimiters delimiters = generateDelimiters(text);
        calculator.setDelimiters(delimiters);
        String numbersToCalculate = getNumbersSubString(text);
        int result = calculator.calculate(numbersToCalculate);
        output.print(result);
        return result;
    }

    public int stringCalculator() {
        return stringCalculator(input.input());
    }

}
