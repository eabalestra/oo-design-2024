package output;

public class MockOutput implements Output {

    private boolean invoked;
    private String printInput;

    @Override
    public void print(String toPrint) {
        invoked = true;
        printInput = toPrint;
    }

    public String getPrintInput() {
        return printInput;
    }

    public boolean isInvoked() {
        return invoked;
    }
}
