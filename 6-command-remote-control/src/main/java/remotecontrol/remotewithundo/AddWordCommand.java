package remotecontrol.remotewithundo;

public class AddWordCommand implements Command {
    Buffer buffer;
    String word;
    int linePosition;

    public AddWordCommand(Buffer buffer, String word, int linePosition) {
        this.buffer = buffer;
        this.word = word;
        this.linePosition = linePosition;
    }

    public void execute() {
        String line = buffer.text.get(linePosition);
        buffer.text.remove(linePosition);

        line = line + " "+ word;
        buffer.text.add(linePosition, line);
    }

    public void undo() {
        String line = buffer.text.get(linePosition);
        buffer.text.remove(linePosition);

        line = line.substring(0, line.length() - word.length() - 1);  // -1 for remove the space
        buffer.text.add(linePosition, line);
    }
}
