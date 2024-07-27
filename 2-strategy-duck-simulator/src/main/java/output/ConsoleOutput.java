package output;

public class ConsoleOutput implements Output {
    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }
}