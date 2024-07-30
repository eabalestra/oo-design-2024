package decorator.starbuzz.condiment;

import decorator.starbuzz.beverage.Beverage;

public class Soy extends CondimentDecorator {
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
        return switch (beverage.getSize()) {
            case TALL -> 0.20 + beverage.cost();
            case GRANDE -> 0.15 + beverage.cost();
            case VENTI -> 0.10 + beverage.cost();
        };
	}
}
