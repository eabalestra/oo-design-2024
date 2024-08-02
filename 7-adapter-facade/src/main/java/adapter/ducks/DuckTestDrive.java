package adapter.ducks;

import java.util.List;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        Duck turkeyAdapter = new TurkeyAdapter(new WildTurkey());
        DucksFlock ducksFlock = new DucksFlock(List.of(duck, turkeyAdapter));

        for (Duck d : ducksFlock.getDuckList()) {
            System.out.println("\n" + d.getClass().getSimpleName() + " says...");
            d.fly();
            d.quack();
        }
    }
}
