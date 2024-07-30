package decorator.starbuzz.beverage;

import decorator.starbuzz.Size;

public class DarkRoast extends Beverage {
	public DarkRoast(Size size) {
		description = "Dark Roast Coffee";
		this.size = size;
	}
 
	public double cost() {
		return .90;
	}
}

