package bowling.roll;

public class Roll {
    public static final int NUM_OF_PINS = 10;
    public static final int MIN_NUM_OF_PINS = 0;
    private final int pins;

    public Roll(int pins) {
        if (pins < MIN_NUM_OF_PINS || pins > NUM_OF_PINS) {
            throw new IllegalArgumentException("Invalid number of pins");
        }
        this.pins = pins;
    }

    public int pins() {
        return pins;
    }
}