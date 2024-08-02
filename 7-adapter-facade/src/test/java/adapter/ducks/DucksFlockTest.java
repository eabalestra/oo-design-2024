package adapter.ducks;

import adapter.ducks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DucksFlockTest {
    DucksFlock ducksFlock;


    @BeforeEach
    public void setUp() {
        List<Duck> ducks = List.of(new MallardDuck(), new MallardDuck());
        ducksFlock = new DucksFlock(ducks);
    }

    @Test
    public void testAddDuckToDucksFlock() {
        Duck newDuck = new MallardDuck();

        ducksFlock.add(newDuck);

        assertEquals(newDuck, ducksFlock.getDuck(2));
    }

    @Test
    public void testAddTurkeyToDucksFlock() {
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        ducksFlock.add(turkeyAdapter);

        assertEquals(turkeyAdapter, ducksFlock.getDuck(2));
    }

    @Test
    public void testAddDroneToDucksFlock() {
        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);

        ducksFlock.add(droneAdapter);

        assertEquals(droneAdapter, ducksFlock.getDuck(2));
    }

    @Test
    public void testDuckFlocksQuack() {
        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);
        ducksFlock.add(droneAdapter);
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        ducksFlock.add(turkeyAdapter);

        ducksFlock.performQuack();
    }

    @Test
    public void testDuckFlocksFly() {
        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);
        ducksFlock.add(droneAdapter);
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        ducksFlock.add(turkeyAdapter);

        ducksFlock.performFly();
    }
}
