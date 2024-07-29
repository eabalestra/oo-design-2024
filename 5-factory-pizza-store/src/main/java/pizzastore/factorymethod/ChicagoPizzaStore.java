package pizzastore.factorymethod;

import pizzastore.factorymethod.chapizza.ChicagoStyleCheesePizza;
import pizzastore.factorymethod.chapizza.ChicagoStyleClamPizza;
import pizzastore.factorymethod.chapizza.ChicagoStylePepperoniPizza;
import pizzastore.factorymethod.chapizza.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
