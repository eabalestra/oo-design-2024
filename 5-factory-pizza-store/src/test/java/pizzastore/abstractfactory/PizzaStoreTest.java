package pizzastore.abstractfactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.*;

class PizzaStoreTest {
    PizzaIngredientFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ARGPizzaIngredientFactory();
    }

    @Test
    void createDough_ShouldReturnThinCrustDough() {
        Dough dough = factory.createDough();

        assertInstanceOf(ThinCrustDough.class, dough);
    }

    @Test
    void createSauce_ShouldReturnMarinaraSauce() {
        Sauce sauce = factory.createSauce();

        assertInstanceOf(MarinaraSauce.class, sauce);
    }

    @Test
    void createCheese_ShouldReturnMozzarellaCheese() {
        Cheese cheese = factory.createCheese();

        assertInstanceOf(MozzarellaCheese.class, cheese);
    }

    @Test
    void createVeggies_ShouldReturnArrayOfOnionAndBlackOlives() {
        Veggies[] veggies = factory.createVeggies();

        assertEquals(2, veggies.length);
        assertInstanceOf(Onion.class, veggies[0]);
        assertInstanceOf(BlackOlives.class, veggies[1]);
    }

    @Test
    void createPepperoni_ShouldReturnSlicedPepperoni() {
        Pepperoni pepperoni = factory.createPepperoni();

        assertInstanceOf(SlicedPepperoni.class, pepperoni);
    }

    @Test
    void createClam_ShouldReturnNull() {
        Clams clams = factory.createClam();

        assertNull(clams);
    }

}