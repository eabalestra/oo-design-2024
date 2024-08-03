package decorator.caesarCracker;


import decorator.caesarCracker.io.*;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherDecoratorTest {
    private InputStream in;

    @Test
    public void testSimpleEncryption() throws IOException {
        in = new BufferedInputStream(
                new FileInputStream("test_hello_world.txt"));

        in = new CaesarEncryptDecorator(in, 4);
        String result = getString(in);

        String expectedEncode = "lspe qyrhs";
        assertEquals(expectedEncode, result);
    }

    @Test
    public void testSimpleDecrypt() throws IOException {
        in = new BufferedInputStream(
                new FileInputStream(
                        "test_encrypted_hello_world.txt"
                )
        );

        in = new CaesarDecryptDecorator(in, 4);
        String result = getString(in);

        String expectedDecode = "hola mundo";
        assertEquals(expectedDecode, result);
    }

    @Test
    public void testLineCountDecorator() throws IOException {
        in = new BufferedInputStream(
                new FileInputStream(
                        "test.txt"
                )
        );
        LineCountDecorator lineCounter= new LineCountDecorator(in);

        while (lineCounter.read() != -1) {}

        assertEquals(1, lineCounter.getLineCount());
    }

    @Test
    public void testEncryptedAndOriginalFilesHaveSameLineCount() throws IOException {
        InputStream originalIn = new BufferedInputStream(new FileInputStream("test.txt"));
        InputStream encryptedIn = new CaesarEncryptDecorator(new BufferedInputStream(new FileInputStream("test.txt")), 4);

        LineCountDecorator originalCounter = new LineCountDecorator(originalIn);
        LineCountDecorator encryptedCounter = new LineCountDecorator(encryptedIn);

        while (originalCounter.read() != -1) {}
        while (encryptedCounter.read() != -1) {}

        assertEquals(originalCounter.getLineCount(), encryptedCounter.getLineCount());
    }

    private static String getString(InputStream cesarDecorator) throws IOException {
        StringBuilder result = new StringBuilder();
        int c;
        while ((c = cesarDecorator.read()) != -1) {
            result.append((char) c);
        }
        return result.toString();
    }
}
