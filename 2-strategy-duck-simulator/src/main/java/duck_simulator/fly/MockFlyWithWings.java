package duck_simulator.fly;

import output.Output;

public class MockFlyWithWings implements FlyBehavior {
    Output output;

    public MockFlyWithWings(Output output) {
        this.output = output;
    }

    @Override
    public void fly() {
        output.print("I'm flying!!");
    }
}
