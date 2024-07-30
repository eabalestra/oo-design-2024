package decorator.starbuzz.beverage;

import decorator.starbuzz.Size;

public abstract class Beverage {
	String description = "Unknown Beverage";
	Size size;

	public String getDescription() {
		return description;
	}

	public abstract double cost();

	public void setSize(Size size) {
		this.size = size;
	}

	public Size getSize() {
		return size;
	}

}
