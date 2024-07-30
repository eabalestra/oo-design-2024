package pizzastore_factorymethod_to_abstractfactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pizzastore_factorymethod_to_abstractfactory.pizzafactory.ARGPizzaFactory;
import pizzastore_factorymethod_to_abstractfactory.pizzafactory.CHAPizzaFactory;
import pizzastore_factorymethod_to_abstractfactory.pizzafactory.NYPizzaFactory;
import pizzastore_factorymethod_to_abstractfactory.pizzafactory.PizzaFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PizzaStoreTest {
    PizzaStore pizzaStore;
    PizzaFactory pizzaFactory;
    Pizza pizza;

    @Test
    void createARGPepperoniPizza_ShouldReturnCorrectName() {
        pizzaFactory = new ARGPizzaFactory();
        pizzaStore = new PizzaStore(pizzaFactory);

        pizza = pizzaStore.orderPizza("calabresa");

        assertEquals("ARG Style Pepperoni Pizza", pizza.getName());
    }

    @ParameterizedTest
    @MethodSource("createPizzaProvider")
    void testCreatePizza_ShouldReturnCorrectName(PizzaFactory pizzaFactory, String type, String expected) {
        this.pizzaFactory = pizzaFactory;
        pizzaStore = new PizzaStore(this.pizzaFactory);

        pizza = pizzaStore.orderPizza(type);

        assertEquals(expected, pizza.getName());
    }

    private static Stream<Arguments> createPizzaProvider() {
        return Stream.of(
                Arguments.of(new ARGPizzaFactory(), "calabresa", "ARG Style Pepperoni Pizza"),
                Arguments.of(new ARGPizzaFactory(), "muzza", "Argentinean Mozzarella Pizza"),
                Arguments.of(new CHAPizzaFactory(), "pepperoni", "Chicago Style Pepperoni Pizza"),
                Arguments.of(new CHAPizzaFactory(), "cheese", "Chicago Style Deep Dish Cheese Pizza"),
                Arguments.of(new NYPizzaFactory(), "pepperoni", "NY Style Pepperoni Pizza"),
                Arguments.of(new NYPizzaFactory(), "cheese", "NY Style Sauce and Cheese Pizza")
        );
    }
}