import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remotecontrol.remotewithundo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoteControlWithUndoTest {
    Light light;
    Computer computer;
    CeilingFan ceilingFan;
    Command lightOn;
    Command lightOff;
    Command computerOn;
    Command computerOff;
    Command ceilingFanMedium;
    Command ceilingFanOff;
    RemoteControlWithUndo remoteControl;

    @BeforeEach
    public void setUp() {
        light = new Light("Office");
        lightOn = new LightOnCommand(light);
        lightOff = new LightOffCommand(light);

        computer = new Computer("Office");
        computerOn = new ComputerOnCommandUndo(computer);
        computerOff = new ComputerOffCommandUndo(computer);

        ceilingFan = new CeilingFan("Office");
        ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl = new RemoteControlWithUndo();
        remoteControl.setCommand(0, lightOn, lightOff);
        remoteControl.setCommand(1, computerOn, computerOff);
        remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
    }


    @Test
    public void testCommands() {
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);

        assertEquals(100, light.getLevel());
        assertEquals(Computer.ON, computer.getState());
        assertEquals(CeilingFan.MEDIUM, ceilingFan.getSpeed());
    }

    @Test
    public void testUndo() {
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);

        remoteControl.undoButtonWasPushed();

        assertEquals(100, light.getLevel());
        assertEquals(Computer.ON, computer.getState());
        assertEquals(CeilingFan.OFF, ceilingFan.getSpeed());
    }

}