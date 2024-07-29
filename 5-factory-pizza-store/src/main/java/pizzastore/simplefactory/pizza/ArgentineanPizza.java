package pizzastore.simplefactory.pizza;

public class ArgentineanPizza extends Pizza {
    public ArgentineanPizza() {
        System.out.println("Sale una argentina papá!");
        name = "Argentinean Pizza";
        dough = "Thick crust";
        sauce = "sauce with diced onions";
        toppings.add("Mozzarella cheese");
        toppings.add("Sliced black olives");
    }
}
