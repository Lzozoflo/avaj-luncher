package src.Weather;
import java.util.ArrayList;
import java.util.List;

import src.Flyable.Aircraft;
import src.Flyable.Flyable;
import src.LogFile.LogFile;

public class Tower {

    private List<Flyable> AL = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        this.AL.add(p_flyable);
        Aircraft ac = (Aircraft)p_flyable;
        LogFile.getInstance().writeLog("Tower says: " + ac.getLogName() + " registered to weather tower.\n");
    }

    public void unregister(Flyable p_flyable) {
        this.AL.remove(p_flyable);
        Aircraft ac = (Aircraft)p_flyable;
        LogFile.getInstance().writeLog("Tower says: " + ac.getLogName() + " unregistered to weather tower.\n");
    }

    protected void conditionChanged() {
        List<Flyable> CAL = new ArrayList<Flyable>(AL);

        for (Flyable f : CAL){
            f.updateConditions();
            Aircraft ac = (Aircraft)f;
            int height = ac.getCoordinates().getHeight();

            if (height <= 0)
                this.unregister(f);
            else if (height > 100)
                height = 100;
        }
    }
}
