package duck_simulator;

import duck_simulator.fly.MockFlyWithJetpack;
import duck_simulator.fly.MockFlyWithWings;
import duck_simulator.quack.MockQuack;
import duck_simulator.quack.MockQuacknt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import duck_simulator.duck.Duck;
import duck_simulator.duck.MallardDuck;
import output.MockOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuckTest {
    Duck mallard;
    MockOutput output;

    @BeforeEach
    public void setUp() {
        mallard = new MallardDuck();
        output = new MockOutput();
    }

    @Test
    public void testMallardDuckCanQuack() {
        mallard.setQuackBehavior(new MockQuack(output));
        mallard.setFlyBehavior(new MockFlyWithWings(output));

        mallard.performQuack();

        assertEquals("Quack", output.getPrintInput());
    }

    @Test
    public void testMallardDuckCanFly() {
        mallard.setFlyBehavior(new MockFlyWithWings(output));

        mallard.performFly();

        assertEquals("I'm flying!!", output.getPrintInput());
    }

    @Test
    public void testMallardDuckCanChangeFly() {
        mallard.setFlyBehavior(new MockFlyWithWings(output));

        mallard.performFly();

        assertEquals("I'm flying!!", output.getPrintInput());

        mallard.setFlyBehavior(new MockFlyWithJetpack(output));

        mallard.performFly();

        assertEquals("I'm flying with a MTF jetpack!!!!", output.getPrintInput());
    }

    @Test
    public void testMallardDuckCanChangeQuack() {
        mallard.setQuackBehavior(new MockQuack(output));

        mallard.performQuack();

        assertEquals("Quack", output.getPrintInput());

        mallard.setQuackBehavior(new MockQuacknt(output));

        mallard.performQuack();

        assertEquals("[SILENCE]", output.getPrintInput());
    }

}