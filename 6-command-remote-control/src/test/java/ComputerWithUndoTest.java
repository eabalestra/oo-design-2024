import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remotecontrol.remote.Command;
import remotecontrol.remote.ComputerOffCommand;
import remotecontrol.remote.ComputerOnCommand;
import remotecontrol.remotewithundo.Computer;
import remotecontrol.remotewithundo.ComputerOffCommandUndo;
import remotecontrol.remotewithundo.ComputerOnCommandUndo;
import remotecontrol.remotewithundo.ComputerSuspendCommandUndo;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerWithUndoTest {
    Computer computer;
    remotecontrol.remotewithundo.Command computerOnCommand;
    remotecontrol.remotewithundo.Command computerOffCommand;
    remotecontrol.remotewithundo.Command computerSuspendCommand;

    @BeforeEach
    public void setUp() {
        computer = new Computer("Office");
        computerOnCommand = new ComputerOnCommandUndo(computer);
        computerOffCommand = new ComputerOffCommandUndo(computer);
        computerSuspendCommand = new ComputerSuspendCommandUndo(computer);
    }

    @Test
    public void testSimpleUndo() {
        computerOnCommand.execute();
        computerSuspendCommand.execute();
        computerSuspendCommand.undo();
        assertEquals(Computer.ON, computer.getState());
    }

    @Test
    public void testComplexUndo() {
        computerOnCommand.execute();
        computerSuspendCommand.execute();
        computerOffCommand.execute();
        computerOnCommand.execute();
        computerOffCommand.execute();
        computerOnCommand.execute();
        computerSuspendCommand.execute();
        computerOffCommand.execute();

        computerOffCommand.undo();
        assertEquals(Computer.SUSPENDED, computer.getState());
    }

}
