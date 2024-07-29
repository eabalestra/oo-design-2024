package pizzastore.factorymethod.argpizza;

import pizzastore.factorymethod.Pizza;

public class ARGMozzarellaPizza extends Pizza {
    public ARGMozzarellaPizza() {
        name = "Argentinean Mozzarella Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";

        toppings.add("Sliced Mozzarella");
        toppings.add("Grated parmesan cheese");
    }
}
