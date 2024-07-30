package pizzastore_factorymethod_to_abstractfactory.pizzafactory;

import pizzastore_factorymethod_to_abstractfactory.Pizza;
import pizzastore_factorymethod_to_abstractfactory.nypizza.NYStyleCheesePizza;
import pizzastore_factorymethod_to_abstractfactory.nypizza.NYStyleClamPizza;
import pizzastore_factorymethod_to_abstractfactory.nypizza.NYStylePepperoniPizza;
import pizzastore_factorymethod_to_abstractfactory.nypizza.NYStyleVeggiePizza;

public class NYPizzaFactory implements PizzaFactory {
    @Override
    public Pizza create(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        }
        return pizza;
    }
}
