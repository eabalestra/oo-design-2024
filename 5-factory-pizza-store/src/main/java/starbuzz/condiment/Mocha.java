package starbuzz.condiment;

import starbuzz.beverage.Beverage;

public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return switch (beverage.getSize()) {
			case TALL -> 0.55 + beverage.cost();
			case GRANDE -> 0.45 + beverage.cost();
			case VENTI -> 0.30 + beverage.cost();
		};
	}
}
