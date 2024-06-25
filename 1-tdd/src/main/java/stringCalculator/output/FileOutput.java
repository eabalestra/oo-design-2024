package stringCalculator.output;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutput implements Output {

    @Override
    public void print(int toPrint) {
        try (PrintWriter out = new PrintWriter(new FileWriter(String.valueOf(toPrint)))) {
            out.println(toPrint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
