package pizzastore.factorymethod.argpizza;

import pizzastore.factorymethod.Pizza;

public class ARGPepperoniPizza extends Pizza {
    public ARGPepperoniPizza() {
        name = "ARG Style Pepperoni Pizza";
        dough = "Thick Crust Dough";
        sauce = "Tomato Sauce";

        toppings.add("Mozzarella Cheese");
        toppings.add("Salame picado fino");
    }
}
