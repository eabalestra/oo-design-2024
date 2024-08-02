package remotecontrol.remotewithundo;

public class Computer {
    public static final int OFF = 0;
    public static final int ON = 1;
    public static final int SUSPENDED = 2;
    String location = "";
    private int state = 0;

    public Computer(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " computer is on");
        state = ON;
    }

    public void off() {
        System.out.println(location + " computer is off");
        state = OFF;
    }

    public void suspend() {
        System.out.println(location + " computer is suspended");
        state = SUSPENDED;
    }

    public int getState() {
        return state;
    }

}
