package barista;

public class Tea extends CaffeineBeverage {
	public void brew() {
		System.out.println("Steeping the tea");
	}
	public void addCondiments() {
		System.out.println("Adding Lemon");
	}

	@Override
	boolean customerWantsCondiments() {
		return true;
	}
}
