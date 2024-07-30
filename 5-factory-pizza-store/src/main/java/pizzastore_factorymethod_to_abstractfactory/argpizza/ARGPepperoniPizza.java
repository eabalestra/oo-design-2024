package pizzastore_factorymethod_to_abstractfactory.argpizza;

import pizzastore_factorymethod_to_abstractfactory.Pizza;

public class ARGPepperoniPizza extends Pizza {
    public ARGPepperoniPizza() {
        name = "ARG Style Pepperoni Pizza";
        dough = "Thick Crust Dough";
        sauce = "Tomato Sauce";

        toppings.add("Mozzarella Cheese");
        toppings.add("Salame picado fino");
    }
}
