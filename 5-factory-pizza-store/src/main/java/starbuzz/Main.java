package starbuzz;

import starbuzz.beverage.Beverage;
import starbuzz.factory.SimpleBeverageFactory;
import starbuzz.factory.BeverageFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BeverageFactory factory = new SimpleBeverageFactory();
        StarbuzzCoffee starbuzzCoffee = new StarbuzzCoffee(factory);

        starbuzzCoffee.takeOrder("Espresso", Size.GRANDE, List.of("Milk", "Sugar"));
    }
}
