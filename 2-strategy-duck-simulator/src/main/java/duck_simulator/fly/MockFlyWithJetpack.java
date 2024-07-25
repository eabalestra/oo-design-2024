package duck_simulator.fly;

import output.Output;

public class MockFlyWithJetpack implements FlyBehavior{
    Output output;

    public MockFlyWithJetpack(Output output) {
        this.output = output;
    }

    @Override
    public void fly() {
        output.print("I'm flying with a MTF jetpack!!!!");
    }
}
