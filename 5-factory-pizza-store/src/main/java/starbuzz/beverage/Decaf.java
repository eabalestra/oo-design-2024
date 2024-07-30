package starbuzz.beverage;

import starbuzz.Size;

public class Decaf extends Beverage {
	public Decaf(Size size) {
		description = "Decaf Coffee";
		this.size = size;
	}
	public double cost() {
		return 1.05;
	}
}

