package adapter.ducks;

import java.util.ArrayList;
import java.util.List;

public class DucksFlock {
    List<Duck> duckList;

    public DucksFlock(List<Duck> duckList) {
        this.duckList = new ArrayList<>(duckList);
    }

    public void add(Duck duck) {
        duckList.add(duck);
    }

    public Duck getDuck(int i) {
        return duckList.get(i);
    }

    public void performFly() {
        for (Duck duck : duckList) {
            duck.fly();
        }
    }

    public void performQuack() {
        for (Duck duck : duckList) {
            duck.quack();
        }
    }

    public List<Duck> getDuckList() {
        return duckList;
    }

}
