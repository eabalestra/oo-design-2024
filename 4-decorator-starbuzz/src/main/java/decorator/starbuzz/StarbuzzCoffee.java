package decorator.starbuzz;

import decorator.starbuzz.beverage.Beverage;
import decorator.starbuzz.beverage.DarkRoast;
import decorator.starbuzz.beverage.Espresso;
import decorator.starbuzz.beverage.HouseBlend;
import decorator.starbuzz.condiment.Mocha;
import decorator.starbuzz.condiment.Soy;
import decorator.starbuzz.condiment.Whip;

import java.util.List;

public class StarbuzzCoffee {
	BeverageFactory factory;

	public StarbuzzCoffee(BeverageFactory factory) {
		this.factory = factory;
	}

	public void takeOrder(String beverageType, Size size, List<String> condiments) {
		orderTaken();
		coffeeReady();

		Beverage beverage = factory.createBeverage(beverageType, size);
		beverage = applyCondiments(condiments, beverage);

		beverageDetails(beverage);
	}

	private static void beverageDetails(Beverage beverage) {
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
	}

	private static void coffeeReady() {
		System.out.println("Coffee is ready");
	}

	private static void orderTaken() {
		System.out.println("Order taken");
	}

	private Beverage applyCondiments(List<String> condiments, Beverage beverage) {
		for (String condiment : condiments) {
			beverage = factory.createCondiment(beverage, condiment);
		}
		return beverage;
	}
}
