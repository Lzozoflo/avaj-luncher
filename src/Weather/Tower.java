package src.Weather;
import java.util.ArrayList;
import java.util.List;

import src.Flyable.Aircraft;
import src.Flyable.Flyable;

public class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        Aircraft ac = (Aircraft)p_flyable;
        System.out.println("Tower says: " + ac.getLogName() + " registered to weather tower.");
        this.observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable) {
        Aircraft ac = (Aircraft)p_flyable;
        System.out.println("Tower says: " + ac.getLogName() + " unregistered to weather tower.");
        this.observers.remove(p_flyable);
    }
    protected void conditionChanged() {

    }
}
