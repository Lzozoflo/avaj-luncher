package src.Flyable;

import src.Coordinates;

public class AircraftFactory {
    private int p_id = 1;

    private static AircraftFactory INSTANCE = null;
    
    private AircraftFactory(){}

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        if (INSTANCE == null)
            INSTANCE = new AircraftFactory();

        int tmp_id = INSTANCE.p_id; 
        INSTANCE.p_id++;

        switch (p_type) {
            case "Balloon":
                return new Balloon(tmp_id, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(tmp_id, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(tmp_id, p_name, p_coordinates);
        
            default:
                throw new IllegalArgumentException("Not a good Flyable accept only Balloon, Helicopter or JetPlane,");
        }
    }
}
