package facade.remotecontrol.remote;

public class GarageDoor {
	String location;
	int level;


	public GarageDoor(String location) {
		this.location = location;
	}

	public void up() {
		System.out.println(location + " garage Door is Up");
		level = 1;
	}

	public void down() {
		System.out.println(location + " garage Door is Down");
		level = 0;
	}

	public void stop() {
		System.out.println(location + " garage Door is Stopped");
	}

	public void lightOn() {
		System.out.println(location + " garage light is on");
	}

	public void lightOff() {
		System.out.println(location + " garage light is off");
	}

	public int getLevel() {
		return level;
	}
}
