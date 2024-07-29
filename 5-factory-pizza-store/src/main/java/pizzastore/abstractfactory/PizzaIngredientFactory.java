package pizzastore.abstractfactory;

import pizzastore.abstractfactory.pizzaingredient.cheese.Cheese;
import pizzastore.abstractfactory.pizzaingredient.clams.Clams;
import pizzastore.abstractfactory.pizzaingredient.dough.Dough;
import pizzastore.abstractfactory.pizzaingredient.pepperoni.Pepperoni;
import pizzastore.abstractfactory.pizzaingredient.sauce.Sauce;
import pizzastore.abstractfactory.pizzaingredient.veggies.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
