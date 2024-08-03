package decorator.caesarCracker.io;

import java.io.*;

public class CaesarEncryptTestDrive {
    public static void main(String[] args) throws IOException {
        int c;
        InputStream in = null;

        try {
            in = new LineCountDecorator(
                    new CaesarEncryptDecorator(new BufferedInputStream(
                            new FileInputStream("test_hello_world.txt")), 4));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
        System.out.println();

    }
}