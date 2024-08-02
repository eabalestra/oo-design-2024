package remotecontrol.remotewithundo;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    List<String> text;

    public Buffer() {
        this.text = new ArrayList<>();
    }

    public List<String> getText() {
        return text;
    }
}
