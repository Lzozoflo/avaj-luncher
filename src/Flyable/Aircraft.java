package src.Flyable;

import src.Coordinates;

public class Aircraft extends Flyable {
    long id;
    String name;
    Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate){
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Coordinates getCoordinates(){
        return this.coordinates;
    }
    public String getLogName(){
        return this.getClass().getSimpleName()+"#"+this.getName()+"("+this.getId()+")";
    }
    public void updateConditions(){}

}
