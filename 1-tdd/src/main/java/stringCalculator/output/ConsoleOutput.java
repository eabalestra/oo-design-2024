package stringCalculator.output;

public class ConsoleOutput implements Output{
    @Override
    public void print(int toPrint) {
        System.out.println(toPrint);
    }

}
