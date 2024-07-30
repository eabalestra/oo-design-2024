package barista;

public class BeverageTestDrive {
	public static void main(String[] args) {
		CaffeineBeverage tea = new Tea();
		CaffeineBeverage coffee = new Coffee();
		CaffeineBeverage mate = new Mate();
 		CaffeineBeverage blackCoffee = new BlackCoffee();

		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

		System.out.println("\n¿Vamos a tomar unos mates?");
		mate.prepareRecipe();

		System.out.println("\nMaking black coffee...");
		blackCoffee.prepareRecipe();
	}
}
