package remotecontrol.remotewithundo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoteControlKCommands {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;
    Stack<Command> executedCommands;

    public RemoteControlKCommands() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        executedCommands = new Stack<Command>();

        Command noCommand = new NoCommand();
        for(int i=0;i<7;i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void undoKCommands(int k) {
        List<Command> undoesCommands = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!executedCommands.isEmpty()) {
                Command command = executedCommands.pop();
                command.undo();
                undoesCommands.add(command);
            }
        }
        for (Command command : undoesCommands) {
            executedCommands.push(command);
        }
    }

    public void redoKCommands(int k) {
        List<Command> redoesCommands = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!executedCommands.isEmpty()) {
                Command command = executedCommands.pop();
                command.execute();
                redoesCommands.add(command);
            }
        }
        for (Command command : redoesCommands) {
            executedCommands.push(command);
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
        executedCommands.push(onCommands[slot]);
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
        executedCommands.push(offCommands[slot]);
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
        return stringBuff.toString();
    }
}
