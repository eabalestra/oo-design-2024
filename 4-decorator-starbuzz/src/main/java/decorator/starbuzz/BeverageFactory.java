package decorator.starbuzz;

import decorator.starbuzz.beverage.*;
import decorator.starbuzz.condiment.*;

public class BeverageFactory {

    public Beverage createBeverage(String beverageType, Size size) {
        return switch (beverageType) {
            case "DarkRoast" -> new DarkRoast(size);
            case "Decaf" -> new Decaf(size);
            case "Espresso" -> new Espresso(size);
            case "HouseBlend" -> new HouseBlend(size);
            case "Tea" -> new Tea(size);
            default -> throw new IllegalArgumentException("Invalid beverage entered: " + beverageType);
        };
    }

    public Beverage createCondiment(Beverage beverage, String condimentType) {
        return switch (condimentType) {
            case "Milk" -> new Milk(beverage);
            case "Mocha" -> new Mocha(beverage);
            case "Soy" -> new Soy(beverage);
            case "Whip" -> new Whip(beverage);
            case "Sugar" -> new Sugar(beverage);
            default -> throw new IllegalArgumentException("Invalid condiment entered: " + condimentType);
        };
    }
}
