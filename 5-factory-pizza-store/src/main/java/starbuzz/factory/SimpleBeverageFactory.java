package starbuzz.factory;

import starbuzz.Size;
import starbuzz.condiment.*;
import starbuzz.beverage.*;

public class SimpleBeverageFactory implements BeverageFactory {

    @Override
    public Beverage createBeverage(String type, Size size) {
        return switch (type) {
            case "DarkRoast" -> new DarkRoast(size);
            case "Decaf" -> new Decaf(size);
            case "Espresso" -> new Espresso(size);
            case "HouseBlend" -> new HouseBlend(size);
            case "Tea" -> new Tea(size);
            default -> throw new IllegalArgumentException("Invalid beverage entered: " + type);
        };
    }

    @Override
    public Beverage addCondiment(Beverage beverage, String condiment) {
        return switch (condiment) {
            case "Milk" -> new Milk(beverage);
            case "Mocha" -> new Mocha(beverage);
            case "Soy" -> new Soy(beverage);
            case "Whip" -> new Whip(beverage);
            case "Sugar" -> new Sugar(beverage);
            default -> throw new IllegalArgumentException("Invalid condiment entered: " + condiment);
        };
    }

}
