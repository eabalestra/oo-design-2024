package remotecontrol.remotewithundo;


public class ComputerOffCommandUndo implements Command {
    Computer computer;
    int prevState;

    public ComputerOffCommandUndo(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        prevState = computer.getState();
        computer.off();
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
