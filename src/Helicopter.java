package src;

public class Helicopter extends Aircraft {


    public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
    }
    /*
        SUN - Longitude increases by 10, Height increases by 2
        RAIN - Longitude increases by 5
        FOG - Longitude increases by 1
        SNOW - Height decreases by 12
    */
    public void updateConditions(){
        Coordinates last_coordinates = this.coordinates;

        int longitude = last_coordinates.getLongitude();
        int latitude = last_coordinates.getLatitute();
        int height = last_coordinates.getHeight();
        String weather = this.weatherTower.getWeather(last_coordinates);
        switch (weather) {
            case "SUN":
                longitude += 10;
                height += 2;
                break;
        
            case "RAIN":
                longitude += 5;
                break;

            case "FOG":
                longitude += 1;
                break;

            case "SNOW":
                longitude -= 15;
                break;
            
                default:
                System.exit(42);
                break;
        }
        this.coordinates = new Coordinates(longitude, latitude, height);
    }
}
