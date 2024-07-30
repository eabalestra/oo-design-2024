package barista;

public class Mate extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Haciendo la montañita, loco.");
    }

    @Override
    void addCondiments() {
        System.out.println("¡¿Qué condimentos?! el mate se toma amargo, gil.");
    }

    @Override
    boolean customerWantsCondiments() {
        return true;
    }
}
