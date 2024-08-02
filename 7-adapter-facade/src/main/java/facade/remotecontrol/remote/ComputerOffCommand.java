package facade.remotecontrol.remote;

public class ComputerOffCommand implements Command{
    Computer computer;

    public ComputerOffCommand(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        computer.off();
    }
}
