import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import remotecontrol.remote.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoteControlTest {
    Light light;
    CeilingFan ceilingFan;
    Command lightOn;
    Command lightOff;
    Command ceilingFanMedium;
    Command ceilingFanOff;
    RemoteControl remoteControl;

    @BeforeEach
    public void setUp() {
        light = new Light("Office");
        lightOn = new LightOnCommand(light);
        lightOff = new LightOffCommand(light);

        ceilingFan = new CeilingFan("Office");
        ceilingFanMedium = new CeilingFanOnCommand(ceilingFan);
        ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl = new RemoteControl();
        remoteControl.setCommand(0, lightOn, lightOff);
        remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);
    }

    @Test
    public void testCommands() {
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);

        assertEquals(100, light.getLevel());
        assertEquals(CeilingFan.HIGH, ceilingFan.getSpeed());
    }
}