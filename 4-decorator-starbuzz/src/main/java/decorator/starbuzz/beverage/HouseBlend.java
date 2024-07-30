package decorator.starbuzz.beverage;

import decorator.starbuzz.Size;

public class HouseBlend extends Beverage {

	public HouseBlend(Size size) {
		description = "House Blend Coffee";
		this.size = size;
	}
 
	public double cost() {
		return .8;
	}
}

