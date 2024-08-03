package remotecontrol.remotewithundo;

import java.util.Scanner;

public class AddNewLineCommand implements Command {
    Buffer buffer;
    Scanner scanner;

    public AddNewLineCommand(Buffer buffer) {
        this.buffer = buffer;
        this.scanner = new Scanner(System.in); // Default to System.in
    }

    public AddNewLineCommand(Buffer buffer, Scanner scanner) {
        this.buffer = buffer;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("Enter text to be added to the buffer:");
        String input = scanner.nextLine();
        buffer.text.add(input);
    }

    public void undo() {
        int lastLinePosition = buffer.text.size() - 1;
        buffer.text.remove(lastLinePosition);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}