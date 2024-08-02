package remotecontrol.remote;

public class Computer {
    String location = "";
    private boolean isOn = false;

    public Computer(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " computer is on");
        isOn = true;
    }

    public void off() {
        System.out.println(location + " computer is off");
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }
}
