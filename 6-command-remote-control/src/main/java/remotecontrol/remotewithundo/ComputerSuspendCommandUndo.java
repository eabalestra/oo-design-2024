package remotecontrol.remotewithundo;

public class ComputerSuspendCommandUndo implements Command {
    Computer computer;
    int prevState;

    public ComputerSuspendCommandUndo(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        prevState = computer.getState();
        computer.suspend();
    }

    public void undo() {
        if (prevState == Computer.OFF) {
            computer.off();
        } else if (prevState == Computer.ON) {
            computer.on();
        } else if (prevState == Computer.SUSPENDED) {
            computer.suspend();
        }
    }
}
