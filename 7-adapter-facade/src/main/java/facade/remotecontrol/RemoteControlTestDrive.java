package facade.remotecontrol;

import facade.remotecontrol.remote.*;
import facade.remotecontrol.remoteFacade.RemoteControlFacade;

public class RemoteControlTestDrive {
    public static void main(String[] args) {
        Light light = new Light("Living Room");
        Computer computer = new Computer("Living Room");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("Garage");

        RemoteControlFacade remoteControl = new RemoteControlFacade(ceilingFan, computer, light, garageDoor);

        remoteControl.exitHome();
        remoteControl.returnHome();
    }
}
