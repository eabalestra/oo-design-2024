package remotecontrol.remotewithundo.clients;

import remotecontrol.remotewithundo.*;
import remotecontrol.remotewithundo.RemoteControlWithUndo;

import java.util.Scanner;


public class BufferTextTestDriven {
    public static void main(String[] args) {

        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Buffer buffer = new Buffer();

        Scanner scanner = new Scanner(System.in);
        AddNewLineCommand addNewLine = new AddNewLineCommand(buffer, scanner);
        Command removeLine = new RemoveLineCommand(buffer);
        Command printBuffer = new PrintBufferCommand(buffer);

        remoteControl.setCommand(0, addNewLine, removeLine);
        remoteControl.setCommand(1, printBuffer, new NoCommand());

        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(1);

        String word = "new";
        int linePosition = 0;
        Command addWordCommand = new AddWordCommand(buffer, word, linePosition);
        remoteControl.setCommand(2, addWordCommand, new NoCommand());
        remoteControl.onButtonWasPushed(2);
        remoteControl.onButtonWasPushed(1);
    }
}
