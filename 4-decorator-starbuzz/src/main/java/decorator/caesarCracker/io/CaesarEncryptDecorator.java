package decorator.caesarCracker.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CaesarEncryptDecorator extends FilterInputStream {
    private final int shiftKey;

    public CaesarEncryptDecorator(InputStream in, int shiftKey) {
        super(in);
        this.shiftKey = shiftKey;
    }

    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : shiftCharacter((char) c));
    }

    public char shiftCharacter(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) (((c - base + shiftKey) % 26) + base);
        } else {
            return c;
        }
    }


}
