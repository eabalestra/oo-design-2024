package remotecontrol.remote;

public class ComputerOnCommand implements Command{
    Computer computer;

    public ComputerOnCommand(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        computer.on();
    }
}
