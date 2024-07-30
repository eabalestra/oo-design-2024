package starbuzz.beverage;

import starbuzz.Size;

public class Espresso extends Beverage {

	public Espresso(Size size) {
		description = "Espresso Coffee";
		this.size = size;
	}
	public double cost() {
		return 1.90;
	}
}

