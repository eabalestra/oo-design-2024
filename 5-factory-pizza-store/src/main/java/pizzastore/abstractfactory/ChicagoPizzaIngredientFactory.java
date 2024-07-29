package pizzastore.abstractfactory;

import pizzastore.abstractfactory.pizzaingredient.cheese.Cheese;
import pizzastore.abstractfactory.pizzaingredient.cheese.MozzarellaCheese;
import pizzastore.abstractfactory.pizzaingredient.clams.Clams;
import pizzastore.abstractfactory.pizzaingredient.clams.FrozenClams;
import pizzastore.abstractfactory.pizzaingredient.dough.Dough;
import pizzastore.abstractfactory.pizzaingredient.dough.ThickCrustDough;
import pizzastore.abstractfactory.pizzaingredient.pepperoni.Pepperoni;
import pizzastore.abstractfactory.pizzaingredient.pepperoni.SlicedPepperoni;
import pizzastore.abstractfactory.pizzaingredient.sauce.PlumTomatoSauce;
import pizzastore.abstractfactory.pizzaingredient.sauce.Sauce;
import pizzastore.abstractfactory.pizzaingredient.veggies.BlackOlives;
import pizzastore.abstractfactory.pizzaingredient.veggies.Eggplant;
import pizzastore.abstractfactory.pizzaingredient.veggies.Spinach;
import pizzastore.abstractfactory.pizzaingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(),
		                      new Spinach(),
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
