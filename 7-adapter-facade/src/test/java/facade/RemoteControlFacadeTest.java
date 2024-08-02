package facade;

import facade.remotecontrol.remote.*;
import facade.remotecontrol.remoteFacade.RemoteControlFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RemoteControlFacadeTest {
    CeilingFan ceilingFan;
    Computer computer;
    Light light;
    GarageDoor garageDoor;
    RemoteControlFacade remoteControlFacade;

    @BeforeEach
    public void setUp() {
        ceilingFan = new CeilingFan("Living Room");
        computer = new Computer("Living Room");
        light = new Light("Living Room");
        garageDoor = new GarageDoor("Living Room");
        remoteControlFacade = new RemoteControlFacade(ceilingFan, computer, light, garageDoor);
    }

    @Test
    public void testExitHome() {
        remoteControlFacade.exitHome();

        assertEquals(0, ceilingFan.getSpeed());
        assertFalse(computer.isOn());
        assertEquals(0, light.getLevel());
        assertEquals(1, garageDoor.getLevel());
    }

    @Test
    public void testReturnHome() {
        remoteControlFacade.returnHome();

        assertEquals(2, ceilingFan.getSpeed());
        assert (computer.isOn());
        assertEquals(100, light.getLevel());
        assertEquals(0, garageDoor.getLevel());
    }
}
