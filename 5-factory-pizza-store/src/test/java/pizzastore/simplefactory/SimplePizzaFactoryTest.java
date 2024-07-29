package pizzastore.simplefactory;

import org.junit.jupiter.api.Test;
import pizzastore.simplefactory.pizza.Pizza;

import static org.junit.jupiter.api.Assertions.*;

class SimplePizzaFactoryTest {
    @Test
    void createArgentineanPizza() {
        SimplePizzaFactory factory = new SimplePizzaFactory();

        Pizza pizza = factory.createPizza("argentinean");

        assertEquals("Argentinean Pizza", pizza.getName());
    }
}