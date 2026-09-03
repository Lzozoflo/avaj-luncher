package src;

public class AircraftFactory {
    private int p_id = 0;

    private static AircraftFactory single_instance = null;
    
    private AircraftFactory(){}

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        if (single_instance == null)
            single_instance = new AircraftFactory();

        int tmp_id = single_instance.p_id; 
        single_instance.p_id++;

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
