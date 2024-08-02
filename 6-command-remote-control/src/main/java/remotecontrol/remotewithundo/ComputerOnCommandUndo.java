package remotecontrol.remotewithundo;


public class ComputerOnCommandUndo implements Command {
    Computer computer;
    int prevState;

    public ComputerOnCommandUndo(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        prevState = computer.getState();
        computer.on();
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
