package stringCalculator.input;

public class MockInput implements Input{
    private String input;
    private boolean invoked;
    @Override
    public String getInput() {
        invoked = true;
        return input;
    }

    @Override
    public String input() {
        invoked = true;
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isInvoked() {
        return invoked;
    }

}
