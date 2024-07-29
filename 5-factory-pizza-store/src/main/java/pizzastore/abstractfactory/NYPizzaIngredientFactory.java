package pizzastore.abstractfactory;

import pizzastore.abstractfactory.pizzaingredient.cheese.Cheese;
import pizzastore.abstractfactory.pizzaingredient.cheese.ReggianoCheese;
import pizzastore.abstractfactory.pizzaingredient.clams.Clams;
import pizzastore.abstractfactory.pizzaingredient.clams.FreshClams;
import pizzastore.abstractfactory.pizzaingredient.dough.Dough;
import pizzastore.abstractfactory.pizzaingredient.dough.ThinCrustDough;
import pizzastore.abstractfactory.pizzaingredient.pepperoni.Pepperoni;
import pizzastore.abstractfactory.pizzaingredient.pepperoni.SlicedPepperoni;
import pizzastore.abstractfactory.pizzaingredient.sauce.MarinaraSauce;
import pizzastore.abstractfactory.pizzaingredient.sauce.Sauce;
import pizzastore.abstractfactory.pizzaingredient.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
