package starbuzz.beverage;

import starbuzz.Size;

public class Tea extends Beverage{
    public Tea(Size size) {
        description = "Tea";
        this.size = size;
    }

    public double cost() {
        return 1.5;
    }
}
