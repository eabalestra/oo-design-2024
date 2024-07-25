package duck_simulator.quack;

import output.Output;

public class MockQuack implements QuackBehavior {
    Output output;

    public MockQuack(Output output) {
        this.output = output;
    }

    @Override
    public void quack() {
        output.print("Quack");
    }
}
