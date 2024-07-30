package pizzastore_factorymethod_to_abstractfactory.pizzafactory;

import pizzastore_factorymethod_to_abstractfactory.Pizza;

public interface PizzaFactory {
    Pizza create(String type);
}
