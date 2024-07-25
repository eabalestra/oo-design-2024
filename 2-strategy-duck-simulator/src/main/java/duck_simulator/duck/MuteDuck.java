package duck_simulator.duck;

import duck_simulator.fly.FlyWithWings;
import duck_simulator.quack.Quacknt;

public class MuteDuck extends Duck {

    public MuteDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quacknt();
    }

    @Override
    void display() {
        System.out.println("I'm a Cairina muschata not mute Duck!");
    }
}
