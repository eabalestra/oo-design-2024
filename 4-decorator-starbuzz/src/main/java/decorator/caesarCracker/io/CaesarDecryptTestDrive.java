package decorator.caesarCracker.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CaesarDecryptTestDrive {
    public static void main(String[] args) {
        int c;
        InputStream in = null;

        try {
            in = new LineCountDecorator(
                    new CaesarDecryptDecorator(
                            new BufferedInputStream(
                                    new FileInputStream("test_encrypted_hello_world.txt")), 4));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
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
        System.out.println();
    }
}