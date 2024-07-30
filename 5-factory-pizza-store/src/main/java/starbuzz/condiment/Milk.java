package starbuzz.condiment;

import starbuzz.beverage.Beverage;

public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return switch (beverage.getSize()) {
			case TALL -> 0.30 + beverage.cost();
			case GRANDE -> 0.20 + beverage.cost();
			case VENTI -> 0.10 + beverage.cost();
		};
	}
}
