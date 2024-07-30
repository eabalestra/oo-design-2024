package decorator.starbuzz.condiment;

import decorator.starbuzz.Size;
import decorator.starbuzz.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	public abstract String getDescription();

	@Override
	public Size getSize() {
		return beverage.getSize();
	}
}
