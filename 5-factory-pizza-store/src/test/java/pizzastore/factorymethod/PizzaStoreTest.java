package pizzastore.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaStoreTest {

    @Test
    void orderARGMozzarellaPizza_ShouldReturnArgentineanMozzarellaPizza() {
        PizzaStore store = new ARGPizzaStore();

        Pizza pizza = store.orderPizza("muzza");

        assertEquals("Argentinean Mozzarella Pizza", pizza.getName());
    }

}