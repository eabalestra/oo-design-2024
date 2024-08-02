package facade.remotecontrol.remoteFacade;

import facade.remotecontrol.remote.*;

public class RemoteControlFacade {
    CeilingFan ceilingFan;
    Computer computer;
    Light light;
    GarageDoor garageDoor;

    public RemoteControlFacade(CeilingFan ceilingFan, Computer computer, Light light, GarageDoor garageDoor) {
        this.ceilingFan = ceilingFan;
        this.computer = computer;
        this.light = light;
        this.garageDoor = garageDoor;
    }

    public void exitHome() {
        System.out.println("----------Exiting home----------");
        ceilingFan.off();
        computer.off();
        light.off();
        garageDoor.up();
    }

    public void returnHome() {
        System.out.println("----------Returning home----------");
        ceilingFan.high();
        computer.on();
        light.on();
        garageDoor.down();
    }
}
