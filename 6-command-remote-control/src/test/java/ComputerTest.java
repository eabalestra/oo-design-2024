import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remotecontrol.remote.Command;
import remotecontrol.remote.Computer;
import remotecontrol.remote.ComputerOffCommand;
import remotecontrol.remote.ComputerOnCommand;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {

    Computer computer;
    Command computerOnCommand;
    Command computerOffCommand;

    @BeforeEach
    public void setUp() {
        computer = new Computer("Office");
        computerOnCommand = new ComputerOnCommand(computer);
        computerOffCommand = new ComputerOffCommand(computer);
    }

    @Test
    public void testComputerOn() {
        computerOnCommand.execute();
        assertTrue(computer.isOn());
    }

    @Test
    public void testComputerOff() {
        computerOnCommand.execute();
        computerOffCommand.execute();
        assertFalse(computer.isOn());
    }
}
