package pizzastore.abstractfactory;

import pizzastore.abstractfactory.pizzaingredient.cheese.Cheese;
import pizzastore.abstractfactory.pizzaingredient.cheese.MozzarellaCheese;
import pizzastore.abstractfactory.pizzaingredient.clams.Clams;
import pizzastore.abstractfactory.pizzaingredient.dough.Dough;
import pizzastore.abstractfactory.pizzaingredient.dough.ThinCrustDough;
import pizzastore.abstractfactory.pizzaingredient.pepperoni.Pepperoni;
import pizzastore.abstractfactory.pizzaingredient.pepperoni.SlicedPepperoni;
import pizzastore.abstractfactory.pizzaingredient.sauce.MarinaraSauce;
import pizzastore.abstractfactory.pizzaingredient.sauce.Sauce;
import pizzastore.abstractfactory.pizzaingredient.veggies.BlackOlives;
import pizzastore.abstractfactory.pizzaingredient.veggies.Onion;
import pizzastore.abstractfactory.pizzaingredient.veggies.Veggies;

public class ARGPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{   new Onion(),
                                new BlackOlives() };
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return null;
    }
}
