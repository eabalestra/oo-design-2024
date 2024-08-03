package decorator.caesarCracker.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LineCounterTestDrive {
    public static void main(String[] args) {
        InputStream in = null;

        try {
            in = new LineCountDecorator(
                    new CaesarDecryptDecorator(
                            new BufferedInputStream(
                                    new FileInputStream("test.txt")), 4));
            while (in.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Number of lines: " + ((LineCountDecorator) in).getLineCount());
        System.out.println();
    }
}