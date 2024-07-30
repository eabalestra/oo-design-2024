package pizzastore_factorymethod_to_abstractfactory.pizzafactory;

import pizzastore_factorymethod_to_abstractfactory.Pizza;
import pizzastore_factorymethod_to_abstractfactory.chapizza.ChicagoStyleCheesePizza;
import pizzastore_factorymethod_to_abstractfactory.chapizza.ChicagoStyleClamPizza;
import pizzastore_factorymethod_to_abstractfactory.chapizza.ChicagoStylePepperoniPizza;
import pizzastore_factorymethod_to_abstractfactory.chapizza.ChicagoStyleVeggiePizza;

public class CHAPizzaFactory implements PizzaFactory {
    @Override
    public Pizza create(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
