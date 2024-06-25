package stringCalculator.output;

public class MockOutput implements Output {

    private boolean invoked;
    private int valueToPrint;

    @Override
    public void print(int toPrint) {
        invoked = true;
        valueToPrint = toPrint;
    }

    public boolean isInvoked() {
        return invoked;
    }

    public int getValueToPrint() {
        return valueToPrint;
    }

}

