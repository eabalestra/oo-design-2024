package pizzastore.factorymethod;

import pizzastore.factorymethod.argpizza.ARGMozzarellaPizza;
import pizzastore.factorymethod.argpizza.ARGPepperoniPizza;

public class ARGPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String item) {
        if (item.equals("muzza")) {
            return new ARGMozzarellaPizza();
        } else if (item.equals("calabresa")) {
            return new ARGPepperoniPizza();
        } else {
            return null;
        }
    }
}
