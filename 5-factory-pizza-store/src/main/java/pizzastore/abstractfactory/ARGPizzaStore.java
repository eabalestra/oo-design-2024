package pizzastore.abstractfactory;

public class ARGPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza;
        PizzaIngredientFactory ingredientFactory = new ARGPizzaIngredientFactory();
        if (item.equals("muzza")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("ARG Style Cheese Pizza papá!");
        } else if (item.equals("calabresa")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("ARG Style Pepperoni Pizza papá!");
        } else {
            throw new IllegalStateException("Sorry, we don't have that pizza");
        }
        return pizza;
    }
}
