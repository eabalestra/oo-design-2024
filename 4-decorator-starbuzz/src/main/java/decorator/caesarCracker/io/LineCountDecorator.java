package decorator.caesarCracker.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LineCountDecorator extends FilterInputStream {
    private int lineCount = 0;

    public LineCountDecorator(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = super.read();
        if (c == '\n') {
            lineCount++;
        }
        return c;
    }

    public int getLineCount() {
        return lineCount;
    }
}