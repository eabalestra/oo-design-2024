package pizzastore_factorymethod_to_abstractfactory;

import pizzastore_factorymethod_to_abstractfactory.pizzafactory.CHAPizzaFactory;
import pizzastore_factorymethod_to_abstractfactory.pizzafactory.NYPizzaFactory;
import pizzastore_factorymethod_to_abstractfactory.pizzafactory.PizzaFactory;

public class PizzaTestDrive {
 
	public static void main(String[] args) {
		PizzaFactory chaFactory = new CHAPizzaFactory();
		PizzaFactory nyFactory = new NYPizzaFactory();

		PizzaStore chicagoStore = new PizzaStore(chaFactory);
		PizzaStore nyStore = new PizzaStore(nyFactory);

		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = nyStore.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("clam");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = nyStore.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("pepperoni");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = nyStore.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
	}
}
