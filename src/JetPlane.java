package src;

public class JetPlane extends Aircraft {
    
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
    }
    /*
        SUN - Latitude increases by 10, Height increases by 2
        RAIN - Latitude increases by 5
        FOG - Latitude increases by 1
        SNOW - Height decreases by 7
    */
    public void updateConditions(){
        Coordinates last_coordinates = this.coordinates;

        int longitude = last_coordinates.getLongitude();
        int latitude = last_coordinates.getLatitute();
        int height = last_coordinates.getHeight();
        String weather = this.weatherTower.getWeather(last_coordinates);
        switch (weather) {
            case "SUN":
                latitude += 10;
                height += 2;
                break;
        
            case "RAIN":
                latitude += 5;
                break;

            case "FOG":
                latitude += 1;
                break;

            case "SNOW":
                height -= 7;
                break;
            
                default:
                System.exit(42);
                break;
        }
        this.coordinates = new Coordinates(longitude, latitude, height);
    }

}
