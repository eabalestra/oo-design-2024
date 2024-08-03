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
    String input = "Test input";

    @BeforeEach
    public void setUp() {
        buffer = new Buffer();
        remoteControl = new RemoteControlWithUndo();
        addNewLine = new AddNewLineCommand(buffer, new Scanner(input));
        removeLine = new RemoveLineCommand(buffer);
        printBuffer = new PrintBufferCommand(buffer);
    }

    @Test
    public void testAddLine() {
        addNewLine.execute();
        assertEquals(1, buffer.getText().size());
        assertEquals(input, buffer.getText().get(0));
    }

    @Test
    public void testUndoAddLine() {
        addNewLine.execute();
        addNewLine.undo();
        assertTrue(buffer.getText().isEmpty());
    }

    @Test
    public void testRemoveLine() {
        addNewLine.execute();
        removeLine.execute();
        assertTrue(buffer.getText().isEmpty());
    }

    @Test
    public void testUndoRemoveLine() {
        addNewLine.execute();
        removeLine.execute();
        removeLine.undo();
        assertEquals(1, buffer.getText().size());
        assertEquals(input, buffer.getText().get(0));
    }

    @Test
    public void testPrintBuffer() {
        addNewLine.execute();
        printBuffer.execute();
        List<String> toPrint = ((PrintBufferCommand) printBuffer).getToPrint();
        assertEquals(1, toPrint.size());
        assertEquals(input, toPrint.get(0));
    }

    @Test
    public void TestAddWordCommand() {
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
