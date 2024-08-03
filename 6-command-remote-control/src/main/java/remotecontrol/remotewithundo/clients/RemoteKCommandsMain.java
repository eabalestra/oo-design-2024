package remotecontrol.remotewithundo.clients;

import remotecontrol.remotewithundo.*;

public class RemoteKCommandsMain {
    public static void main(String[] args) {
        RemoteControlKCommands remoteControl = new RemoteControlKCommands();

        Light light = new Light("Living Room");
        Computer computer = new Computer("Office");
        CeilingFan ceilingFan = new CeilingFan("Bedroom");

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        ComputerOnCommandUndo computerOn = new ComputerOnCommandUndo(computer);
        ComputerOffCommandUndo computerOff = new ComputerOffCommandUndo(computer);
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, lightOn, lightOff);
        remoteControl.setCommand(1, computerOn, computerOff);
        remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);

        remoteControl.undoKCommands(2);
        remoteControl.redoKCommands(2);
    }
}