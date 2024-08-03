package remotecontrol.remotewithundo;

import java.util.ArrayList;
import java.util.List;

public class PrintBufferCommand implements Command {
    Buffer buffer;
    List<String> toPrint;

    public PrintBufferCommand(Buffer buffer) {
        this.buffer = buffer;
        this.toPrint = new ArrayList<>();
    }

    public void execute() {
        System.out.println("-------------------Printing buffer-------------------");
        for (int i = 0; i < buffer.text.size(); i++) {
            String input = buffer.text.get(i);
            System.out.println(input);
            toPrint.add(input);
        }
    }

    public void undo() {
        System.out.println("Done it's done.");
    }

    public List<String> getToPrint() {
        return toPrint;
    }
}
