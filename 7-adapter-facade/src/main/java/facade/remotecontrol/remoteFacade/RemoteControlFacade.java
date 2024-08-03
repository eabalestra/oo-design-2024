package facade.remotecontrol.remoteFacade;

import facade.remotecontrol.remote.*;

public class RemoteControlFacade {
    RemoteControl remoteControl;

    public RemoteControlFacade(CeilingFan ceilingFan, Computer computer, Light light, GarageDoor garageDoor) {
        remoteControl = new RemoteControl();
        LightOnCommand lightOn =
                new LightOnCommand(light);
        LightOffCommand lightOff =
                new LightOffCommand(light);

        ComputerOnCommand computerOn =
                new ComputerOnCommand(computer);
        ComputerOffCommand computerOff =
                new ComputerOffCommand(computer);

        CeilingFanOnCommand ceilingFanOn =
                new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff =
                new CeilingFanOffCommand(ceilingFan);

        GarageDoorUpCommand garageDoorUp =
                new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown =
                new GarageDoorDownCommand(garageDoor);

        remoteControl.setCommand(0, lightOn, lightOff);
        remoteControl.setCommand(1, computerOn, computerOff);
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
    }

    public void exitHome() {
        System.out.println("----------Exiting home----------");
        remoteControl.offButtonWasPushed(0);
        remoteControl.offButtonWasPushed(1);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
    }

    public void returnHome() {
        System.out.println("----------Returning home----------");
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(3);
    }
}
