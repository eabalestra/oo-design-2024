package stringCalculator.input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    String input;
    @Override
    public String getInput() {
        return input;
    }

    public String input() {
        System.out.println("Enter a string to calculate or press intro to exit:");
        Scanner sc = new Scanner(System.in);
        this.input = sc.nextLine().replace("\\\\n", "\n");
        return input;
    }
}
