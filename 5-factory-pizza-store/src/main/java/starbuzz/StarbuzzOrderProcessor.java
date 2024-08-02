package starbuzz;

import starbuzz.factory.SimpleBeverageFactory;
import starbuzz.factory.BeverageFactory;

import java.util.List;

public class StarbuzzOrderProcessor {
    public static void main(String[] args) {
        BeverageFactory factory = new SimpleBeverageFactory();
        StarbuzzCoffee starbuzzCoffee = new StarbuzzCoffee(factory);

        String beverageType = "Espresso";
        Size size = Size.GRANDE;
        List<String> condiments = List.of("Milk", "Sugar");
        starbuzzCoffee.takeOrder(beverageType, size, condiments);

        beverageType = "HouseBlend";
        size = Size.VENTI;
        condiments = List.of("Mocha", "Whip");
        starbuzzCoffee.takeOrder(beverageType, size, condiments);
    }
}