package starbuzz.factory;

import starbuzz.Size;
import starbuzz.beverage.Beverage;

public interface BeverageFactory {
    Beverage createBeverage(String type, Size size);
    Beverage addCondiment(Beverage beverage, String condiment);
}
