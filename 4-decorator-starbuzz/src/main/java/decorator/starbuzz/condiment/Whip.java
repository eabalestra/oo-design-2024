package decorator.starbuzz.condiment;

import decorator.starbuzz.beverage.Beverage;

public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	public double cost() {
		return switch (beverage.getSize()) {
			case TALL -> 0.30 + beverage.cost();
			case GRANDE -> 0.15 + beverage.cost();
			case VENTI -> 0.05 + beverage.cost();
		};
	}
}
