package output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output {
    private final String filePath;

    public FileOutput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void print(String toPrint) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(toPrint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}