package duck_simulator;

import duck_simulator.duck.*;
import duck_simulator.fly.FlyRocketPowered;
import duck_simulator.fly.MockFlyWithJetpack;
import duck_simulator.quack.Quack;

import java.util.List;

public class DuckSimulator {
 
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
   
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

		Duck mute = new MuteDuck();
		mute.performFly();
		mute.performQuack();
		mute.setQuackBehavior(new Quack());
		System.out.println("I CAN QUACK");
		mute.performQuack();

		System.out.println("\n[DUCKS FLOCK]");
		DucksFlock ducksFlock = new DucksFlock(List.of(mallard, model, mute));
		ducksFlock.performFly();
		ducksFlock.performQuack();
	}

}
