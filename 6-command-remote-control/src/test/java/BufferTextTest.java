import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remotecontrol.remotewithundo.Command;
import remotecontrol.remotewithundo.*;
import remotecontrol.remotewithundo.RemoteControlWithUndo;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class BufferTextTest {
    RemoteControlWithUndo remoteControl;
    Buffer buffer;
    AddNewLineCommand addNewLine;
    Command removeLine;
    Command printBuffer;

    @BeforeEach
    public void setUp() {
        buffer = new Buffer();
        remoteControl = new RemoteControlWithUndo();
        addNewLine = new AddNewLineCommand(buffer);
        removeLine = new RemoveLineCommand(buffer);
        printBuffer = new PrintBufferCommand(buffer);
    }

    @Test
    public void testAddLine() {
        String input = "Test input";
        Scanner scanner = new Scanner(input);
        addNewLine.setScanner(scanner);

        addNewLine.execute();

        assertEquals(1, buffer.getText().size());
        assertEquals(input, buffer.getText().get(0));
    }

    @Test
    public void testUndoAddLine() {
        String input = "Test input";
        Scanner scanner = new Scanner(input);
        addNewLine.setScanner(scanner);

        addNewLine.execute();
        addNewLine.undo();

        assertTrue(buffer.getText().isEmpty());
    }

    @Test
    public void testRemoveLine() {
        String input = "Test input";
        Scanner scanner = new Scanner(input);
        addNewLine.setScanner(scanner);

        addNewLine.execute();
        removeLine.execute();

        assertTrue(buffer.getText().isEmpty());
    }

    @Test
    public void testUndoRemoveLine() {
        String input = "Test input";
        Scanner scanner = new Scanner(input);
        addNewLine.setScanner(scanner);

        addNewLine.execute();
        removeLine.execute();
        removeLine.undo();

        assertEquals(1, buffer.getText().size());
        assertEquals(input, buffer.getText().get(0));
    }

    @Test
    public void testPrintBuffer() {
        String input1 = "Test input line 1";
        Scanner scanner = new Scanner(input1);
        addNewLine.setScanner(scanner);
        addNewLine.execute();
        String input2 = "Test input line 2";
        scanner = new Scanner(input2);
        addNewLine.setScanner(scanner);
        addNewLine.execute();

        printBuffer.execute();

        List<String> toPrint = ((PrintBufferCommand) printBuffer).getToPrint();
        assertEquals(2, toPrint.size());
        assertEquals(input1, toPrint.get(0));
        assertEquals(input2, toPrint.get(1));
    }

    @Test
    public void TestAddWordCommand() {
        String input = "Boca";
        Scanner scanner = new Scanner(input);
        addNewLine.setScanner(scanner);
        addNewLine.execute();

        String word = "Juniors";
        int linePosition = 0;
        AddWordCommand addWord = new AddWordCommand(buffer, word, linePosition);
        addWord.execute();

        String expectedText = input + " " + word;
        assertEquals(1, buffer.getText().size());
        assertEquals(expectedText, buffer.getText().get(0));
    }

    @Test
    public void TestUndoAddWordCommand() {
        String input = "Boca";
        Scanner scanner = new Scanner(input);
        addNewLine.setScanner(scanner);
        addNewLine.execute();

        String word = "Juniors";
        int position = 0;
        AddWordCommand addWord = new AddWordCommand(buffer, word, position);
        addWord.execute();
        addWord.undo();

        assertEquals(1, buffer.getText().size());
        assertEquals(input, buffer.getText().get(0));
    }


}