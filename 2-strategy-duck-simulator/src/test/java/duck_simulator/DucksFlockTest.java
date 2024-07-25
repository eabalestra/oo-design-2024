package duck_simulator;

import duck_simulator.duck.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DucksFlockTest {
    DucksFlock ducksFlock;

    @BeforeEach
    public void setUp() {
        List<Duck> ducks = List.of(new MallardDuck(), new ModelDuck());
        ducksFlock = new DucksFlock(ducks);
    }

    @Test
    public void testAddDuckToDucksFlock() {
        Duck muteDuck = new MuteDuck();

        ducksFlock.add(muteDuck);

        assertEquals(muteDuck, ducksFlock.getDuck(2));
    }

    @Test
    public void testDuckFlocksQuack() {
        ducksFlock.performQuack();
    }

    @Test
    public void testDuckFlocksFly() {
        ducksFlock.performFly();
    }
}
