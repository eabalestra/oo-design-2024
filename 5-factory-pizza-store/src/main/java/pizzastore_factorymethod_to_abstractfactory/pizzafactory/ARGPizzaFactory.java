package pizzastore_factorymethod_to_abstractfactory.pizzafactory;


import pizzastore_factorymethod_to_abstractfactory.Pizza;
import pizzastore_factorymethod_to_abstractfactory.argpizza.ARGMozzarellaPizza;
import pizzastore_factorymethod_to_abstractfactory.argpizza.ARGPepperoniPizza;

public class ARGPizzaFactory implements PizzaFactory {
    @Override
    public Pizza create(String type) {
        if (type.equals("muzza")) {
            return new ARGMozzarellaPizza();
        } else if (type.equals("calabresa")) {
            return new ARGPepperoniPizza();
        } else {
            throw new IllegalStateException("Sorry, we don't have that pizza");
        }
    }
}
