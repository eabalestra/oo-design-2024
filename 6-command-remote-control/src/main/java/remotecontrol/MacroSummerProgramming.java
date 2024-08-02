package remotecontrol;

import remotecontrol.remotewithundo.*;

public class MacroSummerProgramming {
    
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
        Light light = new Light("Office");
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        Computer computer = new Computer("Office");
        ComputerOnCommandUndo computerOn = new ComputerOnCommandUndo(computer);
        ComputerOffCommandUndo computerOff = new ComputerOffCommandUndo(computer);

        CeilingFan cellingFan = new CeilingFan("Office");
        CeilingFanMediumCommand cellingFanMedium = new CeilingFanMediumCommand(cellingFan);
        CeilingFanOffCommand cellingFanOff = new CeilingFanOffCommand(cellingFan);

        Command[] summerProgramming = {lightOn, computerOn, cellingFanMedium};
        Command[] summerProgrammingOff = {lightOff, computerOff, cellingFanOff};

        MacroCommand summerMacro = new MacroCommand(summerProgramming);
        MacroCommand summerMacroOff = new MacroCommand(summerProgrammingOff);

        remoteControl.setCommand(0, summerMacro, summerMacroOff);

        System.out.println(remoteControl.toString());
        System.out.println("--- Pushing Macro On---");
        remoteControl.onButtonWasPushed(0);
        System.out.println("--- Pushing Macro Off---");
        remoteControl.offButtonWasPushed(0);
        System.out.println("--- Pushing Macro Undo---");
        remoteControl.undoButtonWasPushed();

    }
}
