package barista;

public class BlackCoffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {}

    @Override
    boolean customerWantsCondiments() {
        return false;
    }
}
