package duck_simulator.quack;

import output.Output;

public class MockQuacknt implements QuackBehavior {
    Output output;

    public MockQuacknt(Output output) {
        this.output = output;
    }
    @Override
    public void quack() {
        output.print("[SILENCE]");
    }
}
