package remotecontrol.remotewithundo;

public class RemoveLineCommand implements Command {
    Buffer buffer;
    String removedLine;

    public RemoveLineCommand(Buffer buffer) {
        this.buffer = buffer;
    }

    public void execute() {
        int lastLinePosition = buffer.text.size() - 1;
        removedLine = buffer.text.remove(lastLinePosition);
    }

    public void undo() {
        buffer.text.add(removedLine);
    }
}
